package ru.sut.egorov.finance.model.dao;

import ru.sut.egorov.finance.model.entity.User;

import java.util.List;

public interface UserDao {

    public User findById(Long id);

    public boolean create(User user);

    public List<User> find();

    public boolean update(User user);

    public boolean remove(Long id);

}
