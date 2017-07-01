package com.bookshop.dto;

/**
 * Created by Nazar on 04.06.2017.
 */
public class UserDto {

    private int id;

    private String login;

    private String email;

    private String name;

    private String lastName;

    public UserDto() {
    }

    public UserDto(int id, String login, String email, String name, String lastName) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
