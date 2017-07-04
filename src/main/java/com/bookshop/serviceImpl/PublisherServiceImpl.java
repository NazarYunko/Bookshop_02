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
    public boolean save(Publisher publisher){
        if(publisherDao.findByName(publisher.getName()) == null) {
            publisherDao.save(publisher);
            return true;
        } else {
            return false;
        }
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
    public boolean update(Publisher publisher){
        if (publisherDao.findByIdAndName(publisher.getId(), publisher.getName()) != null) {
            publisherDao.save(publisher);
            return true;
        }
        if (publisherDao.findByName(publisher.getName()) == null) {
            publisherDao.save(publisher);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Publisher findByName(String name) {
        return publisherDao.findByName(name);
    }
}
