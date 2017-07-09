package com.bookshop.serviceImpl;

import com.bookshop.dao.AuthorDao;
import com.bookshop.entity.Author;
import com.bookshop.service.AuthorService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Override
    public void save(Author author, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/" +
                author.getName() + author.getLastName() + "/" + image.getOriginalFilename();
        author.setPathImage("resources/" + author.getName() + author.getLastName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);
        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {
            System.out.println("Error");
        }
        authorDao.save(author);
    }

    @Override
    public List<Author> findAll() {
        return authorDao.findAll();
    }

    @Override
    public Author findOne(int id) {
        return authorDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        authorDao.delete(id);
    }

    @Override
    public void update(Author author, MultipartFile image) {

        String path = System.getProperty("catalina.home") + "/resources/" +
                author.getName() + author.getLastName() + "/" + image.getOriginalFilename();
        author.setPathImage("resources/" + author.getName() + author.getLastName() + "/" + image.getOriginalFilename());

        File filePath = new File(path);

        try {
            filePath.mkdirs();
            try {
                FileUtils.cleanDirectory(new File(System.getProperty("catalina.home") + "/resources/" +
                        author.getName() + author.getLastName() + "/"));
            } catch (IOException e){}
            image.transferTo(filePath);
        } catch (IOException e) {}

        authorDao.save(author);
    }

    @Override
    public void update(Author author) {
        authorDao.save(author);
    }

    @Override
    public Author findByNameAndLastName(String name, String lastName) {
        return authorDao.findByNameAndLastName(name, lastName);
    }

    @Override
    public boolean updateAuthorValidation(Author author) {
        if (authorDao.findByIdAndNameAndLastName(author.getId(), author.getName(), author.getLastName()) != null) {
            return true;
        }

        if (authorDao.findByNameAndLastName(author.getName(), author.getLastName()) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Page<Author> findAllPages(Pageable pageable) {
        return authorDao.findAll(pageable);
    }

}
