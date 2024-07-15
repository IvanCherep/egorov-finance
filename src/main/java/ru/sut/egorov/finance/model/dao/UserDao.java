package ru.sut.egorov.finance.model.dao;

import ru.sut.egorov.finance.model.entity.User;

import java.util.List;

public interface UserDao {

    public List<User> find();

    public User findById(Long id);

    public boolean save(User user);

    public boolean remove(Long id);

}
