package model.services;

import model.User;
import java.util.Map;

public interface UserService {

    public User createUser(Map<String, Object> userValues);

    public User getUserById(long id);

    public User modifyUser(Map<String, Object> modifiedValues, User originalUser);

}
