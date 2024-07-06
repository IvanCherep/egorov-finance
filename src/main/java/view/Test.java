package view;

import model.Category;
import model.DatabaseConnection;
import model.DatabaseInitializer;
import model.Record;
import model.services.CategoryService;
import model.services.impl.CategoryServiceImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO подумать над бекапом
//TODO написать имплементацию для всех сервисов
public class Test {

    static final String QUERY = "SELECT id, name FROM categories";

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        System.out.println(DatabaseInitializer.initializeDB(connection));
    }

}
