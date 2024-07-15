package ru.sut.egorov.finance.model.dao;

import ru.sut.egorov.finance.model.entity.Record;

import java.util.List;

public interface RecordDao {

    public List<Record> find();

    public Record findById(Long id);

    public boolean save(Record record);

    public boolean remove(Long id);

}
