package model.services.impl;

import model.Account;
import model.Category;
import model.Record;
import model.User;
import model.services.RecordService;

import java.util.Date;
import java.util.Map;

public class RecordServiceImpl implements RecordService {

    public long counter = 1;

    @Override
    public Record createRecord(Map<String, Object> recordValues) {
//        Long id = counter++;
//        String name = (String) recordValues.get("name");
//        String category = (String) recordValues.get("category");
//        Double moneyAmount = (Double) recordValues.get("moneyAmount");
//        Long transactionDate = (Long) recordValues.get("transactionDate");
//        long currentTimestamp = new Date().getTime();
//
//        // В каком моменте мы понимаем, какой именно польозватель создал запись
//        return new Record(id, name, category, moneyAmount, transactionDate, "UserA", currentTimestamp, "UserA", currentTimestamp);
        return null;
    }

    @Override
    public Record modifyRecord(Map<String, Object> recordValues, Record originalRecord) {
//        Long id = counter++;
//        String name = (String) recordValues.get("name");
//        Category category = (Category) recordValues.get("category");
//        Double moneyAmount = (Double) recordValues.get("moneyAmount");
//        Long transactionDate = (Long) recordValues.get("transactionDate");
//        long currentTimestamp = new Date().getTime();
//
//        // В каком моменте мы понимаем, какой именно польозватель создал запись
//        return new Record(id,
//                name,
//                category,
//                moneyAmount,
//                transactionDate,
//                originalRecord.getRecordCreatorUser(),
//                originalRecord.getRecordCreationTimestamp(),
//                "UserA",
//                currentTimestamp);
        return null;
    }

    @Override
    public Record getRecordById(long id) {
        return null;
    }

    @Override
    public double getTotalBalance(Date date, User user) {
        return 0;
    }

    @Override
    public double getTotalBalanceByDate(Date dateFrom, Date dateTo, User user) {
        return 0;
    }

    @Override
    public double getAccountBalance(Date date, User user, Account account) {
        return 0;
    }

    @Override
    public double getAccountBalanceByDate(Date dateFrom, Date dateTo, User user, Account account) {
        return 0;
    }

}
