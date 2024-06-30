package controller;

import model.RecordResponseStatus;
import model.services.RecordService;
import model.services.impl.RecordServiceImpl;

import java.util.Map;

public class Controller {

    private final RecordService recordService;

    public Controller() {
        this.recordService = new RecordServiceImpl();
    }

    public RecordResponseStatus createRecord(Map<String, Object> recordValues) {
        if (!recordValues.containsKey("name")) {
            return new RecordResponseStatus(null, RecordResponseStatus.NO_NAME);
        } else if (!recordValues.containsKey("category")) {
            return new RecordResponseStatus(null, RecordResponseStatus.NO_CATEGORY);
        } else if (!recordValues.containsKey("moneyAmount")) {
            return new RecordResponseStatus(null, RecordResponseStatus.NO_MONEY_AMOUNT);
        } else if (!recordValues.containsKey("transactionDate")) {
            recordValues.put("transactionDate", System.currentTimeMillis());
        }

        return new RecordResponseStatus(
                recordService.createRecord(recordValues),
                RecordResponseStatus.OK
        );
    }

}