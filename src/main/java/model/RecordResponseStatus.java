package model;

public class RecordResponseStatus implements ResponseConstants {

    private final Record record;

    private final Integer responseStatus;

    public RecordResponseStatus(Record record, Object responseStatus) {
        this.record = record;
        this.responseStatus = (Integer) responseStatus;
    }

    public Record getRecord() {
        return record;
    }

    public int getResponseStatus() {
        return responseStatus;
    }

}
