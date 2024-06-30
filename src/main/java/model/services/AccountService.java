package model.services;

import model.Account;

import java.util.Map;

public interface AccountService {

    public Account createAccount(Map<String, Object> accountValues);

    public Account getAccountById(long id);

    public Account modifyAccount(Map<String, Object> modifiedValues, Account originalAccount);

}
