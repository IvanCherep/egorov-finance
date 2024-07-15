package dao;

import ru.sut.egorov.finance.db.DatabaseConnection;
import ru.sut.egorov.finance.db.DatabaseInitializer;
import ru.sut.egorov.finance.model.dao.UserDao;
import ru.sut.egorov.finance.model.dao.impl.postgre.UserDaoImpl;
import ru.sut.egorov.finance.model.entity.User;

import java.sql.Connection;
import java.util.List;

public class UserDaoTest {

    public static void main(String[] args) {
        Connection connection = DatabaseConnection.getConnection();
        DatabaseInitializer.initializeDB(connection);
        UserDao userDao = new UserDaoImpl();

        // Test find method
        System.out.println(userDao.find());

        // Test findById method
        // 42L - system user id
        User systemUser = userDao.findById(42L);
        System.out.println(systemUser);

        // Test save method to create User
        User testUser = new User(
                systemUser.getId() + 1,
                systemUser.getLogin(),
                "test_user",
                systemUser.getSurname(),
                systemUser.getEmail(),
                systemUser.getPassword(),
                systemUser.getPassword(),
                systemUser.getRemoved()
        );
        System.out.println(userDao.save(testUser));

        // Test save method to update User
        // Test remove method to remove User
        List<User> users = userDao.find();
        for (User user: users) {
            if (user.getName().equals("test_user")) {
                User updatedTestUser = new User(
                        user.getId(),
                        "test_login",
                        "test_name",
                        "test_surname",
                        "test_email",
                        "test_password",
                        "test_phone_number",
                        user.getRemoved()
                );
                userDao.save(updatedTestUser);
                System.out.println(userDao.find());
                userDao.remove(updatedTestUser.getId());
                System.out.println(userDao.find());
                System.out.println(userDao.findById(updatedTestUser.getId()));
            }
        }


    }

}
