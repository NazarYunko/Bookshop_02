package com.bookshop.dto;

import com.bookshop.entity.OrdersBook;
import com.bookshop.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazar on 25.06.2017.
 */
public class OrdersDto {

    private int id;

    private UserDto user;

    private String status;

    private double sum;

    private List<OrdersBook> ordersBooks;

    public OrdersDto() {
    }

    public OrdersDto(int id, double sum, List<OrdersBook> ordersBooks) {
        this.id = id;
        this.sum = sum;
        this.ordersBooks = ordersBooks;
    }

    public OrdersDto(int id, UserDto user, String status, double sum, List<OrdersBook> ordersBooks) {
        this.id = id;
        this.user = user;
        this.status = status;
        this.sum = sum;
        this.ordersBooks = ordersBooks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
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
