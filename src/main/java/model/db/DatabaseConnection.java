package model.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Класс предоставляющий подключение к базе данных
 * Класс является сингалтоном
 * Текущая реализация не является потокобезопасной
 */
public class DatabaseConnection {

    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(inputStream);
            inputStream.close();
            String db = properties.getProperty("db");
            String username = properties.getProperty("user");
            String password = properties.getProperty("password");
            String port = properties.getProperty("port");
            String url = String.format("jdbc:postgresql://localhost:%s/%s", port, db);
            connection = DriverManager.getConnection(url, username, password);
        } catch (FileNotFoundException e) {
            System.err.println("db properties file not found, add db.properties file in src/main/resources" + e.getMessage());
            return connection;
        } catch (IOException e) {
            System.err.println("can't read from file error: " + e.getMessage());
            return connection;
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }

        return connection;
    }

}
