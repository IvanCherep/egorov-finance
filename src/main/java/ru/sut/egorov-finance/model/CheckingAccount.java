package model;

/**
 * Класс является счетом и имеет аттрибут валюты
 */
public class CheckingAccount {

    private final Long id;

    private final model.User user;

    private final String name;

    private final model.Currency currency;

    public CheckingAccount(Long id, model.User user, String name, model.Currency currency) {
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

    public model.User getUser() {
        return user;
    }

    public model.Currency getCurrency() {
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
