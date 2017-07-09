package com.bookshop.dao;

import com.bookshop.entity.Author;
import com.bookshop.entity.Book;
import com.bookshop.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Nazar on 03.06.2017.
 */
public interface BookDao extends JpaRepository<Book, Integer> {

    Book findByName(String name);

    Book findByIdAndName(int id, String name);

    @Query("select distinct b from Book b where b.author=:author")
    List<Book> findBooksByAuthor(@Param("author") Author author);

    @Query("select distinct b from Book b where b.genre=:genre")
    List<Book> findBooksByGenre(@Param("genre") Genre genre);

    @Query("select distinct b from Book b order by b.id desc")
    List<Book> findNewBooks();

}
