package com.bookshop.dao;

import com.bookshop.entity.Author;
import com.bookshop.entity.Book;
import com.bookshop.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface BookDao extends JpaRepository<Book, Integer> {

    Book findByNameAndAuthorAndPublisherAndDateOfPublication(String name, Author author, Publisher publisher, LocalDate date);

}
