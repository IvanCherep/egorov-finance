package ru.sut.egorov.finance.model.dao.impl.postgre;

import ru.sut.egorov.finance.db.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class QueryGenerator {

    @Deprecated
    public static boolean create(String tableName, QueryGeneratorWrapper queryGeneratorWrapper) throws SQLException {
        List<String> columnNames = getColumnNames(queryGeneratorWrapper);
        String insertString = generateInsertString(tableName, columnNames);

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(insertString);
            int counter = 1;
            for (Map.Entry<String, Long> entry: queryGeneratorWrapper.getColumnNameLongMap().entrySet()) {
                preparedStatement.setLong(counter, entry.getValue());
                counter++;
            }
            for (Map.Entry<String, Double> entry: queryGeneratorWrapper.getColumnNameDoubleMap().entrySet()) {
                preparedStatement.setDouble(counter, entry.getValue());
                counter++;
            }
            for (Map.Entry<String, Boolean> entry: queryGeneratorWrapper.getColumnNameBooleanMap().entrySet()) {
                preparedStatement.setBoolean(counter, entry.getValue());
                counter++;
            }
            for (Map.Entry<String, String> entry: queryGeneratorWrapper.getColumnNameStringMap().entrySet()) {
                preparedStatement.setString(counter, entry.getValue());
                counter++;
            }
            for (Map.Entry<String, Date> entry: queryGeneratorWrapper.getColumnNameDateMap().entrySet()) {
                preparedStatement.setDate(counter, new java.sql.Date(entry.getValue().getTime()));
                counter++;
            }
            preparedStatement.executeUpdate();
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

//    private static String generateUpdateString(String tableName, List<String> columnNames) {
//        // StringBuilder быстрый, но потоко не безопасный. Поэтому при добавлении многопоточности
//        // необходимо использовать StringBuffer
//        StringBuilder insertData = new StringBuilder(String.format("INSERT INTO %s (", tableName));
//        for (int i = 0; i < columnNames.size() - 1; i++) {
//            insertData.append(String.format("%s, ", columnNames.get(i)));
//        }
//        insertData.append(String.format("%s) VALUES (", columnNames.get(columnNames.size() - 1)));
//        for (int i = 0; i < columnNames.size() - 1; i++) {
//            insertData.append(String.format("?, ", columnNames.get(i)));
//        }
//        insertData.append("?)");
//
//        return insertData.toString();
//    }

    private static List<String> getColumnNames(QueryGeneratorWrapper queryGeneratorWrapper) {
        List<String> columnNames = new ArrayList<>();
        columnNames.addAll(queryGeneratorWrapper.getColumnNameLongMap().keySet());
        columnNames.addAll(queryGeneratorWrapper.getColumnNameDoubleMap().keySet());
        columnNames.addAll(queryGeneratorWrapper.getColumnNameBooleanMap().keySet());
        columnNames.addAll(queryGeneratorWrapper.getColumnNameStringMap().keySet());
        columnNames.addAll(queryGeneratorWrapper.getColumnNameDateMap().keySet());

        return columnNames;
    }

}
