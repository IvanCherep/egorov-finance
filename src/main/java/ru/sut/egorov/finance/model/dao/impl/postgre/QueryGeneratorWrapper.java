package ru.sut.egorov.finance.model.dao.impl.postgre;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class QueryGeneratorWrapper {

    private Map<String, Long> columnNameLongMap;
    private Map<String, Double> columnNameDoubleMap;
    private Map<String, Boolean> columnNameBooleanMap;
    private Map<String, String> columnNameStringMap;
    private Map<String, Date> columnNameDateMap;

    public QueryGeneratorWrapper() {
        columnNameLongMap = new HashMap<>();
        columnNameDoubleMap = new HashMap<>();
        columnNameBooleanMap = new HashMap<>();
        columnNameStringMap = new HashMap<>();
        columnNameDateMap = new HashMap<>();
    }

    public void setColumnNameLongMap(Map<String, Long> columnNameLongMap) {
        this.columnNameLongMap = columnNameLongMap;
    }

    public void setColumnNameDoubleMap(Map<String, Double> columnNameDoubleMap) {
        this.columnNameDoubleMap = columnNameDoubleMap;
    }

    public void setColumnNameBooleanMap(Map<String, Boolean> columnNameBooleanMap) {
        this.columnNameBooleanMap = columnNameBooleanMap;
    }

    public void setColumnNameStringMap(Map<String, String> columnNameStringMap) {
        this.columnNameStringMap = columnNameStringMap;
    }

    public void setColumnNameDateMap(Map<String, Date> columnNameDateMap) {
        this.columnNameDateMap = columnNameDateMap;
    }

    public Map<String, Long> getColumnNameLongMap() {
        return columnNameLongMap;
    }

    public Map<String, Double> getColumnNameDoubleMap() {
        return columnNameDoubleMap;
    }

    public Map<String, Boolean> getColumnNameBooleanMap() {
        return columnNameBooleanMap;
    }

    public Map<String, String> getColumnNameStringMap() {
        return columnNameStringMap;
    }

    public Map<String, Date> getColumnNameDateMap() {
        return columnNameDateMap;
    }
}
