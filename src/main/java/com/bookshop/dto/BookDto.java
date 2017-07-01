package com.bookshop.dto;

import com.bookshop.entity.Author;
import com.bookshop.entity.Genre;
import com.bookshop.entity.Publisher;

import java.time.LocalDate;

/**
 * Created by Nazar on 04.06.2017.
 */
public class BookDto {

    private int id;

    private String name;

    private Genre genre;

    private String description;

    private int countOfPages;

    private Author author;

    private LocalDate dateOfPublication;

    private Publisher publisher;

    private float price;

    private int quantity;

    private String pathImage;

    public BookDto() {
    }

    public BookDto(int id, String name, Author author, float price, String pathImage) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.pathImage = pathImage;
    }

    public BookDto(int id, String name, Genre genre, String description, int countOfPages, Author author, LocalDate dateOfPublication, Publisher publisher, float price, int quantity, String pathImage) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.countOfPages = countOfPages;
        this.author = author;
        this.dateOfPublication = dateOfPublication;
        this.publisher = publisher;
        this.price = price;
        this.quantity = quantity;
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(LocalDate dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }
}
