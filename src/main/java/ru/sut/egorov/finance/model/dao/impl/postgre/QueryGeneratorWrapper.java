package ru.sut.egorov.finance.model.dao.impl.postgre;

import java.util.Date;
import java.util.Map;

public class QueryGeneratorWrapper {

    public Map<String, Long> columnNameLongMap;
    public Map<String, Double> columnNameDoubleMap;
    public Map<String, Boolean> columnNameBooleanMap;
    public Map<String, String> columnNameStringMap;
    public Map<String, Date> columnNameDateMap;
}
