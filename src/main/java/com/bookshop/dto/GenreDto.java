package com.bookshop.dto;

/**
 * Created by Study on 24.06.2017.
 */
public class GenreDto {

    private int id;

    private String name;

    public GenreDto() {
    }

    public GenreDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
