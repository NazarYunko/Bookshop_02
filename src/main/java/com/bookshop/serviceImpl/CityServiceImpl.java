package com.bookshop.serviceImpl;

import com.bookshop.dao.CityDao;
import com.bookshop.entity.City;
import com.bookshop.entity.Country;
import com.bookshop.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean save(City city) {
        if (cityDao.findByNameAndCountry(city.getName(), city.getCountry()) == null) {
            cityDao.save(city);
            return true;
        } else {
            return false;
        }
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
    public boolean update(City city) {
        if (cityDao.findByIdAndNameAndCountry(city.getId(), city.getName(), city.getCountry()) != null) {
            cityDao.save(city);
            return true;
        }

        if (cityDao.findByNameAndCountry(city.getName(), city.getCountry()) == null) {
            cityDao.save(city);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public City findByName(String name) {
        return cityDao.findByName(name);
    }

    @Override
    public List<City> findAllSortedCities() {
        return cityDao.findAllSortedCities();
    }

    @Override
    public List<City> findByCountry(Country country) {
        return cityDao.findByCountry(country);
    }
}
