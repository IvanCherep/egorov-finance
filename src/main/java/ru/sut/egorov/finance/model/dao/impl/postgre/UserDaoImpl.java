package ru.sut.egorov.finance.model.dao.impl.postgre;

import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.model.dao.UserDao;
import ru.sut.egorov.finance.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public final String SELECT_ALL_USERS =
            "SELECT id, login, name, surname, email, password, phone_number, is_removed " +
                    "FROM users " +
                    "WHERE is_removed = false";

    public final String SELECT_USER_BY_ID =
            "SELECT id, login, name, surname, email, password, phone_number, is_removed " +
                    "FROM users " +
                    "WHERE id = ? and is_removed = false";

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

    private final String REMOVE_USER =
            "UPDATE users " +
                    "SET is_removed = true " +
                    "WHERE id = ?";

    @Override
    public List<User> find() {
        List<User> users = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_USERS);
            while (resultSet.next()) {
                users.add(
                        new User(
                                resultSet.getLong("id"),
                                resultSet.getString("login"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getString("email"),
                                resultSet.getString("password"),
                                resultSet.getString("phone_number"),
                                resultSet.getBoolean("is_removed")
                        )
                );
            }

        } catch (SQLException e) {
            System.err.println("UserDaoImpl.find() method exception: " + e.getMessage());
        }

        return users;
    }

    @Override
    public User findById(Long id) {
        User user = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("login"),
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("email"),
                        resultSet.getString("password"),
                        resultSet.getString("phone_number"),
                        resultSet.getBoolean("is_removed")
                );
            }

        } catch (SQLException e) {
            System.err.println("UserDaoImpl.findById(Long id) method exception! " + e.getMessage());
        }

        return user;
    }

    @Override
    public boolean save(User user) {
        boolean userIdIsNull = false;
        boolean userAlreadyExists = false;
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (user.getId() == null) {
                userIdIsNull = true;
            }
            if (!userIdIsNull) {
                User existingUser = findById(user.getId());
                if (existingUser != null) {
                    userAlreadyExists = true;
                }
            }
            if (userAlreadyExists) {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getSurname());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPassword());
                preparedStatement.setString(6, user.getPhoneNumber());
                preparedStatement.setLong(7, user.getId());
                preparedStatement.executeUpdate();
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);
                preparedStatement.setString(1, user.getLogin());
                preparedStatement.setString(2, user.getName());
                preparedStatement.setString(3, user.getSurname());
                preparedStatement.setString(4, user.getEmail());
                preparedStatement.setString(5, user.getPassword());
                preparedStatement.setString(6, user.getPhoneNumber());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("UserDaoImpl.save(User user) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean remove(Long id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_USER);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("UserDaoImpl.remove(Long id) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }
}
