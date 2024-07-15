package ru.sut.egorov.finance.controller;

import ru.sut.egorov.finance.model.dao.RecordDao;

import java.util.Map;


// Бизнес логика выполняется здесь
// Перемещение денег со счета на счет
// Проверка email
// Сформировать отчет в excel
public class Controller {

    private final RecordDao recordDao = null;

    public Controller() {
//        this.recordDao = new RecordDaoImpl();
    }

    public boolean createRecord(Map<String, Object> recordValues) {
        boolean isValid = true;
        if (!recordValues.containsKey("name")) {
            isValid = false;
            System.out.println("No name field");
        }
        if (!recordValues.containsKey("category")) {
            isValid = false;
            System.out.println("No category field");
        }
        if (!recordValues.containsKey("moneyAmount")) {
            isValid = false;
            System.out.println("No moneyAmount field");
        }
        if (!recordValues.containsKey("transactionDate")) {
            recordValues.put("transactionDate", System.currentTimeMillis());
        }

//        Long id;
//        String name;
//        Category category;
//        Double moneyAmount;
//        Long transactionDate;
//        User recordCreatorUser;
//        Long recordCreationTimestamp;
//        User recordLastModifierUser;
//        Long recordLastModifiedDate;
//        CheckingAccount fromCheckingAccount;
//        CheckingAccount toCheckingAccount;

        if (!isValid) {
            return isValid;
        }

//        return recordDao.createRecord(recordValues);
        return true;
    }

    public boolean validateRecord(Map<String, Object> recordValues) {

        return false;
    }

    public boolean validateRecord(Map<String, Object> recordValues, String key) {
        switch (key) {
            case "moneyAmount":
                return recordValues.get("moneyAmount") instanceof Double;
        }
        return false;
    }

}