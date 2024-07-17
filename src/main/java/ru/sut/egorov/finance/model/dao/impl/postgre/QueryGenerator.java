package ru.sut.egorov.finance.model.dao.impl.postgre;

import ru.sut.egorov.finance.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class QueryGenerator {

    public static boolean create(QueryGeneratorWrapper queryGeneratorWrapper) {

        return true;
    }

    @Deprecated
    public static boolean create(String tableName, Map<String, Object> columnNameValueMap) {
        List<String> columnNames = new ArrayList<>();
        for (String key: columnNameValueMap.keySet()) {
            columnNames.add(key);
        }
        String insertString = generateInsertString(tableName, columnNames);
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            int counter = 1;
            for (Map.Entry<String, Object> entry: columnNameValueMap.entrySet()) {
                Object object = entry.getValue();
                if (object instanceof String) {
                    preparedStatement.setString(counter, (String) object);
                } else if (object instanceof Long) {
                    preparedStatement.setLong(counter, (Long) object);
                } else if (object instanceof Double) {
                    preparedStatement.setDouble(counter, (Double) object);
                } else if (object instanceof Boolean) {
                    preparedStatement.setBoolean(counter, (Boolean) object);
                } else {
                    System.err.println(String.format("No resolvable column %s error!", entry.getKey()));
                    return false;
                }
                counter++;
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("QueryGenerator.create(String tableName, Map<String, Object> columnNameValueMap) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    private static String generateInsertString(String tableName, List<String> columnNames) {
        // StringBuilder быстрый, но потоко не безопасный. Поэтому при добавлении многопоточности
        // необходимо использовать StringBuffer
        StringBuilder insertData = new StringBuilder(String.format("INSERT INTO %s (", tableName));
        for (int i = 0; i < columnNames.size() - 1; i++) {
            insertData.append(String.format("%s, ", columnNames.get(i)));
        }
        insertData.append(String.format("%s) VALUES (", columnNames.get(columnNames.size() - 1)));
        for (int i = 0; i < columnNames.size() - 1; i++) {
            insertData.append(String.format("?, ", columnNames.get(i)));
        }
        insertData.append("?)");

        return insertData.toString();
    }

}
