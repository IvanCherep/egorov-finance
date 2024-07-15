package ru.sut.egorov.finance.model.entity;

import ru.sut.egorov.finance.singleton.FormatSingleton;

import java.text.DateFormat;

/**
 * Класс записи о финансовой операции (расходе или доходе)
 */
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

    private final Boolean isRemoved;

    private final static DateFormat dateFormat = FormatSingleton.getDateFormat();

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
                  CheckingAccount toCheckingAccount,
                  Boolean isRemoved) {
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
        this.isRemoved = isRemoved;
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

    public CheckingAccount getFromCheckingAccount() {
        return fromCheckingAccount;
    }

    public CheckingAccount getToCheckingAccount() {
        return toCheckingAccount;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", moneyAmount=" + moneyAmount +
                ", transactionDate=" + transactionDate +
                ", recordCreatorUser=" + recordCreatorUser +
                ", recordCreationTimestamp=" + recordCreationTimestamp +
                ", recordLastModifierUser=" + recordLastModifierUser +
                ", recordLastModifiedDate=" + recordLastModifiedDate +
                ", fromCheckingAccount=" + fromCheckingAccount +
                ", toCheckingAccount=" + toCheckingAccount +
                ", isRemoved=" + isRemoved +
                '}';
    }
}
