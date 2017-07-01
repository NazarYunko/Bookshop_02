package com.bookshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Nazar on 03.06.2017.
 */
@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private String status;

    private double sum;

    @OneToMany(mappedBy = "id.orders")
    private List<OrdersBook> ordersBooks = new ArrayList<>();

    public Orders() {
    }

    public Orders(User user) {
        this.user = user;
    }

    public Orders(String status) {
        this.status = status;
    }

    public Orders(User user, String status) {
        this.user = user;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public List<OrdersBook> getOrdersBooks() {
        return ordersBooks;
    }

    public void setOrdersBooks(List<OrdersBook> ordersBooks) {
        this.ordersBooks = ordersBooks;
    }

}