package com.bookshop.dto;

/**
 * Created by Nazar on 04.06.2017.
 */
public class UserDto {

    private int id;

    private String login;

    private String email;

    public UserDto() {
    }

    public UserDto(int id, String login, String email) {
        this.id = id;
        this.login = login;
        this.email = email;
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

}
