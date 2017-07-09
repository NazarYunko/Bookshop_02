package com.bookshop.service;

import com.bookshop.entity.Author;
import com.bookshop.entity.Book;
import com.bookshop.entity.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    void update(Book book);

    void update(Book book, MultipartFile image);

    boolean findByName(String name);

    Book findBookByName(String name);

    boolean findByIdAndName(int id, String name);

    List<Book> findBooksByAuthor(Author author);

    List<Book> findBooksByGenre(Genre genre);

    Page<Book> findAllPages(Pageable pageable);

    List<Book> findNewBooks();
}
