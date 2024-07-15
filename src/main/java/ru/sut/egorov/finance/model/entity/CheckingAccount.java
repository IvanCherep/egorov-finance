package ru.sut.egorov.finance.model.entity;

/**
 * Класс является счетом и имеет аттрибут валюты
 */
public class CheckingAccount {

    private final Long id;

    private final User user;

    private final String name;

    private final Currency currency;

    private final Boolean isRemoved;

    public CheckingAccount(Long id, User user, String name, Currency currency, Boolean isRemoved) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.currency = currency;
        this.isRemoved = isRemoved;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", currency=" + currency +
                ", isRemoved=" + isRemoved +
                '}';
    }
}
