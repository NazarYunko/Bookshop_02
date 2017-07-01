package com.bookshop.service;

import com.bookshop.entity.Book;
import com.bookshop.entity.Orders;
import com.bookshop.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface OrdersService {

    void save(Orders orders);

    List<Orders> findAll();

    Orders findOne(int id);

    void delete(int id);

    void update(Orders orders);

    Orders findUserOrders(User user);

    void addToOrder(User user, Book book, int quantity);

    Orders findWithOrdersBook(int id);

//    Orders findByUser(User user);

//    Orders findOrdersWithOrdersBookByUser(User user);

    void buy(Orders orders);

}
