package model.services;

import model.Category;

import java.util.Map;

public interface CategoryService {

    public Category createCategory(Map<String, Object> categoryValues);

    public Category getCategoryById(long id);

    public Category modifyCategory(Map<String, Object> modifiedValues, Category originalCategory);

}
