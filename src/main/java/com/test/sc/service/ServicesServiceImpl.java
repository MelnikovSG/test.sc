package com.test.sc.service;

import com.test.sc.dao.ServiceDAO;
import com.test.sc.entity.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService{

    @Autowired
    private ServiceDAO serviceDAO;
    @Override
    @Transactional
    public List<Services> getAllServices() {
        return serviceDAO.getAllServices();
    }

    @Override
    @Transactional
    public void saveServices(Services services) {
        serviceDAO.saveServices(services);
    }

    @Override
    @Transactional
    public Services getServicesById(int id) {
        return serviceDAO.getServicesById(id);
    }
}
