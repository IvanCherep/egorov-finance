package model.services;

import model.Record;

import java.util.List;
import java.util.Map;

public interface RecordService {
    /**
    /* True успешно созданный объект. Как дополнительная проверка, в случае, если createId равен нулю, то это ошибка
    **/
    // Подумать насчет createdId и то насколько он нужен. И какая у него ценность
    public boolean createRecord(Map<String, Object> recordValues);

    public boolean modifyRecord(Map<String, Object> recordValues, Record originalRecord);

    //Параметрический поиск записей? Дата начала и окончания
    public List<Record> getRecordsByIds(List<Long> ids);

    public double getAccountBalanceByFilter(Map<String, Object> filters);

    // Если нет фильтров, то метод возвращает все записи
    public List<Record> getCheckingAccountsRecordsByFilter(Map<String, Object> filters);

    public List<Record> getRecordsByCheckingAccount(Long checkingAccountId);
}
