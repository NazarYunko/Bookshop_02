package com.bookshop.serviceImpl;

import com.bookshop.dao.BookDao;
import com.bookshop.entity.Author;
import com.bookshop.entity.Book;
import com.bookshop.entity.Genre;
import com.bookshop.service.BookService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public void save(Book book, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/" + book.getName() + "/" +
                image.getOriginalFilename();

        book.setPathImage("resources/" + book.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("error");
        }

        bookDao.save(book);

    }

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book findOne(int id) {
        return bookDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        bookDao.delete(id);
    }

    @Override
    public void update(Book book, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/" + book.getName() + "/" +
                image.getOriginalFilename();

        book.setPathImage("resources/" + book.getName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            try {
                FileUtils.cleanDirectory(new File(System.getProperty("catalina.home") +
                        "/resources/" + book.getName() + "/"));
            } catch (IOException e) {
            }
            image.transferTo(filePath);
        } catch (IOException e) {
        }

        bookDao.save(book);
    }

    @Override
    public void update(Book book) {
        bookDao.save(book);
    }

    @Override
    public boolean findByName(String name) {
        if (bookDao.findByName(name) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean findByIdAndName(int id, String name) {
        if (bookDao.findByIdAndName(id, name) != null) {
            return true;
        }

        if (bookDao.findByName(name) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book findBookByName(String name) {
        return bookDao.findByName(name);
    }

    @Override
    public List<Book> findBooksByAuthor(Author author) {
        return bookDao.findBooksByAuthor(author);
    }

    @Override
    public List<Book> findBooksByGenre(Genre genre) {
        return bookDao.findBooksByGenre(genre);
    }

    @Override
    public Page<Book> findAllPages(Pageable pageable) {
        return bookDao.findAll(pageable);
    }

    @Override
    public List<Book> findNewBooks() {
        List<Book> newBooks = new ArrayList<>();
        List<Book> foundBook = bookDao.findNewBooks();

        if (foundBook.size() < 20) {
            newBooks.addAll(foundBook);
        } else {
            for (int i = 0; i < 20; i++) {
                newBooks.add(foundBook.get(i));
            }
        }
        return newBooks;
    }
}
