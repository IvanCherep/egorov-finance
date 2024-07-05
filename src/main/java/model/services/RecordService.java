package model.services;

import model.Account;
import model.Record;
import model.User;

import java.util.Date;
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

    public double getTotalBalance(Date date, User user);

    public double getTotalBalanceByDate(Date dateFrom, Date dateTo, User user);

    public double getAccountBalance(Date date, User user, Account account);

    public double getAccountBalanceByDate(Date dateFrom, Date dateTo, User user, Account account);

}
