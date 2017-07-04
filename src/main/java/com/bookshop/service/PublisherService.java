package com.bookshop.service;

import com.bookshop.entity.Publisher;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface PublisherService {

    boolean save(Publisher publisher);

    List<Publisher> findAll();

    Publisher findOne(int id);

    void delete(int id);

    boolean update(Publisher publisher);

    Publisher findByName(String name);
}
