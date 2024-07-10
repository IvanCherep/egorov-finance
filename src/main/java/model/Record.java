package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Record {

    private final Long id;

    private final String name;

    private final Category category;

    private final Double moneyAmount;

    private final Long transactionDate;

    private final User recordCreatorUser;

    private final Long recordCreationTimestamp;

    private final User recordLastModifierUser;

    private final Long recordLastModifiedDate;

    private final CheckingAccount fromCheckingAccount;

    private final CheckingAccount toCheckingAccount;

    //TODO вывести в сингалтон
    // сингалтон - getSingalton (если уже есть, возвращается объект, если нет вызывается конструктор)
    // сингалтон getFormat из переменной full get format
    // connection тоже сингалтон
    // Сделать отдельный класс локализации
    // Продумать этот вопрос
    private final static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Record(Long id,
                  String name,
                  Category category,
                  Double moneyAmount,
                  Long transactionDate,
                  User recordCreatorUser,
                  Long recordCreationTimestamp,
                  User recordLastModifierUser,
                  Long recordLastModifiedDate,
                  CheckingAccount fromCheckingAccount,
                  CheckingAccount toCheckingAccount) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.moneyAmount = moneyAmount;
        this.transactionDate = transactionDate;
        this.recordCreatorUser = recordCreatorUser;
        this.recordCreationTimestamp = recordCreationTimestamp;
        this.recordLastModifierUser = recordLastModifierUser;
        this.recordLastModifiedDate = recordLastModifiedDate;
        this.fromCheckingAccount = fromCheckingAccount;
        this.toCheckingAccount = toCheckingAccount;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public Double getMoneyAmount() {
        return moneyAmount;
    }

    public Long getTransactionDate() {
        return transactionDate;
    }

    public User getRecordCreatorUser() {
        return recordCreatorUser;
    }

    public Long getRecordCreationTimestamp() {
        return recordCreationTimestamp;
    }

    public User getRecordLastModifierUser() {
        return recordLastModifierUser;
    }

    public Long getRecordLastModifiedDate() {
        return recordLastModifiedDate;
    }

    public CheckingAccount getToCheckingAccount() {
        return toCheckingAccount;
    }

    public CheckingAccount getFromCheckingAccount() {
        return fromCheckingAccount;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ",\ncategory=" + category +
                ",\nmoneyAmount=" + moneyAmount +
                ", transactionDate=" + transactionDate +
                ",\nrecordCreatorUser=" + recordCreatorUser +
                ", recordCreationTimestamp=" + recordCreationTimestamp +
                ",\nrecordLastModifierUser=" + recordLastModifierUser +
                ", recordLastModifiedDate=" + recordLastModifiedDate +
                ",\nfromCheckingAccount=" + fromCheckingAccount +
                ",\ntoCheckingAccount=" + toCheckingAccount +
                '}';
    }

    //    public Record(Long recordId, String name, Category category,
//                  Double moneyAmount, long transactionDate, User recordCreatorUser,
//                  long recordCreationTimestamp, User recordLastModifierUser, long recordLastModifiedDate,
//                  CheckingAccount fromCheckingAccount, CheckingAccount toCheckingAccount, Currency currency) {
//        this.recordId = recordId;
//        this.name = name;
//        this.category = category;
//        this.moneyAmount = moneyAmount;
//        this.transactionDate = transactionDate;
//        this.recordCreatorUser = recordCreatorUser;
//        this.recordCreationTimestamp = recordCreationTimestamp;
//        this.recordLastModifierUser = recordLastModifierUser;
//        this.recordLastModifiedDate = recordLastModifiedDate;
//        this.fromCheckingAccount = fromCheckingAccount;
//        this.toCheckingAccount = toCheckingAccount;
//        this.currency = currency;
//    }
//
//    public User getRecordCreatorUser() {
//        return recordCreatorUser;
//    }
//
//    public long getRecordCreationTimestamp() {
//        return recordCreationTimestamp;
//    }
//
//    @Override
//    public String toString() {
//        return String.format(
//                "{" +
//                "\"id\": \"%d\"" +
//                "\"name\": \"%s\"" +
//                ", \"category\": \"%s\"" +
//                ", \"moneyAmount\": \"%.2f\"" +
//                ", \"transactionDate\": \"%s\"" +
//                ", \"recordCreatorLogin\": \"%s\"" +
//                ", \"recordCreationTimestamp\": \"%s\"" +
//                ", \"recordLastModifierLogin\": \"%s\"" +
//                ", \"recordLastModifiedDate\": \"%s\"" +
//                ", \"fromAccount\": \"%s\"" +
//                ", \"toAccount\": \"%s\"" +
//                ", \"currency\": \"%s\"" +
//                "}",
//                recordId,
//                name,
//                category.getName(),
//                moneyAmount,
//                dateFormat.format(new Date(transactionDate)),
//                recordCreatorUser.getLogin(),
//                dateFormat.format(new Date(recordCreationTimestamp)),
//                recordLastModifierUser.getLogin(),
//                dateFormat.format(new Date(recordLastModifiedDate)),
//                fromCheckingAccount.getName(),
//                toCheckingAccount.getName(),
//                currency.getCurrencyName());
//    }

}
