package com.bookshop.service;

import com.bookshop.entity.Author;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface AuthorService {

    void save(Author author, MultipartFile image);

    List<Author> findAll();

    Author findOne(int id);

    void delete(int id);

    void update(Author author, MultipartFile image);

}
