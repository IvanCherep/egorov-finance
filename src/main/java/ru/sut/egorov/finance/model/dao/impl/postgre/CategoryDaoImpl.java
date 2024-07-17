package ru.sut.egorov.finance.model.dao.impl.postgre;

import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.model.dao.CategoryDao;
import ru.sut.egorov.finance.model.entity.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    public final String SELECT_ALL_CATEGORIES =
            "SELECT id, name, is_income, is_removed " +
                    "FROM categories " +
                    "WHERE is_removed = false";

    public final String SELECT_CATEGORY_BY_ID =
            "SELECT id, name, is_income, is_removed " +
                    "FROM categories " +
                    "WHERE id = ? and is_removed = false";

    private final String INSERT_CATEGORY =
            "INSERT INTO categories (name, is_income)" +
                    "VALUES (?, ?)";

    private final String UPDATE_CATEGORIES =
            "UPDATE categories " +
                    "SET name = ?, " +
                    "is_income = ?, " +
                    "WHERE id = ?";

    private final String REMOVE_CATEGORY =
            "UPDATE categories " +
                    "SET is_removed = true " +
                    "WHERE id = ?";

    @Override
    public List<Category> find() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CATEGORIES);
            while (resultSet.next()) {
                categories.add(
                        new Category(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                resultSet.getBoolean("is_income"),
                                resultSet.getBoolean("is_removed")
                        )
                );
            }

        } catch (SQLException e) {
            System.err.println("CategoryDaoImpl.find() method exception: " + e.getMessage());
        }

        return categories;
    }

    @Override
    public Category findById(Long id) {
        Category category = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                category = new Category(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("is_income"),
                        resultSet.getBoolean("is_removed")
                );
            }

        } catch (SQLException e) {
            System.err.println("CategoryDaoImpl.findById(Long id) method exception! " + e.getMessage());
        }

        return category;
    }

    @Override
    public boolean save(Category category) {
        boolean categoryIdIsNull = false;
        boolean categoryAlreadyExists = false;
        try (Connection connection = DatabaseConnection.getConnection()) {
            if (category.getId() == null) {
                categoryIdIsNull = true;
            }
            if (!categoryIdIsNull) {
                Category existingCategory = findById(category.getId());
                if (existingCategory != null) {
                    categoryAlreadyExists = true;
                }
            }
            if (categoryAlreadyExists) {
                PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORIES);
                preparedStatement.setString(1, category.getName());
                preparedStatement.setBoolean(2, category.getIncome());
                preparedStatement.setLong(3, category.getId());
                preparedStatement.executeUpdate();
            } else {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
                preparedStatement.setString(1, category.getName());
                preparedStatement.setBoolean(2, category.getIncome());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("CategoryDaoImpl.save(Category category) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean update(Category category) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Category existingCategory = findById(category.getId());
            if (existingCategory == null) {
                    return false;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORIES);
            preparedStatement.setString(1, category.getName());
            preparedStatement.setBoolean(2, category.getIncome());
            preparedStatement.setLong(3, category.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("CategoryDaoImpl.update(Category category) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean create(Category category) {
        try (Connection connection = DatabaseConnection.getConnection()) {
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
                preparedStatement.setString(1, category.getName());
                preparedStatement.setBoolean(2, category.getIncome());
                preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("CategoryDaoImpl.create(Category category) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean remove(Long id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_CATEGORY);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("CategoryDaoImpl.remove(Long id) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }
}
