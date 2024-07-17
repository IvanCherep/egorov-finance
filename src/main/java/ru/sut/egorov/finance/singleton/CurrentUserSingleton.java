package ru.sut.egorov.finance.singleton;

import ru.sut.egorov.finance.model.dao.UserDao;
import ru.sut.egorov.finance.model.dao.impl.postgre.UserDaoImpl;
import ru.sut.egorov.finance.model.entity.Currency;
import ru.sut.egorov.finance.model.entity.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class CurrentUserSingleton {

    private static User user;

    private static Currency currency;

    private static Boolean showRemoved;

    public static User getCurrentUser() {
        if (user == null) {
            UserDao userDao = new UserDaoImpl();
            Properties properties = new Properties();
            try (FileInputStream inputStream = new FileInputStream("src/main/resources/user_preferences.properties")) {
                properties.load(inputStream);
                user = userDao.findById(Long.valueOf(properties.getProperty("user_id")));
            } catch (FileNotFoundException e) {
                System.err.println("user_preferences.properties file not found ERROR: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("user_preferences.properties file read ERROR: " + e.getMessage());
            }
        }
        return user;
    }
//
    public static Boolean shoutShowRemoved() {
        UserDao userDao = new UserDaoImpl();
        if (showRemoved == null) {
            Properties properties = new Properties();
            try (FileInputStream inputStream = new FileInputStream("src/main/resources/user_preferences.properties")) {
                properties.load(inputStream);
                user = userDao.findById(Long.valueOf(properties.getProperty("")));
            } catch (FileNotFoundException e) {
                System.err.println("user_preferences.properties file not found ERROR: " + e.getMessage());
            } catch (IOException e) {
                System.err.println("user_preferences.properties file read ERROR: " + e.getMessage());
            }
        }
        // исправить
        return true;
    }

    public static Currency getCurrentCurrency() {
//        if (Currency == null) {
//            Currency currency = new Currency();
//        }

        return currency;
    }


}
