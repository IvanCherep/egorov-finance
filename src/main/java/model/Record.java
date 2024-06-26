package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Record {

    private final Long id;

    private final String name;

    private final String category;

    private final Double moneyAmount;

    private final Date transactionDate;

    private final DateFormat dateFormat= new SimpleDateFormat("dd.MM.yyyy");

    public Record(Long id, String name, String category, Double moneyAmount, Date transactionDate) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.moneyAmount = moneyAmount;
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        return String.format("{" +
                "\"id\": \"%d\"" +
                "\"name\": \"%s\"" +
                ", \"category\": \"%s\"" +
                ", \"moneyAmount\": \"%.2f\"" +
                ", \"transactionDate\": \"%s\"" +
                "}", id, name, category, moneyAmount, dateFormat.format(transactionDate));
    }

}
