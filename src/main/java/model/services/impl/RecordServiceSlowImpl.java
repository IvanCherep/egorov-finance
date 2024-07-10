package model.services.impl;

import model.*;
import model.Record;
import model.db.DatabaseConnection;
import model.services.CategoryService;
import model.services.CheckingAccountService;
import model.services.RecordService;
import model.services.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RecordServiceSlowImpl implements RecordService {

    static final String SELECT_ALL_RECORDS_BY_CHECKING_ACCOUNT =
            "SELECT " +
            "id " +
            "name, " +
            "category_id, " +
            "money_amount, " +
            "transaction_date, " +
            "record_creator_user_id, " +
            "record_creation_timestamp, " +
            "record_last_modifier_user_id, " +
            "record_last_modified_date, " +
            "from_checking_account_id, " +
            "to_checking_account_id " +
            "FROM records " +
            "WHERE from_checking_account_id = ?";


    @Override
    public boolean createRecord(Map<String, Object> recordValues) {
        return false;
    }

    @Override
    public boolean modifyRecord(Map<String, Object> recordValues, Record originalRecord) {
        return false;
    }

    @Override
    public List<Record> getRecordsByIds(List<Long> ids) {
        return List.of();
    }

    @Override
    public double getTotalBalance(Date date, User user) {
        return 0;
    }

    @Override
    public double getTotalBalanceByDate(Date dateFrom, Date dateTo, User user) {
        return 0;
    }

    @Override
    public double getAccountBalance(Date date, User user, CheckingAccount checkingAccount) {
        return 0;
    }

    @Override
    public double getAccountBalanceByDate(Date dateFrom, Date dateTo, User user, CheckingAccount checkingAccount) {
        return 0;
    }

    @Override
    public List<Record> getRecords() {
        return List.of();
    }

    @Override
    public List<Record> getRecordsByCheckingAccount(Long checkingAccountId) {
        List<Record> records = new ArrayList<>();
        CategoryService categoryService = new CategoryServiceImpl();
        UserService userService = new UserServiceImpl();
        CheckingAccountService checkingAccountService = new CheckingAccountServiceImpl();
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RECORDS_BY_CHECKING_ACCOUNT);
            preparedStatement.setLong(1, checkingAccountId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                records.add(new Record(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        categoryService.getCategoryById(resultSet.getLong("category_id")),
                        resultSet.getDouble("record_money_amount"),
                        resultSet.getLong("record_transaction_date"),
                        userService.getUserById(resultSet.getLong("record_creator_user_id")),
                        resultSet.getLong("record_creation_timestamp"),
                        userService.getUserById(resultSet.getLong("record_last_modifier_user_id")),
                        resultSet.getLong("record_last_modified_date"),
                        checkingAccountService.getCheckingAccountById(resultSet.getLong("from_checking_account_id")),
                        checkingAccountService.getCheckingAccountById(resultSet.getLong("to_checking_account_id"))
                        ));
            }

        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        }

        return records;
    }
}
