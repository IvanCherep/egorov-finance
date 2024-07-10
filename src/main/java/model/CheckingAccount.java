package model;

/**
 * Класс является счетом и имеет аттрибут валюты
 */
public class CheckingAccount {

    private final Long id;

    private final User user;

    private final String name;

    private final Currency currency;

    public CheckingAccount(Long id, User user, String name, Currency currency) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Currency getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", currency=" + currency +
                '}';
    }
}
