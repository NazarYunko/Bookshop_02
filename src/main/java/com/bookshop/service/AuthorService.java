package com.bookshop.service;

import com.bookshop.entity.Author;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    void update(Author author);

    void update(Author author, MultipartFile image);

    Author findByNameAndLastName(String name, String lastName);

    boolean updateAuthorValidation(Author author);

    Page<Author> findAllPages(Pageable pageable);

}
