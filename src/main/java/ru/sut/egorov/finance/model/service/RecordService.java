package ru.sut.egorov.finance.model.service;

import ru.sut.egorov.finance.model.entity.Category;
import ru.sut.egorov.finance.model.entity.CheckingAccount;
import ru.sut.egorov.finance.model.entity.Record;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface RecordService {

    public boolean save(Map<String, Object> recordValues);

    public boolean remove(Long id);

    public BigDecimal getAccountBalanceByFilters(Map<String, Object> filters);

    // Если нет фильтров, то метод возвращает все записи
    public List<Record> getRecordsByFilter(Map<String, Object> filters);

    public List<Record> getRecordsByCheckingAccount(Long checkingAccountId);

    public Map<Category, Integer> getPercentByCategory(CheckingAccount checkingAccount);
}

////
////    static final String SELECT_ALL_RECORDS =
////            "SELECT " +
////            "r.id record_id," +
////            "r.name record_name, " +
////            "c.id category_id, " +
////            "c.name category_name, " +
////            "c.is_income category_is_income, " +
////            "r.money_amount record_money_amount, " +
////            "r.transaction_date record_transaction_date, " +
////            "uc.id record_creator_user_id," +
////            "uc.login record_creator_user_login, " +
////            "uc.name record_creator_user_name, " +
////            "uc.surname record_creator_user_surname, " +
////            "uc.email record_creator_user_email, " +
////            "uc.password record_creator_user_password, " +
////            "uc.phone_number record_creator_user_phone_number, " +
////            "r.record_creation_timestamp record_creation_timestamp, " +
////            "um.id record_last_modifier_user_id, " +
////            "um.login record_last_modifier_user_login, " +
////            "um.name record_last_modifier_user_name, " +
////            "um.surname record_last_modifier_user_surname, " +
////            "um.email record_last_modifier_user_email, " +
////            "um.password record_last_modifier_user_password, " +
////            "um.phone_number record_last_modifier_user_phone_number, " +
////            "r.record_last_modified_date record_last_modified_date, " +
////            "fca.id from_checking_account_id," +
////            "fcau.id from_checking_account_user_id, " +
////            "fcau.login from_checking_account_user_login, " +
////            "fcau.name from_checking_account_user_name, " +
////            "fcau.surname from_checking_account_user_surname, " +
////            "fcau.email from_checking_account_user_email, " +
////            "fcau.password from_checking_account_user_password, " +
////            "fcau.phone_number from_checking_account_user_phone_number, " +
////            "fca.name from_checking_account_name," +
////            "fcac.id from_checking_account_currency_id, " +
////            "fcac.name from_checking_account_currency_name, " +
////            "fcac.sign from_checking_account_currency_sign, " +
////            "tca.id to_checking_account_id, " +
////            "tcau.id to_checking_account_user_id, " +
////            "tcau.login to_checking_account_user_login, " +
////            "tcau.name to_checking_account_user_name, " +
////            "tcau.surname to_checking_account_user_surname, " +
////            "tcau.email to_checking_account_user_email, " +
////            "tcau.password to_checking_account_user_password, " +
////            "tcau.phone_number to_checking_account_user_phone_number, " +
////            "tca.name to_checking_account_name, " +
////            "tcac.id to_checking_account_currency_id, " +
////            "tcac.name to_checking_account_currency_name, " +
////            "tcac.sign to_checking_account_currency_sign " +
////            "FROM records r " +
////            "INNER JOIN categories c " +
////            "ON c.id = r.category_id " +
////            "INNER JOIN users uc " +
////            "ON uc.id = r.record_creator_user_id " +
////            "INNER JOIN users um " +
////            "ON um.id = r.record_last_modifier_user_id " +
////            "INNER JOIN checking_accounts fca " +
////            "ON fca.id = r.from_checking_account_id " +
////            "INNER JOIN users fcau " +
////            "ON fca.user_id = fcau.id " +
////            "INNER JOIN currencies fcac " +
////            "ON fca.currency_id = fcac.id " +
////            "INNER JOIN checking_accounts tca " +
////            "ON tca.id = r.to_checking_account_id " +
////            "INNER JOIN users tcau " +
////            "ON tca.user_id = tcau.id " +
////            "INNER JOIN currencies tcac " +
////            "ON tca.currency_id = tcac.id";
////
////    static final String SELECT_ALL_RECORDS_BY_CHECKING_ACCOUNT =
////            "SELECT " +
////                    "r.id record_id," +
////                    "r.name record_name, " +
////                    "c.id category_id, " +
////                    "c.name category_name, " +
////                    "c.is_income category_is_income, " +
////                    "r.money_amount record_money_amount, " +
////                    "r.transaction_date record_transaction_date, " +
////                    "uc.id record_creator_user_id," +
////                    "uc.login record_creator_user_login, " +
////                    "uc.name record_creator_user_name, " +
////                    "uc.surname record_creator_user_surname, " +
////                    "uc.email record_creator_user_email, " +
////                    "uc.password record_creator_user_password, " +
////                    "uc.phone_number record_creator_user_phone_number, " +
////                    "r.record_creation_timestamp record_creation_timestamp, " +
////                    "um.id record_last_modifier_user_id, " +
////                    "um.login record_last_modifier_user_login, " +
////                    "um.name record_last_modifier_user_name, " +
////                    "um.surname record_last_modifier_user_surname, " +
////                    "um.email record_last_modifier_user_email, " +
////                    "um.password record_last_modifier_user_password, " +
////                    "um.phone_number record_last_modifier_user_phone_number, " +
////                    "r.record_last_modified_date record_last_modified_date, " +
////                    "fca.id from_checking_account_id," +
////                    "fcau.id from_checking_account_user_id, " +
////                    "fcau.login from_checking_account_user_login, " +
////                    "fcau.name from_checking_account_user_name, " +
////                    "fcau.surname from_checking_account_user_surname, " +
////                    "fcau.email from_checking_account_user_email, " +
////                    "fcau.password from_checking_account_user_password, " +
////                    "fcau.phone_number from_checking_account_user_phone_number, " +
////                    "fca.name from_checking_account_name," +
////                    "fcac.id from_checking_account_currency_id, " +
////                    "fcac.name from_checking_account_currency_name, " +
////                    "fcac.sign from_checking_account_currency_sign, " +
////                    "tca.id to_checking_account_id, " +
////                    "tcau.id to_checking_account_user_id, " +
////                    "tcau.login to_checking_account_user_login, " +
////                    "tcau.name to_checking_account_user_name, " +
////                    "tcau.surname to_checking_account_user_surname, " +
////                    "tcau.email to_checking_account_user_email, " +
////                    "tcau.password to_checking_account_user_password, " +
////                    "tcau.phone_number to_checking_account_user_phone_number, " +
////                    "tca.name to_checking_account_name, " +
////                    "tcac.id to_checking_account_currency_id, " +
////                    "tcac.name to_checking_account_currency_name, " +
////                    "tcac.sign to_checking_account_currency_sign " +
////                    "FROM records r " +
////                    "INNER JOIN categories c " +
////                    "ON c.id = r.category_id " +
////                    "INNER JOIN users uc " +
////                    "ON uc.id = r.record_creator_user_id " +
////                    "INNER JOIN users um " +
////                    "ON um.id = r.record_last_modifier_user_id " +
////                    "INNER JOIN checking_accounts fca " +
////                    "ON fca.id = r.from_checking_account_id " +
////                    "INNER JOIN users fcau " +
////                    "ON fca.user_id = fcau.id " +
////                    "INNER JOIN currencies fcac " +
////                    "ON fca.currency_id = fcac.id " +
////                    "INNER JOIN checking_accounts tca " +
////                    "ON tca.id = r.to_checking_account_id " +
////                    "INNER JOIN users tcau " +
////                    "ON tca.user_id = tcau.id " +
////                    "INNER JOIN currencies tcac " +
////                    "ON tca.currency_id = tcac.id " +
////                    "WHERE fca.id = ?";
////
////    static final String INSERT_RECORD =
////            "INSERT INTO records " +
////                    "(name, " +
////                    "category_id, " +
////                    "money_amount, " +
////                    "transaction_date, " +
////                    "record_creator_user_id, " +
////                    "record_creation_timestamp, " +
////                    "record_last_modifier_user_id, " +
////                    "record_last_modified_date, " +
////                    "from_checking_account_id, " +
////                    "to_checking_account_id) " +
////                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
////
////
////
////
////    // " +
////    //            "WHERE r.record_creator_user_id = 42
////
////    static final String SELECT_ALL_CURRENCIES = "SELECT id, name, sign FROM currencies";
////    static final String SELECT_CURRENCY_BY_ID = "SELECT id, name, sign FROM currencies WHERE id = ?";
////    static final String INSERT_CURRENCY = "INSERT INTO currencies (name, sign) VALUES (?, ?)";
////    static final String UPDATE_CURRENCY = "UPDATE currencies SET name = ?, sign = ? WHERE id = ?";
////
////    @Override
////    public boolean createRecord(Map<String, Object> recordValues) {
////        boolean result = true;
////        if (!recordValues.containsKey("name")) {
////            System.err.println("No name field error");
////            result = false;
////        }
////        if (!recordValues.containsKey("category_id")) {
////            System.err.println("No category_id field error");
////            result = false;
////        }
////        if (!recordValues.containsKey("money_amount")) {
////            System.err.println("No money_amount field error");
////            result = false;
////        }
////        if (!recordValues.containsKey("transaction_date")) {
////            System.err.println("No transaction_date field error");
////            result = false;
////        }
////        if (!recordValues.containsKey("record_creator_user_id")) {
////            System.err.println("No record_creator_user_id field error");
////            result = false;
////        }
////        if (!recordValues.containsKey("record_creation_timestamp")) {
////            System.err.println("No record_creation_timestamp field error");
////            result = false;
////        }
////        if (!recordValues.containsKey("record_last_modifier_user_id")) {
////            System.err.println("No record_last_modifier_user_id field error");
////            result = false;
////        }
////        if (!recordValues.containsKey("record_last_modified_date")) {
////            System.err.println("No record_last_modified_date field error");
////            result = false;
////        }
////        if (!recordValues.containsKey("from_checking_account_id")) {
////            System.err.println("No from_checking_account_id field error");
////            result = false;
////        }
////        if (!recordValues.containsKey("to_checking_account_id")) {
////            System.err.println("No to_checking_account_id field error");
////            result = false;
////        }
////
////        if (result == false) {
////            return result;
////        }
////
////        try (Connection connection = DatabaseConnection.getConnection()) {
////            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RECORD);
////            preparedStatement.setString(1, (String) recordValues.get("name"));
////            preparedStatement.setLong(2, ((Category) recordValues.get("category_id")).getId());
////            preparedStatement.setDouble(3, (Double) recordValues.get("money_amount"));
////            preparedStatement.setLong(4, (Long) recordValues.get("transaction_date"));
////            preparedStatement.setLong(5, ((User) recordValues.get("record_creator_user_id")).getId());
////            preparedStatement.setLong(6, (Long) recordValues.get("record_creation_timestamp"));
////            preparedStatement.setLong(7, ((User) recordValues.get("record_last_modifier_user_id")).getId());
////            preparedStatement.setLong(8, (Long) recordValues.get("record_last_modified_date"));
////            preparedStatement.setLong(9, ((CheckingAccount) recordValues.get("from_checking_account_id")).getId());
////            preparedStatement.setLong(10, ((CheckingAccount) recordValues.get("to_checking_account_id")).getId());
////            preparedStatement.executeUpdate();
////        } catch (SQLException ex) {
////            System.err.println("SQLException in createRecord method: " + ex.getMessage());
////            return false;
////        }
////
////        return true;
////    }
////
////    @Override
////    public boolean modifyRecord(Map<String, Object> recordValues, Record originalRecord) {
////        return false;
////    }
////
////    @Override
////    public List<Record> getRecordsByIds(List<Long> ids) {
////        return List.of();
////    }
////
////    @Override
////    public double getCurrentBalance(CheckingAccount checkingAccount) {
////        return 0;
////    }
////
////    @Override
////    public double getCheckingAccountBalanceByDate(Date dateFrom, Date dateTo, CheckingAccount checkingAccount) {
////        return 0;
////    }
////
////    @Override
////    public double getAccountBalanceByFilter(Map<String, Object> filters) {
////        return 0;
////    }
////
////    @Override
////    public double getCheckingAccountsRecordsByFilter(Map<String, Object> filters) {
////        return 0;
////    }
////
////    @Override
////    public List<Record> getRecords() {
////        List<Record> records = new ArrayList<>();
////        try (Connection connection = DatabaseConnection.getConnection()) {
////            Statement statement = connection.createStatement();
////            ResultSet resultSet = statement.executeQuery(SELECT_ALL_RECORDS);
////            while (resultSet.next()) {
////                records.add(new Record(
////                        resultSet.getLong("record_id"),
////                        resultSet.getString("record_name"),
////                        new Category(
////                                resultSet.getLong("category_id"),
////                                resultSet.getString("category_name"),
////                                resultSet.getBoolean("category_is_income")
////                        ),
////                        resultSet.getDouble("record_money_amount"),
////                        resultSet.getLong("record_transaction_date"),
////                        new User(
////                                resultSet.getLong("record_creator_user_id"),
////                                resultSet.getString("record_creator_user_login"),
////                                resultSet.getString("record_creator_user_name"),
////                                resultSet.getString("record_creator_user_surname"),
////                                resultSet.getString("record_creator_user_email"),
////                                resultSet.getString("record_creator_user_password"),
////                                resultSet.getString("record_creator_user_phone_number")
////                        ),
////                        resultSet.getLong("record_creation_timestamp"),
////                        new User(
////                                resultSet.getLong("record_last_modifier_user_id"),
////                                resultSet.getString("record_last_modifier_user_login"),
////                                resultSet.getString("record_last_modifier_user_name"),
////                                resultSet.getString("record_last_modifier_user_surname"),
////                                resultSet.getString("record_last_modifier_user_email"),
////                                resultSet.getString("record_last_modifier_user_password"),
////                                resultSet.getString("record_last_modifier_user_phone_number")
////                        ),
////                        resultSet.getLong("record_last_modified_date"),
////                        new CheckingAccount(
////                                resultSet.getLong("from_checking_account_id"),
////                                new User(
////                                        resultSet.getLong("from_checking_account_user_id"),
////                                        resultSet.getString("from_checking_account_user_login"),
////                                        resultSet.getString("from_checking_account_user_name"),
////                                        resultSet.getString("from_checking_account_user_surname"),
////                                        resultSet.getString("from_checking_account_user_email"),
////                                        resultSet.getString("from_checking_account_user_password"),
////                                        resultSet.getString("from_checking_account_user_phone_number")
////                                ),
////                                resultSet.getString("from_checking_account_name"),
////                                new Currency(
////                                        resultSet.getLong("from_checking_account_currency_id"),
////                                        resultSet.getString("from_checking_account_currency_name"),
////                                        resultSet.getString("from_checking_account_currency_sign")
////                                )),
////                        new CheckingAccount(
////                                resultSet.getLong("to_checking_account_id"),
////                                new User(
////                                        resultSet.getLong("to_checking_account_user_id"),
////                                        resultSet.getString("to_checking_account_user_login"),
////                                        resultSet.getString("to_checking_account_user_name"),
////                                        resultSet.getString("to_checking_account_user_surname"),
////                                        resultSet.getString("to_checking_account_user_email"),
////                                        resultSet.getString("to_checking_account_user_password"),
////                                        resultSet.getString("to_checking_account_user_phone_number")
////                                ),
////                                resultSet.getString("to_checking_account_name"),
////                                new Currency(
////                                        resultSet.getLong("to_checking_account_currency_id"),
////                                        resultSet.getString("to_checking_account_currency_name"),
////                                        resultSet.getString("to_checking_account_currency_sign")
////                                ))));
////
////            }
////
////        } catch (SQLException e) {
////            System.err.println("SQL error: " + e.getMessage());
////        }
////
////        return records;
////    }
////
////    @Override
////    public List<Record> getRecordsByCheckingAccount(Long checkingAccountId) {
////        List<Record> records = new ArrayList<>();
////        try (Connection connection = DatabaseConnection.getConnection()) {
////            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RECORDS_BY_CHECKING_ACCOUNT);
////            preparedStatement.setLong(1, checkingAccountId);
////            ResultSet resultSet = preparedStatement.executeQuery();
////            while (resultSet.next()) {
////                records.add(new Record(
////                        resultSet.getLong("record_id"),
////                        resultSet.getString("record_name"),
////                        new Category(
////                                resultSet.getLong("category_id"),
////                                resultSet.getString("category_name"),
////                                resultSet.getBoolean("category_is_income")
////                        ),
////                        resultSet.getDouble("record_money_amount"),
////                        resultSet.getLong("record_transaction_date"),
////                        new User(
////                                resultSet.getLong("record_creator_user_id"),
////                                resultSet.getString("record_creator_user_login"),
////                                resultSet.getString("record_creator_user_name"),
////                                resultSet.getString("record_creator_user_surname"),
////                                resultSet.getString("record_creator_user_email"),
////                                resultSet.getString("record_creator_user_password"),
////                                resultSet.getString("record_creator_user_phone_number")
////                        ),
////                        resultSet.getLong("record_creation_timestamp"),
////                        new User(
////                                resultSet.getLong("record_last_modifier_user_id"),
////                                resultSet.getString("record_last_modifier_user_login"),
////                                resultSet.getString("record_last_modifier_user_name"),
////                                resultSet.getString("record_last_modifier_user_surname"),
////                                resultSet.getString("record_last_modifier_user_email"),
////                                resultSet.getString("record_last_modifier_user_password"),
////                                resultSet.getString("record_last_modifier_user_phone_number")
////                        ),
////                        resultSet.getLong("record_last_modified_date"),
////                        new CheckingAccount(
////                                resultSet.getLong("from_checking_account_id"),
////                                new User(
////                                        resultSet.getLong("from_checking_account_user_id"),
////                                        resultSet.getString("from_checking_account_user_login"),
////                                        resultSet.getString("from_checking_account_user_name"),
////                                        resultSet.getString("from_checking_account_user_surname"),
////                                        resultSet.getString("from_checking_account_user_email"),
////                                        resultSet.getString("from_checking_account_user_password"),
////                                        resultSet.getString("from_checking_account_user_phone_number")
////                                ),
////                                resultSet.getString("from_checking_account_name"),
////                                new Currency(
////                                        resultSet.getLong("from_checking_account_currency_id"),
////                                        resultSet.getString("from_checking_account_currency_name"),
////                                        resultSet.getString("from_checking_account_currency_sign")
////                                )),
////                        new CheckingAccount(
////                                resultSet.getLong("to_checking_account_id"),
////                                new User(
////                                        resultSet.getLong("to_checking_account_user_id"),
////                                        resultSet.getString("to_checking_account_user_login"),
////                                        resultSet.getString("to_checking_account_user_name"),
////                                        resultSet.getString("to_checking_account_user_surname"),
////                                        resultSet.getString("to_checking_account_user_email"),
////                                        resultSet.getString("to_checking_account_user_password"),
////                                        resultSet.getString("to_checking_account_user_phone_number")
////                                ),
////                                resultSet.getString("to_checking_account_name"),
////                                new Currency(
////                                        resultSet.getLong("to_checking_account_currency_id"),
////                                        resultSet.getString("to_checking_account_currency_name"),
////                                        resultSet.getString("to_checking_account_currency_sign")
////                                ))));
////
////            }
////
////        } catch (SQLException e) {
////            System.err.println("SQL error: " + e.getMessage());
////        }
////
////        return records;
////    }
