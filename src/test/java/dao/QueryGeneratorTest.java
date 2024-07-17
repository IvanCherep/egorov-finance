package dao;

import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.db.DatabaseInitializer;
import ru.sut.egorov.finance.model.dao.impl.postgre.QueryGenerator;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QueryGeneratorTest {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDB(connection);

        String tableName = "users";
        List<String> columnNames = new ArrayList<>();
        columnNames.add("login");
        columnNames.add("name");
        columnNames.add("surname");
        columnNames.add("email");
        columnNames.add("password");
        columnNames.add("phone_number");

        String insertUser = QueryGenerator.generateInsertString(tableName, columnNames);
        System.out.println(insertUser);
        // INSERT INTO users (login, name, surname, email, password, phone_number) VALUES (?, ?, ?, ?, ?, ?)

        Map<String, Object> columnNameValueMap = new HashMap<>();
        columnNameValueMap.put("login", "generator_login");
        columnNameValueMap.put("name", "generator_name");
        columnNameValueMap.put("surname", "generator_surname");
        columnNameValueMap.put("email", "test.generate@generate.com");
        columnNameValueMap.put("password", "generator_password");
        columnNameValueMap.put("phone_number", "+00000000000");
        System.out.println(QueryGenerator.create(tableName, columnNameValueMap));
    }

}
