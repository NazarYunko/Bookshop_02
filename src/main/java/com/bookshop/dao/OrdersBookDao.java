package com.bookshop.dao;

import com.bookshop.entity.Book;
import com.bookshop.entity.Orders;
import com.bookshop.entity.OrdersBook;
import com.bookshop.entity.OrdersBookId;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Nazar on 22.06.2017.
 */
public interface OrdersBookDao extends JpaRepository<OrdersBook, OrdersBookId> {

    @Query("select o from OrdersBook o where o.id.orders=:orders and o.id.book=:book")
    OrdersBook findOrdersAndBook(@Param("orders") Orders orders, @Param("book") Book book);

}
