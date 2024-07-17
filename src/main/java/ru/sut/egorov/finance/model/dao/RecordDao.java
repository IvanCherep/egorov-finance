package ru.sut.egorov.finance.model.dao;

import ru.sut.egorov.finance.model.entity.Record;

import java.util.List;

public interface RecordDao {

    public Record findById(Long id);

    public boolean create(Record record);

    public List<Record> find();

    public boolean update(Record record);

    public boolean remove(Long id);

    public long[] findIds();

}
