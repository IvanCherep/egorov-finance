package model.services.impl;

import model.CheckingAccount;
import model.Currency;
import model.db.DatabaseConnection;
import model.User;
import model.services.CheckingAccountService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckingAccountServiceImpl implements CheckingAccountService {

    private final String INSERT_CHECKING_ACCOUNT =
            "INSERT INTO checking_accounts (user_id, name, currency_id)" +
            "VALUES (?, ?, ?)";

    private final String UPDATE_CHECKING_ACCOUNT =
            "UPDATE checking_accounts " +
            "SET user_id = ?, " +
            "name = ?, " +
            "currency_id = ? " +
            "WHERE id = ?";

    public final String SELECT_ACCOUNT_BY_ID = "SELECT a.id AS a_id, " +
            "a.name AS a_name, " +
            "u.id AS u_id, " +
            "u.login AS u_login, " +
            "u.name AS u_name, " +
            "u.surname AS u_surname, " +
            "u.email AS u_email, " +
            "u.password AS u_password, " +
            "u.phone_number AS u_phone_number " +
            "FROM accounts AS a " +
            "INNER JOIN users AS u " +
            "ON a.user_id = u.id " +
            "WHERE a.id = ?";

    public final String SELECT_CHECKING_ACCOUNT_BY_USER =
            "SELECT " +
            "ca.id AS checking_account_id, " +
            "ca.name AS checking_account_name, " +
            "u.id AS user_id, " +
            "u.login AS user_login, " +
            "u.name AS user_name, " +
            "u.surname AS user_surname, " +
            "u.email AS user_email, " +
            "u.password AS user_password, " +
            "u.phone_number AS user_phone_number, " +
            "c.id AS currency_id, " +
            "c.name AS currency_name, " +
            "c.sign AS currency_sign " +
            "FROM checking_accounts AS ca " +
            "INNER JOIN users AS u " +
            "ON ca.user_id = u.id " +
            "INNER JOIN currencies AS c " +
            "ON ca.currency_id = c.id " +
            "WHERE u.id = ?";

    public final String SELECT_CHECKING_ACCOUNT_BY_ID =
            "SELECT " +
                    "ca.id AS checking_account_id, " +
                    "ca.name AS checking_account_name, " +
                    "u.id AS user_id, " +
                    "u.login AS user_login, " +
                    "u.name AS user_name, " +
                    "u.surname AS user_surname, " +
                    "u.email AS user_email, " +
                    "u.password AS user_password, " +
                    "u.phone_number AS user_phone_number, " +
                    "c.id AS currency_id, " +
                    "c.name AS currency_name, " +
                    "c.sign AS currency_sign " +
                    "FROM checking_accounts AS ca " +
                    "INNER JOIN users AS u " +
                    "ON ca.user_id = u.id " +
                    "INNER JOIN currencies AS c " +
                    "ON ca.currency_id = c.id " +
                    "WHERE ca.id = ?";

    @Override
    public boolean createAccount(Map<String, Object> accountValues) {
        if (!accountValues.containsKey("user_id")) {
            System.err.println("No user_id field error");
            return false;
        } else if (!accountValues.containsKey("name")) {
            System.err.println("No name field error");
            return false;
        } else if(!accountValues.containsKey("currency_id")) {
            System.err.println("No currency_id field error");
            return false;
        }

        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CHECKING_ACCOUNT);
            preparedStatement.setLong(1, ((User) accountValues.get("user_id")).getId());
            preparedStatement.setString(2, (String) accountValues.get("name"));
            preparedStatement.setLong(3, ((Currency) accountValues.get("currency_id")).getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("SQLException in createUser method: " + ex.getMessage());
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing connection: " + e.getMessage());
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean modifyAccount(Map<String, Object> modifiedValues, CheckingAccount originalCheckingAccount) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return false;
        }

        long id = originalCheckingAccount.getId();
        if (!modifiedValues.containsKey("login")) {
            modifiedValues.put("user_id", originalCheckingAccount.getUser());
        }
        if (!modifiedValues.containsKey("name")) {
            modifiedValues.put("name", originalCheckingAccount.getName());
        }
        if (!modifiedValues.containsKey("currency_id")) {
            modifiedValues.put("currency_id", originalCheckingAccount.getCurrency());
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CHECKING_ACCOUNT);
            preparedStatement.setLong(1, ((User) modifiedValues.get("user_id")).getId());
            preparedStatement.setString(2, (String) modifiedValues.get("name"));
            preparedStatement.setLong(3, ((Currency) modifiedValues.get("currency_id")).getId());
            preparedStatement.setLong(4, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Failed to close connection error: " + e.getMessage());
                return false;
            }
        }

        return true;
    }

    @Override
    public CheckingAccount getCheckingAccountById(Long id) {
        CheckingAccount checkingAccount = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHECKING_ACCOUNT_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                checkingAccount = new CheckingAccount(
                        resultSet.getLong("checking_account_id"),
                        new User (
                                resultSet.getLong("user_id"),
                                resultSet.getString("user_login"),
                                resultSet.getString("user_name"),
                                resultSet.getString("user_surname"),
                                resultSet.getString("user_email"),
                                resultSet.getString("user_password"),
                                resultSet.getString("user_phone_number")
                        ),
                        resultSet.getString("checking_account_name"),
                        new Currency(
                                resultSet.getLong("currency_id"),
                                resultSet.getString("currency_name"),
                                resultSet.getString("currency_sign")
                        ));
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return checkingAccount;
    }

    @Override
    public List<CheckingAccount> getCheckingAccountsByUser(User user) {
        List<CheckingAccount> checkingAccounts = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CHECKING_ACCOUNT_BY_USER);
            preparedStatement.setLong(1, user.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                checkingAccounts.add(new CheckingAccount(
                        resultSet.getLong("checking_account_id"),
                        new User (
                                resultSet.getLong("user_id"),
                                resultSet.getString("user_login"),
                                resultSet.getString("user_name"),
                                resultSet.getString("user_surname"),
                                resultSet.getString("user_email"),
                                resultSet.getString("user_password"),
                                resultSet.getString("user_phone_number")
                        ),
                        resultSet.getString("checking_account_name"),
                        new Currency(
                                resultSet.getLong("currency_id"),
                                resultSet.getString("currency_name"),
                                resultSet.getString("currency_sign")
                        )));
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return checkingAccounts;
    }
}
