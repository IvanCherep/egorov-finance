package model.services;

import model.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    public boolean createCategory(Map<String, Object> categoryValues);

    public Category getCategoryById(long id);

    public List<Category> getCategories();

    public boolean modifyCategory(Map<String, Object> modifiedValues, Category originalCategory);

}
