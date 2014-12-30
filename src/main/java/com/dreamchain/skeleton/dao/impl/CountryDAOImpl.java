package com.dreamchain.skeleton.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dreamchain.skeleton.dao.CountryDAO;
import com.dreamchain.skeleton.model.Country;
import java.util.List;

/**
 * Created by przemek on 2014-11-05.
 */
@Repository
public class CountryDAOImpl implements CountryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Country getCountry(String id) {
        Session session = this.sessionFactory.openSession();
        return (Country) session.createQuery("from Country where c.countryId = :aa").setParameter("aa", id).uniqueResult();
    }

    @Override
    public List<Country> getAll() {
        Session session = this.sessionFactory.openSession();
        return session.createQuery("from Country").list();
    }

    @Override
    public void add(Country c) {
        Session session = this.sessionFactory.openSession();
        session.save(c);

    }

    @Override
    public void remove(Country c) {

    }

    @Override
    public void update(Country c) {

    }
}
