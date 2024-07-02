package model;

public class Currency {

    private final long currencyId;

    private final String currencyName;

    private Currency (long currencyId, String currencyName) {
        this.currencyId = currencyId;
        this.currencyName = currencyName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

}
