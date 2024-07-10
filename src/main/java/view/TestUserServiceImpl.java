package view;

import model.*;
import model.db.DatabaseConnection;
import model.db.DatabaseInitializer;
import model.services.UserService;
import model.services.impl.UserServiceImpl;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

//TODO подумать над бекапом
//TODO написать имплементацию для всех сервисов
public class TestUserServiceImpl {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDB(connection);

        UserService userService = new UserServiceImpl();
        Map<String, Object> userValues = new HashMap<>();
        userValues.put("login", "test_login");
        userValues.put("name", "test_name");
        userValues.put("surname", "test_surname");
        userValues.put("email", "test_email");
        userValues.put("password", "test_password");
        userValues.put("phone_number", "test_phone_number");

        System.out.println(userService.createUser(userValues));
        User user = userService.getUserById(1);
        System.out.println(user);
        userValues.put("login", "test_login_updated");
        userValues.put("name", "test_name_updated");
        userValues.put("surname", "test_surname_updated");
        userValues.put("email", "test_email_updated");
        userValues.put("password", "test_password_updated");
        userValues.put("phone_number", "test_phone_number_updated");
        System.out.println(userService.modifyUser(userValues, user));
    }

}
