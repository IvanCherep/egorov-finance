package ru.sut.egorov.finance.singleton;

import java.text.SimpleDateFormat;

public class FormatSingleton {

    private static SimpleDateFormat format;

    public static SimpleDateFormat getDateFormat() {
        if (format == null) {
            format = new SimpleDateFormat("dd.MM.yyyy");
        }

        return format;
    }

}
