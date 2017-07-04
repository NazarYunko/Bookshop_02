package com.bookshop.dao;

import com.bookshop.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface PublisherDao extends JpaRepository<Publisher, Integer> {

    Publisher findByName(String name);

    Publisher findByIdAndName(int id, String name);

}
