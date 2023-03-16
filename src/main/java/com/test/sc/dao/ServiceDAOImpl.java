package com.test.sc.dao;

import com.test.sc.assistants.CreateDate;
import com.test.sc.entity.Services;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ServiceDAOImpl implements ServiceDAO {

    @Autowired
    private SessionFactory sessionFactory;
    private CreateDate date = new CreateDate();

    @Override
    public List<Services> getAllServices() {
        Session session = sessionFactory.getCurrentSession();
        List<Services> allServices = session.createQuery("from Services", Services.class).getResultList();
        return allServices;
    }

    @Override
    public void saveServices(Services services) {
        services.setCreatedDate(date.simpleDate());
        Session session = sessionFactory.getCurrentSession();
        session.save(services);
    }

    @Override
    public Services getServicesById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Services services = session.get(Services.class, id);
        return services;
    }
}
