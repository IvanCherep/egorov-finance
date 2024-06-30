package model;

public class User {

    public final long userId;

    public final String login;

    public final String name;

    public final String surname;

    public final String email;

    public final String password;

    public final String phoneNumber;

    public User(long userId, String login, String name, String surname, String email, String password, String phoneNumber) {
        this.userId = userId;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public String getLogin() {
        return login;
    }
}
