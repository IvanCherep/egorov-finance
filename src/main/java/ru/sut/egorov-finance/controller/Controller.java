package controller;

import model.services.RecordService;
import model.services.impl.RecordServiceImpl;

import java.util.Map;

public class Controller {

    private final RecordService recordService;

    public Controller() {
        this.recordService = new RecordServiceImpl();
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

        return recordService.createRecord(recordValues);
    }

    public boolean validateRecord(Map<String, Object> recordValues) {

        return false;
    }

    public boolean validateRecord(Map<String, Object> recordValues, String key) {
        switch (key) {
            case "moneyAmount":
                return recordValues.get("moneyAmount") instanceof  Double;
        }
        return false;
    }

}