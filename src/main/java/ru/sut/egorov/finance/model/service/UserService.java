package ru.sut.egorov.finance.model.service;

import ru.sut.egorov.finance.model.entity.User;

import java.util.Map;

public interface UserService {

    public boolean createUser(Map<String, Object> userValues);

    public boolean modifyUser(Map<String, Object> modifiedValues, User originalUser);

    public User getUserById(long id);

}
