package model;

/**
 * Категория расхода или дохода
 */
public class Category {

    private final long id;

    private final String name;

    private final Boolean isIncome;

    public Category(long id, String name, Boolean isIncome) {
        this.id = id;
        this.name = name;
        this.isIncome = isIncome;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getIncome() {
        return isIncome;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isIncome=" + isIncome +
                '}';
    }
}
