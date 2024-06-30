package model.services;

import model.Account;
import model.Record;
import model.User;

import java.util.Date;
import java.util.Map;

public interface RecordService {

    public Record createRecord(Map<String, Object> recordValues);

    public Record modifyRecord(Map<String, Object> recordValues, Record originalRecord);

    public Record getRecordById(long id);

    public double getTotalBalance(Date date, User user);

    public double getTotalBalanceByDate(Date dateFrom, Date dateTo, User user);

    public double getAccountBalance(Date date, User user, Account account);

    public double getAccountBalanceByDate(Date dateFrom, Date dateTo, User user, Account account);

}
