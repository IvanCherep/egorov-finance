package ru.sut.egorov.finance.model;

// 0 Все хорошо
public class ObjectWrapper {

    Object object;

    Integer statusCode;

    public enum StatusCode {
        NO_MONEY_VALUE,
        NO_SECOND_FIELD
    }

    // return 0 - success
}


