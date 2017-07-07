package com.bookshop.serviceImpl;

import com.bookshop.dao.OrdersBookDao;
import com.bookshop.dao.OrdersDao;
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

    @Autowired
    private OrdersDao ordersDao;

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
        Orders orders = ordersDao.findOne(ordersBookId.getOrders().getId());
        OrdersBook ordersBook = ordersBookDao.findOne(ordersBookId);
        orders.setSum(orders.getSum() - (ordersBookId.getBook().getPrice() * ordersBook.getQuantityBooksToBuy()));
        ordersDao.save(orders);
        ordersBookDao.save(ordersBook);
        ordersBookDao.delete(ordersBookId);
    }

}
