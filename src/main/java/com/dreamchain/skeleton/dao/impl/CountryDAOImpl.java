package com.dreamchain.skeleton.dao.impl;

import com.dreamchain.skeleton.dao.CountryDAO;
import com.dreamchain.skeleton.model.Country;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by przemek on 2014-11-05.
 */
@Repository
public class CountryDAOImpl implements CountryDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Country getCountry(String id) {

        return (Country) em.createQuery("from Country where c.countryId = :aa").setParameter("aa", id).getSingleResult();
    }

    @Override
    public List<Country> getAll() {
        return em.createQuery("from Country").getResultList();
    }

    @Override
    @Transactional
    public void add(Country c) {
        em.persist(c);
    }

    @Override
    @Transactional
    public void remove(Country c) {
        System.out.println("BEFORE");
        c = em.merge(c);
        System.out.println("MERGED");
        em.remove(c);
        System.out.println("AFTER");
    }

    @Override
    public void update(Country c) {

    }
}
