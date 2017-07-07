package com.bookshop.service;

import com.bookshop.entity.Book;
import com.bookshop.entity.Orders;
import com.bookshop.entity.OrdersBook;
import com.bookshop.entity.OrdersBookId;

import java.util.List;

/**
 * Created by Nazar on 22.06.2017.
 */
public interface OrdersBookService {

    void save(OrdersBook ordersBook);

    List<OrdersBook> findAll();

    OrdersBook findOne(OrdersBookId ordersBookId);

    void update(OrdersBook ordersBook);

    void delete(OrdersBookId ordersBookId);

}
