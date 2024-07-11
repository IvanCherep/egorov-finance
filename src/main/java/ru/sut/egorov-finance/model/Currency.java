package model;

/**
 * Класс валюты, является атрбиутом счета
 * В качестве валюты могут выступать бонусные балы для различных систем
 */
public class Currency {

    private final long id;

    private final String name;

    private final String sign;

    public Currency(long id, String name, String sign) {
        this.id = id;
        this.name = name;
        this.sign = sign;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sign=" + sign +
                '}';
    }
}
