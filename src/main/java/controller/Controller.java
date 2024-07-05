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
        if (!recordValues.containsKey("name")) {
            return false;
        } else if (!recordValues.containsKey("category")) {
            return false;
        } else if (!recordValues.containsKey("moneyAmount")) {
            return false;
        } else if (!recordValues.containsKey("transactionDate")) {
            recordValues.put("transactionDate", System.currentTimeMillis());
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