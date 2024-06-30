package controller;

import model.Record;

import java.util.Date;
import java.util.Map;

public class Controller {

    //TODO Как передавать ошибки в представление?
    public Record createRecord(Map<String, Object> recordValues) {
        if (!recordValues.containsKey("transactionDate")) {
            recordValues.put("transactionDate", System.currentTimeMillis());
        }
        return null;
    }

}
