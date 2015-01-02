package com.dreamchain.skeleton.dao;

import com.dreamchain.skeleton.model.Region;

import java.util.List;

/**
 * Created by przemek on 2015-01-02.
 */
public interface RegionDAO {
    void add(Region region);
    void remove(Region region);
    Region getById(int id);
    List<Region> getAll();
}
