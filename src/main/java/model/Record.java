package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {

    private final Long recordId;

    private final String name;

    private final String category;

    private final Double moneyAmount;

    private final long transactionDate;

    private final String recordCreatorLogin;

    private final long recordCreationTimestamp;

    private final String recordLastModifierLogin;

    private final long recordLastModifiedDate;

    private final static DateFormat dateFormat= new SimpleDateFormat("dd.MM.yyyy");

    // Как обозначит счет списания и получения???

    public Record(Long recordId, String name, String category,
                  Double moneyAmount, long transactionDate, String recordCreatorLogin,
                  long recordCreationTimestamp, String recordLastModifierLogin, long recordLastModifiedDate) {
        this.recordId = recordId;
        this.name = name;
        this.category = category;
        this.moneyAmount = moneyAmount;
        this.transactionDate = transactionDate;
        this.recordCreatorLogin = recordCreatorLogin;
        this.recordCreationTimestamp = recordCreationTimestamp;
        this.recordLastModifierLogin = recordLastModifierLogin;
        this.recordLastModifiedDate = recordLastModifiedDate;
    }

    public String getRecordCreatorLogin() {
        return recordCreatorLogin;
    }

    public long getRecordCreationTimestamp() {
        return recordCreationTimestamp;
    }

    @Override
    public String toString() {
        return String.format(
                "{" +
                "\"id\": \"%d\"" +
                "\"name\": \"%s\"" +
                ", \"category\": \"%s\"" +
                ", \"moneyAmount\": \"%.2f\"" +
                ", \"transactionDate\": \"%s\"" +
                ", \"recordCreatorLogin\": \"%s\"" +
                ", \"recordCreationTimestamp\": \"%s\"" +
                ", \"recordLastModifierLogin\": \"%s\"" +
                ", \"recordLastModifiedDate\": \"%s\"" +
                "}",
                recordId,
                name,
                category,
                moneyAmount,
                dateFormat.format(new Date(transactionDate)),
                recordCreatorLogin,
                dateFormat.format(new Date(recordCreationTimestamp)),
                recordLastModifierLogin,
                dateFormat.format(new Date(recordLastModifiedDate)));
    }

}
