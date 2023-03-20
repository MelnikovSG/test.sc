package com.test.sc.dao;

import com.test.sc.assistants.CreateDate;
import com.test.sc.assistants.ServiceCounter;
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
    private ServiceCounter serviceCounter = new ServiceCounter();

    @Override
    public List<Services> getAllServices() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Services", Services.class).getResultList();
    }

    @Override
    public void saveServices(Services services) {
        services.setCreatedDate(date.simpleDate());
        if(serviceCounter.canAddService()) {
            Session session = sessionFactory.getCurrentSession();
            session.save(services);
            serviceCounter.removeService();
        }else{
            services.setServiceSaved(false);
        }
    }

    @Override
    public Services getServicesById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Services services = session.get(Services.class, id);
        return services;
    }
}
