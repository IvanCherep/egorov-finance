package ru.sut.egorov.finance.model.dao;

import ru.sut.egorov.finance.model.entity.Category;

import java.util.List;

public interface CategoryDao {

    public Category findById(Long id);

    public boolean create(Category category);

    public List<Category> find();

    public boolean update(Category category);

    public boolean remove(Long id);
}
