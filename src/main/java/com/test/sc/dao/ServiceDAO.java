package com.test.sc.dao;

import com.test.sc.entity.Services;

import java.util.List;

public interface ServiceDAO {
    public List<Services> getAllServices();

    public void saveServices(Services services);

    public Services getServicesById(int id);
}
