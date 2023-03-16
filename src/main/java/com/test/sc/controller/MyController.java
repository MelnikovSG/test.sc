package com.test.sc.controller;

import com.test.sc.dao.ServiceDAO;
import com.test.sc.entity.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private ServiceDAO serviceDAO;
    @RequestMapping("/All-Services")
    public String showAllServices(Model model){
        List<Services> allServices = serviceDAO.getAllServices();
        model.addAttribute("allServices",allServices);
        return "show-All-Services";
    }
}
