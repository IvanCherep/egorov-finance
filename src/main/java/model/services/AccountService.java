package model.services;

import model.Account;

import java.util.Map;

public interface AccountService {

    public boolean createAccount(Map<String, Object> accountValues);

    public boolean modifyAccount(Map<String, Object> modifiedValues, Account originalAccount);

    public Account getAccountById(long id);

}
