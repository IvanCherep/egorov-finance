package view;

import model.CheckingAccount;
import model.db.DatabaseConnection;
import model.db.DatabaseInitializer;
import model.services.CheckingAccountService;
import model.services.UserService;
import model.services.impl.CheckingAccountServiceImpl;
import model.services.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class TestAccountServiceImpl {

    public static void main(String[] args) throws SQLException {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDB(connection);
        connection.close();

        CheckingAccountService checkingAccountService = new CheckingAccountServiceImpl();
        UserService userService = new UserServiceImpl();

        CheckingAccount checkingAccount = checkingAccountService.getCheckingAccountById(1L);

        Map<String, Object> accountValues = new HashMap<>();
        accountValues.put("name", checkingAccount.getName());
        accountValues.put("user_id", userService.getUserById(1));
        System.out.println(checkingAccount);
        System.out.println(checkingAccountService.createAccount(accountValues));
    }

}
