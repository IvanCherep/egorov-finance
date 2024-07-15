package ru.sut.egorov.finance.singleton;

import ru.sut.egorov.finance.model.entity.Currency;
import ru.sut.egorov.finance.model.entity.User;

public class CurrentUserSingleton {

    private static User user;

    private static Currency currency;

    public static User getCurrentUser() {
//        if (User == null) {
//            User user = new User();
//        }
        user = null;

        return user;
    }

    public static Currency getCurrentCurrency() {
//        if (Currency == null) {
//            Currency currency = new Currency();
//        }

        return currency;
    }


}
