package model.services.impl;

import model.Category;
import model.DatabaseConnection;
import model.services.CategoryService;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService {

    static final String SELECT_ALL_CATEGORIES = "SELECT id, name FROM categories";
    static final String SELECT_CATEGORY_BY_ID = "SELECT id, name FROM categories WHERE id = ?";
    static final String INSERT_CATEGORY = "INSERT INTO categories (name) VALUES (?)";

    @Override
    public boolean createCategory(Map<String, Object> categoryValues) {
        if (!categoryValues.containsKey("name")) {
            System.out.println("No name field error");
            return false;
        }

        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CATEGORY);
            preparedStatement.setString(1, (String) categoryValues.get("name"));
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("SQLException in createCategory method: " + ex.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public Category getCategoryById(long id) {
        Connection connection = DatabaseConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                return new Category(resultSet.getLong("id"), resultSet.getString("name"));
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        Connection connection = DatabaseConnection.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_CATEGORIES);
            while (resultSet.next()) {
                categories.add(new Category(resultSet.getLong("id"), resultSet.getString("name")));
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return categories;
    }

    @Override
    public boolean modifyCategory(Map<String, Object> modifiedValues, Category originalCategory) {
        long categoryId = originalCategory.getId();

        return false;
    }
}
