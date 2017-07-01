package com.bookshop.serviceImpl;

import com.bookshop.dao.CityDao;
import com.bookshop.entity.City;
import com.bookshop.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Override
    public void save(City city) {
        cityDao.save(city);
    }

    @Override
    public List<City> findAll() {
        return cityDao.findAll();
    }

    @Override
    public City findOne(int id) {
        return cityDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        cityDao.delete(id);
    }

    @Override
    public void update(City city) {
        cityDao.save(city);
    }

    @Override
    public City findByName(String name) {
        return cityDao.findByName(name);
    }
}
