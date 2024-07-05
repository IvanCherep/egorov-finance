package model;

public class Category {

    private final long categoryId;

    private final String name;

    public Category(long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public long getId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
                "{" +
                "\"id\": %d, " +
                "\"name\": %s" +
                "}",
                categoryId,
                name
        );
    }

}
