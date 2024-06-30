package model;

public class Account {

    private final long accountId;

    private final long userId;

    private final String name;

    public Account(long accountId, long userId, String name) {
        this.accountId = accountId;
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
