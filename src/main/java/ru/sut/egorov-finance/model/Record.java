package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Класс записи о финансовой операции (расходе или доходе)
 */
public class Record {

    private final Long id;

    private final String name;

    private final model.Category category;

    private final Double moneyAmount;

    private final Long transactionDate;

    private final model.User recordCreatorUser;

    private final Long recordCreationTimestamp;

    private final model.User recordLastModifierUser;

    private final Long recordLastModifiedDate;

    private final model.CheckingAccount fromCheckingAccount;

    private final model.CheckingAccount toCheckingAccount;

    // private final Boolean isDeleted; (default false)

    private final static DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");

    public Record(Long id,
                  String name,
                  model.Category category,
                  Double moneyAmount,
                  Long transactionDate,
                  model.User recordCreatorUser,
                  Long recordCreationTimestamp,
                  model.User recordLastModifierUser,
                  Long recordLastModifiedDate,
                  model.CheckingAccount fromCheckingAccount,
                  model.CheckingAccount toCheckingAccount) {
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

    public model.Category getCategory() {
        return category;
    }

    public Double getMoneyAmount() {
        return moneyAmount;
    }

    public Long getTransactionDate() {
        return transactionDate;
    }

    public model.User getRecordCreatorUser() {
        return recordCreatorUser;
    }

    public Long getRecordCreationTimestamp() {
        return recordCreationTimestamp;
    }

    public model.User getRecordLastModifierUser() {
        return recordLastModifierUser;
    }

    public Long getRecordLastModifiedDate() {
        return recordLastModifiedDate;
    }

    public model.CheckingAccount getToCheckingAccount() {
        return toCheckingAccount;
    }

    public model.CheckingAccount getFromCheckingAccount() {
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

}
