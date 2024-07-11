package model.services.impl;

import db.DatabaseConnection;
import model.User;
import model.services.UserService;

import java.sql.*;
import java.util.Map;

public class UserServiceImpl implements UserService {

    private final String INSERT_USER =
            "INSERT INTO users (login, name, surname, email, password, phone_number)" +
            "VALUES (?, ?, ?, ?, ?, ?)";

    private final String UPDATE_USER =
            "UPDATE users " +
            "SET login = ?, " +
            "name = ?, " +
            "surname = ?, " +
            "email = ?, " +
            "password = ?, " +
            "phone_number = ? " +
            "WHERE id = ?";

    public final String SELECT_USER_BY_ID =
            "SELECT login, name, surname, email, password, phone_number " +
            "FROM users WHERE id = ?";


    @Override
    public boolean createUser(Map<String, Object> userValues) {
        if (!userValues.containsKey("login")) {
            System.err.println("No login field error");
            return false;
        } else if (!userValues.containsKey("name")) {
            System.err.println("No name field error");
            return false;
        } else if (!userValues.containsKey("surname")) {
            System.err.println("No surname field error");
            return false;
        } else if (!userValues.containsKey("email")) {
            System.err.println("No email field error");
            return false;
        } else if (!userValues.containsKey("password")) {
            System.err.println("No password field error");
            return false;
        } else if (!userValues.containsKey("phone_number")) {
            System.err.println("No phone_number field error");
            return false;
        }

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, (String) userValues.get("login"));
            preparedStatement.setString(2, (String) userValues.get("name"));
            preparedStatement.setString(3, (String) userValues.get("surname"));
            preparedStatement.setString(4, (String) userValues.get("email"));
            preparedStatement.setString(5, (String) userValues.get("password"));
            preparedStatement.setString(6, (String) userValues.get("phone_number"));
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
    public boolean modifyUser(Map<String, Object> modifiedValues, User originalUser) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return false;
        }

        long id = originalUser.getId();
        if (!modifiedValues.containsKey("login")) {
            modifiedValues.put("login", originalUser.getLogin());
        }
        if (!modifiedValues.containsKey("name")) {
            modifiedValues.put("name", originalUser.getName());
        }
        if (!modifiedValues.containsKey("surname")) {
            modifiedValues.put("surname", originalUser.getSurname());
        }
        if (!modifiedValues.containsKey("email")) {
            modifiedValues.put("email", originalUser.getEmail());
        }
        if (!modifiedValues.containsKey("password")) {
            modifiedValues.put("password", originalUser.getPassword());
        }
        if (!modifiedValues.containsKey("phone_number")) {
            modifiedValues.put("phone_number", originalUser.getPhoneNumber());
        }

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, (String) modifiedValues.get("login"));
            preparedStatement.setString(2, (String) modifiedValues.get("name"));
            preparedStatement.setString(3, (String) modifiedValues.get("surname"));
            preparedStatement.setString(4, (String) modifiedValues.get("email"));
            preparedStatement.setString(5, (String) modifiedValues.get("password"));
            preparedStatement.setString(6, (String) modifiedValues.get("phone_number"));
            preparedStatement.setLong(7, id);
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
    public User getUserById(long id) {
        User user = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(id,
                        resultSet.getString("login"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone_number")
                );
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return user;
    }
}
