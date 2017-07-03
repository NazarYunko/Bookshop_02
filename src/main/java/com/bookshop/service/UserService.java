package com.bookshop.service;

import com.bookshop.entity.City;
import com.bookshop.entity.User;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface UserService {

    void save(User user);

    List<User> findAll();

    User findOne(int id);

    void delete(int id);

    void update(User user);

    User findByUuid(String uuid);

    User findUserWithOrders(int id);

}
