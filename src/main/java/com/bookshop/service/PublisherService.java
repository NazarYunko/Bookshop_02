package com.bookshop.service;

import com.bookshop.entity.Publisher;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface PublisherService {

    void save(Publisher publisher, MultipartFile image);

    List<Publisher> findAll();

    Publisher findOne(int id);

    void delete(int id);

    void update(Publisher publisher, MultipartFile image);

    Publisher findByName(String name);
}
