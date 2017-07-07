package com.bookshop.service;

import com.bookshop.entity.Author;
import com.bookshop.entity.Book;
import com.bookshop.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface BookService {

    void save(Book book, MultipartFile image);

    List<Book> findAll();

    Book findOne(int id);

    void delete(int id);

    void update(Book book, MultipartFile image);

    boolean findByName(String name);

    Book findBookByName(String name);

    boolean findByIdAndName(int id, String name);
}
