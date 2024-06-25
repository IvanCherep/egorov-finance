package model;

public class Record {

    private final String name;

    private final String category;

    private final double moneyAmount;

    public Record(String name, String category, double moneyAmount) {
        this.name = name;
        this.category = category;
        this.moneyAmount = moneyAmount;
    }

    @Override
    public String toString() {
        return String.format("{" +
                "\"name\": \"%s\"" +
                ", \"category\": \"%s\"" +
                ", \"moneyAmount\": \"%.2f\"" +
                "}", name, category, moneyAmount);
    }
}
