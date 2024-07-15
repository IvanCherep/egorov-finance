package ru.sut.egorov.finance.model.dao;

import ru.sut.egorov.finance.model.entity.Currency;

import java.util.List;

public interface CurrencyDao {

    public List<Currency> find();

    public Currency findById(Long id);

    public boolean save(Currency currency);

    public boolean remove(Long id);

}
