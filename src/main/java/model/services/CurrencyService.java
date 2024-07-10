package model.services;

import model.Currency;

import java.util.List;
import java.util.Map;

public interface CurrencyService {

    public boolean createCurrency(Map<String, Object> currencyValues);

    public Currency getCurrencyById(Long id);

    public List<Currency> getCurrencies();

    public boolean modifyCurrency(Map<String, Object> modifiedValues, Currency originalCurrency);


}
