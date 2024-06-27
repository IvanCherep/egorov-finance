package model;

import java.util.Date;
import java.util.Map;

public interface RecordService {


    public Record createRecord(Map<String, Object> recordValues);

    public Record modifyRecord(Map<String, Object> recordValues, Record originalRecord);

    public Record getRecordById(long id);

    public double getTotalBalance(Date date);

}
