package com.bookshop.serviceImpl;

import com.bookshop.dao.CountryDao;
import com.bookshop.entity.Country;
import com.bookshop.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nazar on 04.06.2017.
 */
@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryDao countryDao;

    @Override
    public boolean save(Country country) {
        if (countryDao.findByName(country.getName()) == null) {
            countryDao.save(country);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Country> findAll() {
        return countryDao.findAll();
    }

    @Override
    public Country findOne(int id) {
        return countryDao.findOne(id);
    }

    @Override
    public void delete(int id) {
        countryDao.delete(id);
    }

    @Override
    public boolean update(Country country) {
        if (countryDao.findByIdAndName(country.getId(), country.getName()) != null) {
            countryDao.save(country);
            return true;
        }
        if (countryDao.findByName(country.getName()) == null) {
            countryDao.save(country);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Country findByName(String name) {
        return countryDao.findByName(name);
    }

    @Override
    public Country findCountryWithCities(int id) {
        return countryDao.findCountryWithCities(id);
    }

    @Override
    public List<Country> findAllSortedCountries() {
        return countryDao.findAllSortedCountries();
    }

}
