package com.bookshop.dto;

import com.bookshop.entity.Country;

/**
 * Created by Study on 24.06.2017.
 */
public class CityDto {

    private int id;

    private String name;

    private CountryDto country;

    public CityDto() {
    }

    public CityDto(int id, String name, CountryDto country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CountryDto getCountry() {
        return country;
    }

    public void setCountry(CountryDto country) {
        this.country = country;
    }
}
