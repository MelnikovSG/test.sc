package com.test.sc.service;

import com.test.sc.entity.Services;

import java.util.List;

public interface ServicesService {
    public List<Services> getAllServices();
    public void saveServices(Services services);
    public Services getServicesById(int id);
}
