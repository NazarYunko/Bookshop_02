package com.bookshop.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

/**
 * Created by Nazar on 22.06.2017.
 */
@Embeddable
public class OrdersBookId implements Serializable {

    @ManyToOne
    private Orders orders;

    @ManyToOne
    private Book book;

    public OrdersBookId() {
    }

    public OrdersBookId(Orders orders) {
        this.orders = orders;
    }

    public OrdersBookId(Book book) {
        this.book = book;
    }

    public OrdersBookId(Orders orders, Book book) {
        this.orders = orders;
        this.book = book;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersBookId that = (OrdersBookId) o;

        if (orders != null ? !orders.equals(that.orders) : that.orders != null) return false;
        return book != null ? book.equals(that.book) : that.book == null;
    }

    @Override
    public int hashCode() {
        int result = orders != null ? orders.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        return result;
    }
}
