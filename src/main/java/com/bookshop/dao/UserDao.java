package com.bookshop.dao;

import com.bookshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface UserDao extends JpaRepository<User, Integer> {

    @Query("select u from User u where u.login =:parameter or u.email=:parameter")
    User findByLoginOrEmail(@Param("parameter") String parameter);

    User findByLogin(String login);

    User findByEmail(String email);

    @Query("select u from User u where u.uuid=:uuid")
    User findByUuid(@Param("uuid") String uuid);

    @Query("select u from User u left join fetch u.orders where u.id=:id")
    User findUserWithOrders(@Param("id") int id);

}
