package ru.sut.egorov.finance.model.dao;

import ru.sut.egorov.finance.model.entity.CheckingAccount;

import java.util.List;

public interface CheckingAccountDao {

    public List<CheckingAccount> find();

    public CheckingAccount findById(Long id);

    public boolean save(CheckingAccount checkingAccount);

    public boolean remove(Long id);

}
