package model.services.impl;

import model.Category;
import model.db.DatabaseConnection;
import model.services.CategoryService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService {

    static final String SELECT_ALL_CATEGORIES = "SELECT id, name, is_income FROM categories";
    static final String SELECT_CATEGORY_BY_ID = "SELECT id, name, is_income FROM categories WHERE id = ?";
    static final String INSERT_CATEGORY = "INSERT INTO categories (name, is_income) VALUES (?, ?)";
    static final String UPDATE_CATEGORY = "UPDATE categories SET name = ? WHERE id = ?";

    @Override
    public boolean createCategory(Map<String, Object> categoryValues) {
        if (!categoryValues.containsKey("name")) {
            System.out.println("No name field error");
            return false;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
            preparedStatement.setString(1, (String) categoryValues.get("name"));
            preparedStatement.setBoolean(1, (Boolean) categoryValues.get("is_income"));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("SQLException in createCategory method: " + ex.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public Category getCategoryById(long id) {
        ;
        try (Connection connection = DatabaseConnection.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Category(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("is_income"));
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return null;
    }

    @Override
    public boolean modifyCategory(Map<String, Object> modifiedValues, Category originalCategory) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return false;
        }

        long categoryId = originalCategory.getId();
        if (!modifiedValues.containsKey("name")) {
            modifiedValues.put("name", originalCategory.getName());
        }
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY);
            preparedStatement.setString(1, (String) modifiedValues.get("name"));
            preparedStatement.setLong(2, categoryId);
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
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CATEGORIES);
            while (resultSet.next()) {
                categories.add(new Category(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getBoolean("is_income")
                ));
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return categories;
    }
}
