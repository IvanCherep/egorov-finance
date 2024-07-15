package ru.sut.egorov.finance.model.entity;

/**
 * Класс валюты, является атрбиутом счета
 * В качестве валюты могут выступать бонусные балы для различных систем
 */
public class Currency {

    private final Long id;

    private final String name;

    private final String sign;

    private final Boolean isRemoved;

    public Currency(Long id, String name, String sign, Boolean isRemoved) {
        this.id = id;
        this.name = name;
        this.sign = sign;
        this.isRemoved = isRemoved;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sign='" + sign + '\'' +
                ", isRemoved=" + isRemoved +
                '}';
    }
}
