package com.bookshop.serviceImpl;

import com.bookshop.dao.BookDao;
import com.bookshop.dao.OrdersBookDao;
import com.bookshop.dao.OrdersDao;
import com.bookshop.dao.UserDao;
import com.bookshop.entity.*;
import com.bookshop.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private OrdersBookDao ordersBookDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Orders orders) {
        ordersDao.save(orders);
    }

    @Override
    public List<Orders> findAll() {
        return ordersDao.findAll();
    }

    @Override
    public Orders findOne(int id) {
        return ordersDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        ordersDao.delete(id);
    }

    @Override
    public void update(Orders orders) {
        ordersDao.save(orders);
    }

    @Override
    public Orders findWithOrdersBook(int id) {
        return ordersDao.findWithOrdersBook(id);
    }

    @Override
    public Orders findUserOrders(User user) {
        Orders order = null;
        for (Orders currentOrder : ordersDao.findOrdersWithOrdersBookByUser(user)) {
            if (currentOrder.getStatus().equalsIgnoreCase("Order in process")) {
                order = currentOrder;
                break;
            }
        }
        return order;
    }

    @Override
    public void addToOrder(User user, Book book, int quantity) {
        boolean bookExist = false;
        boolean orderExist = false;

        if (!user.getOrders().isEmpty()) {
            for (Orders currentOrder : user.getOrders()) {
                if (currentOrder.getStatus().equals("Order in process")) {

                    orderExist = true;
                    Orders currentOrderWithOrdersBook = ordersDao.findWithOrdersBook(currentOrder.getId());

                    for (OrdersBook currentOrdersBook : currentOrderWithOrdersBook.getOrdersBooks()) {

                        if (currentOrdersBook.getBook().equals(book)) {

                            currentOrdersBook.setQuantityBooksToBuy(currentOrdersBook.getQuantityBooksToBuy() + quantity);
                            ordersBookDao.saveAndFlush(currentOrdersBook);
                            book.setQuantity(book.getQuantity() - quantity);
                            currentOrder.setSum(currentOrder.getSum() + (quantity * book.getPrice()));
                            bookExist = true;
                            break;

                        }

                    }

                    if (!bookExist) {

                        ordersBookDao.saveAndFlush(new OrdersBook(new OrdersBookId(currentOrder, book), quantity));
                        currentOrder.setSum(currentOrder.getSum() + (quantity * book.getPrice()));
                        book.setQuantity(book.getQuantity() - quantity);

                    }

                    ordersDao.saveAndFlush(currentOrder);
                }
            }

            if (!orderExist) {
                newOrder(user, book, quantity);
            }

        } else {
            newOrder(user, book, quantity);
        }

        userDao.saveAndFlush(user);
        bookDao.saveAndFlush(book);
    }

    private void newOrder(User user, Book book, int quantity) {
        Orders orders = new Orders(user, "Order in process");
        OrdersBook ordersBook = new OrdersBook(new OrdersBookId(orders, book), quantity);
        orders.getOrdersBooks().add(ordersBook);
        orders.setSum(quantity * book.getPrice());
        ordersDao.saveAndFlush(orders);
        ordersBookDao.saveAndFlush(ordersBook);
        book.setQuantity(book.getQuantity() - quantity);
    }

    @Override
    public void buy(Orders orders) {
        orders.setStatus("Order is completed");
        ordersDao.save(orders);
    }



}
