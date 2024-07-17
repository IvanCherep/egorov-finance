package ru.sut.egorov.finance.model.dao.impl.postgre;

import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.model.dao.CurrencyDao;
import ru.sut.egorov.finance.model.entity.Currency;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CurrencyDaoImpl implements CurrencyDao {

    public final String SELECT_ALL_CURRENCIES =
            "SELECT id, name, sign, is_removed " +
                    "FROM currencies " +
                    "WHERE is_removed = false";

    public final String SELECT_CURRENCY_BY_ID =
            "SELECT id, name, sign, is_removed " +
                    "FROM currencies " +
                    "WHERE id = ? and is_removed = false";

    private final String INSERT_CURRENCY =
            "INSERT INTO currencies (name, sign)" +
                    "VALUES (?, ?, ?)";

    private final String UPDATE_CURRENCIES =
            "UPDATE currencies " +
                    "SET name = ?, " +
                    "sign = ?, " +
                    "WHERE id = ?";

    private final String REMOVE_CURRENCY =
            "UPDATE currencies " +
                    "SET is_removed = true " +
                    "WHERE id = ?";

    @Override
    public Currency findById(Long id) {
        Currency currency = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CURRENCY_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                currency = new Currency(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("sign"),
                        resultSet.getBoolean("is_removed")
                );
            }

        } catch (SQLException e) {
            System.err.println("CurrencyDaoImpl.findById(Long id) method exception! " + e.getMessage());
        }

        return currency;
    }

    @Override
    public boolean create(Currency currency) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CURRENCY);
            preparedStatement.setString(1, currency.getName());
            preparedStatement.setString(2, currency.getSign());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("CurrencyDaoImpl.save(Currency currency) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<Currency> find() {
        List<Currency> currencies = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CURRENCIES);
            while (resultSet.next()) {
                currencies.add(
                        new Currency(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getString("sign"),
                                resultSet.getBoolean("is_removed")
                        )
                );
            }

        } catch (SQLException e) {
            System.err.println("CurrencyDaoImpl.find() method exception: " + e.getMessage());
        }

        return currencies;
    }

    @Override
    public boolean update(Currency currency) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Currency existingCurrency = findById(currency.getId());
            if (existingCurrency != null) {
                return false;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CURRENCIES);
            preparedStatement.setString(1, currency.getName());
            preparedStatement.setString(2, currency.getSign());
            preparedStatement.setLong(3, currency.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("CurrencyDaoImpl.save(Currency currency) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean remove(Long id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_CURRENCY);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("CurrencyDaoImpl.remove(Long id) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }
}
