package com.bookshop.dto;

import com.bookshop.entity.City;

import java.time.LocalDate;

/**
 * Created by Nazar on 04.06.2017.
 */
public class AuthorDto {

    private int id;

    private String name;

    private String lastName;

    private LocalDate dateOfBirth;

    private String biography;

    private String pathImage;

    public AuthorDto() {
    }

    public AuthorDto(int id, String name, String lastName, String pathImage) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.pathImage = pathImage;
    }

    public AuthorDto(int id, String name, String lastName, LocalDate dateOfBirth, String biography, String pathImage) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.biography = biography;
        this.pathImage = pathImage;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
}
