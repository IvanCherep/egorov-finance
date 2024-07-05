package model.services.impl;

import model.*;
import model.Record;
import model.services.RecordService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class RecordServiceImpl implements RecordService {

    public long counter = 1;

    @Override
    public boolean createRecord(Map<String, Object> recordValues) {
        Long recordId = counter++;
        String name = (String) recordValues.get("name");
        Category category = (Category) recordValues.get("category");
        Double moneyAmount = (Double) recordValues.get("moneyAmount");
        Long transactionDate = (Long) recordValues.get("transactionDate");

        // Поставить реальные значения
        User recordCreatorUser = null;
        long recordCreationTimestamp = System.currentTimeMillis();
        User recordLastModifierUser = null;
        long recordLastModifiedDate = 0;
        Account fromAccount = null;
        Account toAccount = null;
        Currency currency = null;

        // Сохранение записи в БД
        Record record = new Record(
                recordId,
                name,
                category,
                moneyAmount,
                transactionDate,
                recordCreatorUser,
                recordCreationTimestamp,
                recordLastModifierUser,
                recordLastModifiedDate,
                fromAccount,
                toAccount,
                currency
        );
        return true;
    }

    @Override
    public boolean modifyRecord(Map<String, Object> recordValues, Record originalRecord) {
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
        return false;
    }

    @Override
    public List<Record> getRecordsByIds(List<Long> ids) {
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
