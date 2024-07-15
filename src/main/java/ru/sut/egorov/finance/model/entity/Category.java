package ru.sut.egorov.finance.model.entity;

/**
 * Категория расхода или дохода
 */
public class Category {

    private final Long id;

    private final String name;

    private final Boolean isIncome;

    private final Boolean isRemoved;

    public Category(Long id, String name, Boolean isIncome, Boolean isRemoved) {
        this.id = id;
        this.name = name;
        this.isIncome = isIncome;
        this.isRemoved = isRemoved;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getIncome() {
        return isIncome;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isIncome=" + isIncome +
                ", isRemoved=" + isRemoved +
                '}';
    }
}
