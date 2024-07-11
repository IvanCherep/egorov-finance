package model.services;

import model.CheckingAccount;
import model.User;

import java.util.List;
import java.util.Map;

public interface CheckingAccountService {

    public boolean createAccount(Map<String, Object> accountValues);

    public boolean modifyAccount(Map<String, Object> modifiedValues, CheckingAccount originalCheckingAccount);

    public CheckingAccount getCheckingAccountById(Long id);

    public List<CheckingAccount> getCheckingAccountsByUser(User user);

}
