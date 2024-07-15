package ru.sut.egorov.finance.model.entity;

/**
 * Класс пользователя, привязан к конкретному человеку
 */
public class User {

    private final Long id;

    private final String login;

    private final String name;

    private final String surname;

    private final String email;

    private final String password;

    private final String phoneNumber;

    private final Boolean isRemoved;

    public User(Long id,
                String login,
                String name,
                String surname,
                String email,
                String password,
                String phoneNumber,
                Boolean isRemoved) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.isRemoved = isRemoved;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Boolean getRemoved() {
        return isRemoved;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", isRemoved=" + isRemoved +
                '}';
    }
}
