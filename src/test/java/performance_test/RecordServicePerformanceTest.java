package performance_test;

public class RecordServicePerformanceTest {
//
//    public static void main(String[] args) {
//        Connection connection = DatabaseConnection.getConnection();
//        DatabaseInitializer.initializeDB(connection);
//        CheckingAccount testCheckingAccount = createTestAccountForPerformanceTesting();
//        System.out.println(performanceTimeForRecordServiceSlow(testCheckingAccount));
//
////        createTestRecordForPerformanceTesting(1000, testCheckingAccount);
////        deleteAllRecords();
////        deletePerformanceTestAccount();
//    }
//
//    public static Long performanceTimeForRecordService(CheckingAccount testCheckingAccount) {
//        RecordDao recordDao = new RecordDaoImpl();
//
//        Long timeStart = System.currentTimeMillis();
//        recordDao.getRecordsByCheckingAccount(testCheckingAccount.getId());
//        return System.currentTimeMillis() - timeStart;
//    }
//
//    public static Long performanceTimeForRecordServiceSlow(CheckingAccount testCheckingAccount) {
//        RecordDao recordDao = new RecordDaoSlowImpl();
//
//        Long timeStart = System.currentTimeMillis();
//        recordDao.getRecordsByCheckingAccount(testCheckingAccount.getId());
//        return System.currentTimeMillis() - timeStart;
//    }
//
//    public static CheckingAccount createTestAccountForPerformanceTesting() {
//        CheckingAccountDao checkingAccountDao = new CheckingAccountDaoImpl();
//        UserDao userDao = new UserDaoImpl();
//        CurrencyDao currencyDao = new CurrencyDaoImpl();
//        User systemUser = userDao.getUserById(42L);
//        List<Currency> currencies = currencyDao.getCurrencies();
//        Currency ruble = null;
//        for (Currency currency : currencies) {
//            if (currency.getName().equals("Рубль")) {
//                ruble = currency;
//            }
//        }
//        Map<String, Object> checkingAccountValues = new HashMap<>();
//        checkingAccountValues.put("user_id", systemUser);
//        checkingAccountValues.put("name", "Performance_test");
//        checkingAccountValues.put("currency_id", ruble);
//        checkingAccountDao.createAccount(checkingAccountValues);
//        List<CheckingAccount> checkingAccounts = checkingAccountDao.getCheckingAccountsByUser(systemUser);
//        for (CheckingAccount checkingAccount: checkingAccounts) {
//            if (checkingAccount.getName().equals("Performance_test")) {
//                return checkingAccount;
//            }
//        }
//
//        return null;
//    }
//
//    public static void createTestRecordForPerformanceTesting(int amount, CheckingAccount fromCheckingAccount) {
//        CategoryDao categoryDao = new CategoryDaoPostgreSqlImpl();
//        CheckingAccountDao checkingAccountDao = new CheckingAccountDaoImpl();
//        RecordDao recordDao = new RecordDaoImpl();
//        List<Category> categories = categoryDao.getCategories();
//        Map<String, Object> recordValues = new HashMap<>();
//        Random random = new Random();
//
//        List<CheckingAccount> checkingAccounts = checkingAccountDao.getCheckingAccountsByUser(fromCheckingAccount.getUser());
//        CheckingAccount toCheckingAccount = null;
//        for (CheckingAccount checkingAccount: checkingAccounts) {
//            if (checkingAccount.getName().equals("Расход")) {
//                toCheckingAccount = checkingAccount;
//            }
//        }
//        List<String> items = List.of("Товар 1", "Товар 2", "Товар 3", "Товар 4", "Товар 5");
//        for (int i = 0; i < amount; i++) {
//            recordValues.put("name", items.get((int) ((Math.random() * (items.size())))));
//            recordValues.put("category_id", categories.get((int) ((Math.random() * (categories.size())))));
////            recordValues.put("money_amount", random.nextDouble());
//            recordValues.put("money_amount", Double.valueOf(100));
//            // 1704056400 - Mon Jan 01 2024 00:00:00 GMT+0300
//            // 1720607441 - Wed Jul 10 2024 13:30:41 GMT+0300
//            Long timestamp = 1704056400L; //ThreadLocalRandom.current().nextLong(1704056400L, 1720607441L);
//            recordValues.put("transaction_date", timestamp);
//            recordValues.put("record_creator_user_id", fromCheckingAccount.getUser());
//            recordValues.put("record_creation_timestamp", timestamp);
//            recordValues.put("record_last_modifier_user_id", fromCheckingAccount.getUser());
//            recordValues.put("record_last_modified_date", timestamp);
//            recordValues.put("from_checking_account_id", fromCheckingAccount);
//            recordValues.put("to_checking_account_id", toCheckingAccount);
//            recordDao.createRecord(recordValues);
//        }
//
//        return;
//    }
//
//        public static void deleteAllRecords() {
//            String DELETE_FROM_RECORDS = "DELETE FROM records";
//            try (Connection connection = DatabaseConnection.getConnection()) {
//                Statement statement = connection.createStatement();
//                statement.executeUpdate(DELETE_FROM_RECORDS);
//            } catch (SQLException e) {
//                System.err.println(e.getMessage());
//            }
//        }
//
//        public static void deletePerformanceTestAccount() {
//        String DELETE_FROM_CHECKING_ACCOUNTS = "DELETE FROM checking_accounts WHERE name = 'Performance_test";
//        try (Connection connection = DatabaseConnection.getConnection()) {
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(DELETE_FROM_CHECKING_ACCOUNTS);
//        } catch (SQLException e) {
//            System.err.println(e.getMessage());
//        }
//    }
//
//    // Подготовка
//    // createTestAccount()
//    // createRecords(int count)
//    //
//    // Замер производительности:
//    // x1 = startTimer()
//    //
//    // main()
//    //
//    // x2 = endTimer()
//    //
//    // Убираем окружение:
//    // DeleteRecord()
//    // DeleteAccount(id)
//    //
//    // System.out.println(x2 - x1);
//    //
//    // main() {
//    //      recordService.getRecords()
//    // }
//    //
//    // Ориентир 0.1 секунда

}
