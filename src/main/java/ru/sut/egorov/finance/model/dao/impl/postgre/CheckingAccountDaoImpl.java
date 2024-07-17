package ru.sut.egorov.finance.model.dao.impl.postgre;

import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.model.dao.CheckingAccountDao;
import ru.sut.egorov.finance.model.dao.CurrencyDao;
import ru.sut.egorov.finance.model.dao.UserDao;
import ru.sut.egorov.finance.model.entity.CheckingAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CheckingAccountDaoImpl implements CheckingAccountDao {

    public final String SELECT_ALL_CHECKING_ACCOUNTS =
            "SELECT id, user_id, name, currency_id, is_removed " +
                    "FROM checking_accounts " +
                    "WHERE is_removed = false";

    public final String SELECT_CHECKING_ACCOUNT_BY_ID =
            "SELECT id, user_id, name, currency_id, is_removed " +
                    "FROM checking_accounts " +
                    "WHERE id = ? and is_removed = false";

    private final String INSERT_CHECKING_ACCOUNT =
            "INSERT INTO checking_accounts (user_id, name, currency_id)" +
                    "VALUES (?, ?, ?)";

    private final String UPDATE_CHECKING_ACCOUNT =
            "UPDATE checking_accounts " +
                    "SET user_id = ?, " +
                    "name = ?, " +
                    "currency_id = ?, " +
                    "WHERE id = ?";

    private final String REMOVE_CHECKING_ACCOUNT =
            "UPDATE checking_accounts " +
                    "SET is_removed = true " +
                    "WHERE id = ?";

    @Override
    public CheckingAccount findById(Long id) {
        UserDao userDao = new UserDaoImpl();
        CurrencyDao currencyDao = new CurrencyDaoImpl();
        CheckingAccount checkingAccount = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHECKING_ACCOUNT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                checkingAccount = new CheckingAccount(
                        resultSet.getLong("id"),
                        userDao.findById(resultSet.getLong("user_id")),
                        resultSet.getString("name"),
                        currencyDao.findById(resultSet.getLong("currency_id")),
                        resultSet.getBoolean("is_removed")
                );
            }

        } catch (SQLException e) {
            System.err.println("CheckingAccountDaoImpl.findById(Long id) method exception! " + e.getMessage());
        }

        return checkingAccount;
    }

    @Override
    public boolean create(CheckingAccount checkingAccount) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CHECKING_ACCOUNT);
            preparedStatement.setLong(1, checkingAccount.getUser().getId());
            preparedStatement.setString(2, checkingAccount.getName());
            preparedStatement.setLong(3, checkingAccount.getCurrency().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("CheckingAccountDaoImpl.save(CheckingAccount checkingAccount) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<CheckingAccount> find() {
        UserDao userDao = new UserDaoImpl();
        CurrencyDao currencyDao = new CurrencyDaoImpl();
        List<CheckingAccount> checkingAccounts = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CHECKING_ACCOUNTS);
            while (resultSet.next()) {
                checkingAccounts.add(
                        new CheckingAccount(
                                resultSet.getLong("id"),
                                userDao.findById(resultSet.getLong("user_id")),
                                resultSet.getString("name"),
                                currencyDao.findById(resultSet.getLong("currency_id")),
                                resultSet.getBoolean("is_removed")
                        )
                );
            }

        } catch (SQLException e) {
            System.err.println("CheckingAccountDaoImpl.find() method exception: " + e.getMessage());
        }

        return checkingAccounts;
    }

    @Override
    public boolean update(CheckingAccount checkingAccount) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            CheckingAccount existingCheckingAccount = findById(checkingAccount.getId());
            if (existingCheckingAccount != null) {
                return false;
            }
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CHECKING_ACCOUNT);
                preparedStatement.setLong(1, checkingAccount.getUser().getId());
                preparedStatement.setString(2, checkingAccount.getName());
                preparedStatement.setLong(3, checkingAccount.getCurrency().getId());
                preparedStatement.setLong(4, checkingAccount.getId());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("CheckingAccountDaoImpl.save(CheckingAccount checkingAccount) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean remove(Long id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_CHECKING_ACCOUNT);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("CheckingAccountDaoImpl.remove(Long id) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }
}
