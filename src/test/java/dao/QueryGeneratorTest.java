package dao;

import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.db.DatabaseInitializer;
import ru.sut.egorov.finance.model.dao.impl.postgre.QueryGenerator;
import ru.sut.egorov.finance.model.dao.impl.postgre.QueryGeneratorWrapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class QueryGeneratorTest {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDB(connection);

        String tableName = "users";
        QueryGeneratorWrapper queryGeneratorWrapper = new QueryGeneratorWrapper();
        Map<String, String> columnNameValueMap = new HashMap<>();
        columnNameValueMap.put("login", "generator_login");
        columnNameValueMap.put("name", "generator_name");
        columnNameValueMap.put("surname", "generator_surname");
        columnNameValueMap.put("email", "test.generate@generate.com");
        columnNameValueMap.put("password", "generator_password");
        columnNameValueMap.put("phone_number", "+00000000000");
        queryGeneratorWrapper.setColumnNameStringMap(columnNameValueMap);
        try {
            System.out.println(QueryGenerator.create(tableName, queryGeneratorWrapper));
        } catch (SQLException e) {
            System.err.println("Insert data error!");
        }
    }

}
