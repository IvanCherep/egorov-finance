package ru.sut.egorov.finance.model.dao.impl.postgre;

import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.model.dao.CategoryDao;
import ru.sut.egorov.finance.model.dao.CheckingAccountDao;
import ru.sut.egorov.finance.model.dao.RecordDao;
import ru.sut.egorov.finance.model.dao.UserDao;
import ru.sut.egorov.finance.model.entity.Record;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecordDaoImpl implements RecordDao {

    public final String SELECT_ALL_RECORDS =
            "SELECT id, " +
                    "name, " +
                    "category_id, " +
                    "money_amount, " +
                    "transaction_date, " +
                    "record_creator_user_id, " +
                    "record_creation_timestamp, " +
                    "record_last_modifier_user_id, " +
                    "record_last_modified_date, " +
                    "from_checking_account_id, " +
                    "to_checking_account_id, " +
                    "is_removed " +
                    "FROM records " +
                    "WHERE is_removed = false";

    public final String SELECT_ALL_RECORDS_IDS =
            "SELECT id, " +
                    "FROM records " +
                    "WHERE is_removed = false";

    public final String SELECT_RECORD_BY_ID =
            "SELECT id, " +
                    "name, " +
                    "category_id, " +
                    "money_amount, " +
                    "transaction_date, " +
                    "record_creator_user_id, " +
                    "record_creation_timestamp, " +
                    "record_last_modifier_user_id, " +
                    "record_last_modified_date, " +
                    "from_checking_account_id, " +
                    "to_checking_account_id, " +
                    "is_removed " +
                    "FROM records " +
                    "WHERE id = ? and is_removed = false";

    private final String INSERT_RECORD =
            "INSERT INTO records " +
                    "(name, " +
                    "category_id, " +
                    "money_amount, " +
                    "transaction_date, " +
                    "record_creator_user_id, " +
                    "record_creation_timestamp, " +
                    "record_last_modifier_user_id, " +
                    "record_last_modified_date, " +
                    "from_checking_account_id, " +
                    "to_checking_account_id)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final String UPDATE_RECORDS =
            "UPDATE records " +
                    "SET name = ?, " +
                    "category_id = ?, " +
                    "money_amount = ?, " +
                    "transaction_date = ?, " +
                    "record_creator_user_id = ?, " +
                    "record_creation_timestamp = ?, " +
                    "record_last_modifier_user_id = ?, " +
                    "record_last_modified_date = ?, " +
                    "from_checking_account_id = ?, " +
                    "to_checking_account_id = ?" +
                    "WHERE id = ?";

    private final String REMOVE_RECORD =
            "UPDATE records " +
                    "SET is_removed = true " +
                    "WHERE id = ?";

    @Override
    public Record findById(Long id) {
        CategoryDao categoryDao = new CategoryDaoImpl();
        UserDao userDao = new UserDaoImpl();
        CheckingAccountDao checkingAccountDao = new CheckingAccountDaoImpl();
        Record record = null;

        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_RECORD_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                record = new Record(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        categoryDao.findById(resultSet.getLong("category_id")),
                        resultSet.getDouble("money_amount"),
                        resultSet.getLong("transaction_date"),
                        userDao.findById(resultSet.getLong("record_creator_user_id")),
                        resultSet.getLong("record_creation_timestamp"),
                        userDao.findById(resultSet.getLong("record_last_modifier_user_id")),
                        resultSet.getLong("record_last_modified_date"),
                        checkingAccountDao.findById(resultSet.getLong("from_checking_account_id")),
                        checkingAccountDao.findById(resultSet.getLong("to_checking_account_id")),
                        resultSet.getBoolean("is_removed")
                );
            }

        } catch (SQLException e) {
            System.err.println("RecordDaoImpl.findById(Long id) method exception! " + e.getMessage());
        }

        return record;
    }

    @Override
    public boolean create(Record record) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RECORD);
            preparedStatement.setString(1, record.getName());
            preparedStatement.setLong(2, record.getCategory().getId());
            preparedStatement.setDouble(3, record.getMoneyAmount());
            preparedStatement.setDouble(4, record.getTransactionDate());
            preparedStatement.setLong(5, record.getRecordCreatorUser().getId());
            preparedStatement.setLong(6, record.getRecordCreationTimestamp());
            preparedStatement.setLong(7, record.getRecordLastModifierUser().getId());
            preparedStatement.setLong(8, record.getRecordLastModifiedDate());
            preparedStatement.setLong(9, record.getFromCheckingAccount().getId());
            preparedStatement.setLong(10, record.getToCheckingAccount().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("RecordDaoImpl.save(Record record) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public List<Record> find() {
        CategoryDao categoryDao = new CategoryDaoImpl();
        UserDao userDao = new UserDaoImpl();
        CheckingAccountDao checkingAccountDao = new CheckingAccountDaoImpl();

        List<Record> records = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_RECORDS);
            while (resultSet.next()) {
                records.add(new Record(
                                resultSet.getLong("id"),
                                resultSet.getString("name"),
                                categoryDao.findById(resultSet.getLong("category_id")),
                                resultSet.getDouble("money_amount"),
                                resultSet.getLong("transaction_date"),
                                userDao.findById(resultSet.getLong("record_creator_user_id")),
                                resultSet.getLong("record_creation_timestamp"),
                                userDao.findById(resultSet.getLong("record_last_modifier_user_id")),
                                resultSet.getLong("record_last_modified_date"),
                                checkingAccountDao.findById(resultSet.getLong("from_checking_account_id")),
                                checkingAccountDao.findById(resultSet.getLong("to_checking_account_id")),
                                resultSet.getBoolean("is_removed")
                        )
                );
            }
        } catch (SQLException e) {
            System.err.println("RecordDaoImpl.find() method exception: " + e.getMessage());
        }

        return records;
    }

    @Override
    public boolean update(Record record) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            Record existingRecord = findById(record.getId());
            if (existingRecord != null) {
                return false;
            }
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_RECORDS);
            preparedStatement.setString(1, record.getName());
            preparedStatement.setLong(2, record.getCategory().getId());
            preparedStatement.setDouble(3, record.getMoneyAmount());
            preparedStatement.setDouble(4, record.getTransactionDate());
            preparedStatement.setLong(5, record.getRecordCreatorUser().getId());
            preparedStatement.setLong(6, record.getRecordCreationTimestamp());
            preparedStatement.setLong(7, record.getRecordLastModifierUser().getId());
            preparedStatement.setLong(8, record.getRecordLastModifiedDate());
            preparedStatement.setLong(9, record.getFromCheckingAccount().getId());
            preparedStatement.setLong(10, record.getToCheckingAccount().getId());
            preparedStatement.setLong(11, record.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("RecordDaoImpl.save(Record record) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public boolean remove(Long id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_RECORD);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.err.println("RecordDaoImpl.remove(Long id) method exception! " + e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public long[] findIds() {
        return new long[0];
    }

}
