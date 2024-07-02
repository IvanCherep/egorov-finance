package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// Модуль учета долгов?
public class Record {

    private final Long recordId;

    private final String name;

    private final Category category;

    private final Double moneyAmount;

    private final long transactionDate;

    private final User recordCreatorUser;

    private final long recordCreationTimestamp;

    private final User recordLastModifierUser;

    private final long recordLastModifiedDate;

    private final Account fromAccount;

    private final Account toAccount;

    private final Currency currency;

    private final static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");


    public Record(Long recordId, String name, Category category,
                  Double moneyAmount, long transactionDate, User recordCreatorUser,
                  long recordCreationTimestamp, User recordLastModifierUser, long recordLastModifiedDate,
                  Account fromAccount, Account toAccount, Currency currency) {
        this.recordId = recordId;
        this.name = name;
        this.category = category;
        this.moneyAmount = moneyAmount;
        this.transactionDate = transactionDate;
        this.recordCreatorUser = recordCreatorUser;
        this.recordCreationTimestamp = recordCreationTimestamp;
        this.recordLastModifierUser = recordLastModifierUser;
        this.recordLastModifiedDate = recordLastModifiedDate;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.currency = currency;
    }

    public User getRecordCreatorUser() {
        return recordCreatorUser;
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
                ", \"fromAccount\": \"%s\"" +
                ", \"toAccount\": \"%s\"" +
                ", \"currency\": \"%s\"" +
                "}",
                recordId,
                name,
                category.getName(),
                moneyAmount,
                dateFormat.format(new Date(transactionDate)),
                recordCreatorUser.getLogin(),
                dateFormat.format(new Date(recordCreationTimestamp)),
                recordLastModifierUser.getLogin(),
                dateFormat.format(new Date(recordLastModifiedDate)),
                fromAccount.getName(),
                toAccount.getName(),
                currency.getCurrencyName());
    }

}
