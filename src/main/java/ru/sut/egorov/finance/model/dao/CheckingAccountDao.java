package ru.sut.egorov.finance.model.dao;

import ru.sut.egorov.finance.model.entity.CheckingAccount;

import java.util.List;

public interface CheckingAccountDao {

    public CheckingAccount findById(Long id);

    public boolean create(CheckingAccount checkingAccount);

    public List<CheckingAccount> find();

    public boolean update(CheckingAccount checkingAccount);

    public boolean remove(Long id);

}
