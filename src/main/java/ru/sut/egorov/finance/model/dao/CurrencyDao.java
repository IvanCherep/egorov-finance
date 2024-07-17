package ru.sut.egorov.finance.model.dao;

import ru.sut.egorov.finance.model.entity.Currency;

import java.util.List;

public interface CurrencyDao {

    public Currency findById(Long id);

    public boolean create(Currency currency);

    public List<Currency> find();

    public boolean update(Currency currency);

    public boolean remove(Long id);

}
