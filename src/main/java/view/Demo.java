package view;

import model.Record;
import model.services.RecordService;
import model.services.impl.RecordServiceImpl;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        RecordService recordService = new RecordServiceImpl();
        List<Record> records = new ArrayList<>();
        Map<String, Object> record = new HashMap<>();

        record.put("name", "Ручка");
        record.put("category", "Канцтовары");
        record.put("moneyAmount", 40.99);
        record.put("transactionDate", new Date().getTime());
        records.add(recordService.createRecord(record));

        record.put("name", "Тетрадь");
        record.put("category", "Канцтовары");
        record.put("moneyAmount", 75.50);
        record.put("transactionDate", new Date().getTime());
        records.add(recordService.createRecord(record));

        record.put("name", "Кофе");
        record.put("category", "Продукты");
        record.put("moneyAmount", 300.00);
        record.put("transactionDate", new Date().getTime());
        records.add(recordService.createRecord(record));

        record.put("name", "Молоко");
        record.put("category", "Продукты");
        record.put("moneyAmount", 60.00);
        record.put("transactionDate", new Date().getTime());
        records.add(recordService.createRecord(record));

        for (Record r: records) {
            System.out.println(r);
        }

    }

}
