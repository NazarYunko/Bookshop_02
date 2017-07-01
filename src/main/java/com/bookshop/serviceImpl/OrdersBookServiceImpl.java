package com.bookshop.serviceImpl;

import com.bookshop.dao.OrdersBookDao;
import com.bookshop.entity.Book;
import com.bookshop.entity.Orders;
import com.bookshop.entity.OrdersBook;
import com.bookshop.entity.OrdersBookId;
import com.bookshop.service.OrdersBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nazar on 22.06.2017.
 */
@Service
public class OrdersBookServiceImpl implements OrdersBookService{

    @Autowired
    private OrdersBookDao ordersBookDao;

    @Override
    public void save(OrdersBook ordersBook) {
        ordersBookDao.save(ordersBook);
    }

    @Override
    public List<OrdersBook> findAll() {
        return ordersBookDao.findAll();
    }

    @Override
    public OrdersBook findOne(OrdersBookId ordersBookId) {
        return ordersBookDao.findOne(ordersBookId);
    }

    @Override
    public void update(OrdersBook ordersBook) {
        ordersBookDao.save(ordersBook);
    }

    @Override
    public void delete(OrdersBookId ordersBookId) {
        ordersBookDao.delete(ordersBookId);
    }

    @Override
    public OrdersBook findOrdersAndBook(Orders orders, Book book) {
        return ordersBookDao.findOrdersAndBook(orders, book);
    }
}
