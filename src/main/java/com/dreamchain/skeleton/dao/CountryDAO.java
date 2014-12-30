package com.dreamchain.skeleton.dao;

import com.dreamchain.skeleton.model.Country;

import java.util.List;

/**
 * Created by przemek on 2014-11-05.
 */
public interface CountryDAO {
    Country getCountry(String id);
    List<Country> getAll();
    void add(Country c);
    void remove(Country c);
    void update(Country c);
}
