package view;

import model.Category;
import model.DatabaseConnection;
import model.services.CategoryService;
import model.services.impl.CategoryServiceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

//TODO подумать над бекапом
//TODO написать имплементацию для всех сервисов
public class Test {

    static final String QUERY = "SELECT id, name FROM categories";

    public static void main(String[] args) {
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.getCategories();
        for (Category category: categories) {
            System.out.println(category);;
        }

        System.out.println();
        System.out.println(categoryService.getCategoryById(2));
//        Connection connection = DatabaseConnection.getConnection();
//        try {
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(QUERY);
//            while (resultSet.next()) {
//                System.out.printf("ID: %d; NAME: %s%n", resultSet.getLong("id"), resultSet.getString("name"));
//            }
//
//        } catch (SQLException e) {
//            System.err.println("SQL error: " + e.getMessage());
//        } finally {
//            if (connection != null) {
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    System.err.println("Error closing connection: " + e.getMessage());
//                }
//            }
//        }
    }

}
