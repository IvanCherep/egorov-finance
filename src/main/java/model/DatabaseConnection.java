package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection() {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/efdb";
            //TODO логин и пароль храниться в файле настроек, файл настроек добавить в .gitignore
            //прописать на гитхабе, как создать файл для подключения к бд (db.config в папке resources)
            String username = "ef";
            String password = "ef";
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.err.println("Connection error: " + e.getMessage());
        }

        return connection;
    }

}
