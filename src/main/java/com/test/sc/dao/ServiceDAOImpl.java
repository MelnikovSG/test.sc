package com.test.sc.dao;

import com.test.sc.entity.Services;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ServiceDAOImpl implements ServiceDAO{

    @Autowired
    private SessionFactory sessionFactory;
    @Override
    @Transactional
    public List<Services> getAllServices() {
        Session session = sessionFactory.getCurrentSession();
        List<Services> allServices = session.createQuery("from Services", Services.class).getResultList();
        return allServices;
    }
}
