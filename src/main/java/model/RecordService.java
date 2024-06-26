package model;

import java.util.Date;
import java.util.Map;

public class RecordService {

    public Record createRecord(Map<String, Object> recordValues) {
        Long id = 1L;
        String name = (String) recordValues.get("name");
        String category = (String) recordValues.get("category");
        Double moneyAmount = (Double) recordValues.get("moneyAmount");
        Date transactionDate = (Date) recordValues.get("transactionDate");
        return new Record(id, name, category, moneyAmount, transactionDate);
    }

    public Record getRecordById(long id) {
        return null;
    }

}
