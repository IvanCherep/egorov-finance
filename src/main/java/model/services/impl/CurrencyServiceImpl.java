package model.services.impl;

import model.Currency;
import model.db.DatabaseConnection;
import model.services.CurrencyService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CurrencyServiceImpl implements CurrencyService {

    static final String SELECT_ALL_CURRENCIES = "SELECT id, name, sign FROM currencies";
    static final String SELECT_CURRENCY_BY_ID = "SELECT id, name, sign FROM currencies WHERE id = ?";
    static final String INSERT_CURRENCY = "INSERT INTO currencies (name, sign) VALUES (?, ?)";
    static final String UPDATE_CURRENCY = "UPDATE currencies SET name = ?, sign = ? WHERE id = ?";

    @Override
    public boolean createCurrency(Map<String, Object> currencyValues) {
        if (!currencyValues.containsKey("name")) {
            System.err.println("No name field error");
            return false;
        } else if (!currencyValues.containsKey("sign")) {
            System.err.println("No sign field error");
            return false;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CURRENCY);
            preparedStatement.setString(1, (String) currencyValues.get("name"));
            preparedStatement.setString(2, (String) currencyValues.get("sign"));;
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("SQLException in createCategory method: " + ex.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public Currency getCurrencyById(Long id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CURRENCY_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Currency(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("sign")
                );
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public List<Currency> getCurrencies() {
        List<Currency> currencies = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CURRENCIES);
            while (resultSet.next()) {
                currencies.add(new Currency(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("sign")));
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return currencies;
    }

    @Override
    public boolean modifyCurrency(Map<String, Object> modifiedValues, Currency originalCurrency) {
        Long id = originalCurrency.getId();
        if (!modifiedValues.containsKey("name")) {
            modifiedValues.put("name", originalCurrency.getName());
        }
        if (!modifiedValues.containsKey("sign")) {
            modifiedValues.put("sign", originalCurrency.getSign());
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CURRENCY);
            preparedStatement.setString(1, (String) modifiedValues.get("name"));
            preparedStatement.setString(2, (String) modifiedValues.get("sign"));
            preparedStatement.setLong(3, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
            return false;
        }

        return true;
    }
}
