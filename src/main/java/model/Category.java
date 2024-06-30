package model;

public class Category {

    private final long categoryId;

    private final String name;

    public Category(long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
