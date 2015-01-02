package com.dreamchain.skeleton.dao.impl;

import com.dreamchain.skeleton.dao.RegionDAO;
import com.dreamchain.skeleton.model.Region;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by przemek on 2015-01-02.
 */
@Repository
public class RegionDAOImpl implements RegionDAO{

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Region region) {
        em.persist(region);
    }

    @Override
    public void remove(Region region) {
        em.remove(region);
    }

    @Override
    public Region getById(int id) {
        return (Region) em.createQuery("select r from Region r where r.id = :id").setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Region> getAll() {
        return em.createQuery("select r from Region r order by r.name").getResultList();
    }
}
