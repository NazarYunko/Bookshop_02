package com.bookshop.serviceImpl;

import com.bookshop.dao.PublisherDao;
import com.bookshop.entity.Publisher;
import com.bookshop.service.PublisherService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
@Service
public class PublisherServiceImpl implements PublisherService {

    @Autowired
    private PublisherDao publisherDao;

    @Override
    public void save(Publisher publisher, MultipartFile image){

        String path = System.getProperty("catalina.home") + "/resources/" +
                publisher.getName() + "/" + image.getOriginalFilename();

        publisher.setPathImage("resources/" + publisher.getName() + "/" + image.getOriginalFilename());
        File filePath = new File(path);

        try {
            filePath.mkdirs();
            image.transferTo(filePath);
        } catch (IOException e) {}
        publisherDao.save(publisher);
    }

    @Override
    public List<Publisher> findAll() {
        return publisherDao.findAll();
    }

    @Override
    public Publisher findOne(int id) {
        return publisherDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        publisherDao.delete(id);
    }

    @Override
    public void update(Publisher publisher, MultipartFile image){
        String path = System.getProperty("catalina.home") + "/resources/" +
                publisher.getName() + "/" + image.getOriginalFilename();
        publisher.setPathImage("resources/" + publisher.getName() + "/" + image.getOriginalFilename());
        File filePath = new File(path);
        try {
            filePath.mkdirs();
            try {
                FileUtils.cleanDirectory(new File(System.getProperty("catalina.home") + "/resources/" +
                        publisher.getName() + "/" ));
            } catch (IOException e){
                System.out.println("error");
            }
            image.transferTo(filePath);
        } catch (IOException e) {}
        publisherDao.save(publisher);
    }

    @Override
    public Publisher findByName(String name) {
        return publisherDao.findByName(name);
    }
}
