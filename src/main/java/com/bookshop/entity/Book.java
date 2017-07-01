package com.bookshop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private Genre genre;

    @Lob
    private String description;

    @Column(name = "count_of_pages")
    private int countOfPages;

    @ManyToOne
    private Author author;

    @Column(name = "date_of_publication")
    private LocalDate dateOfPublication;

    @ManyToOne
    private Publisher publisher;

    private float price;

    private int quantity;

    private String pathImage;

    @OneToMany(mappedBy = "id.book")
    private List<OrdersBook> ordersBooks = new ArrayList<>();

    public Book(String name, Genre one, String description, int countOfPages, Author authorServiceOne, LocalDate parse, Publisher publisherServiceOne, float price, int quantity) {

    }

    public Book(String name, Genre genre, String description, int countOfPages, Author author, LocalDate dateOfPublication, Publisher publisher, float price, int quantity, String pathImage, List<OrdersBook> ordersBooks) {
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
        this.ordersBooks = ordersBooks;
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

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public List<OrdersBook> getOrdersBooks() {
        return ordersBooks;
    }

    public void setOrdersBooks(List<OrdersBook> ordersBooks) {
        this.ordersBooks = ordersBooks;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (name != null ? !name.equals(book.name) : book.name != null) return false;
        return author != null ? author.equals(book.author) : book.author == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        return result;
    }
}
