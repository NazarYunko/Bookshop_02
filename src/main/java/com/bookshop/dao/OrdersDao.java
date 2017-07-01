package com.bookshop.dao;

import com.bookshop.entity.Orders;
import com.bookshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface OrdersDao extends JpaRepository<Orders, Integer> {

    @Query("select o from Orders o left join fetch o.ordersBooks where o.id=:id")
    Orders findWithOrdersBook(@Param("id") int id);

    Orders findByUser(User user);

    @Query("select distinct o from Orders o left join fetch o.ordersBooks where o.user=:user")
    List<Orders> findOrdersWithOrdersBookByUser(@Param("user") User user);
}
