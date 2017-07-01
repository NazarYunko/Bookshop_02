package com.bookshop.dto;

/**
 * Created by Study on 24.06.2017.
 */
public class PublisherDto {

    private int id;

    private String name;

    private String pathImage;

    public PublisherDto() {
    }

    public PublisherDto(int id, String name, String pathImage) {
        this.id = id;
        this.name = name;
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

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
}
