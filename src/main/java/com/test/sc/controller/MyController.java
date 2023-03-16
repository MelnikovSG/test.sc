package com.test.sc.controller;

import com.test.sc.dao.ServiceDAO;
import com.test.sc.entity.Services;
import com.test.sc.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private ServicesService servicesService;
    @RequestMapping("/All-Services")
    public String showAllServices(Model model){
        List<Services> allServices = servicesService.getAllServices();
        model.addAttribute("allServices",allServices);
        return "show-All-Services";
    }

    @RequestMapping("/")
    public String addNewService(Model model){
        Services services = new Services();
        model.addAttribute("services",services);
        return "add-New-Service";
    }

    @RequestMapping("/saveService")
    public String saveService(@ModelAttribute("services") Services services){
        servicesService.saveServices(services);
        return "redirect:/All-Services";
    }

    @RequestMapping("/more-info")
    public String showMoreInfo(@RequestParam("empId") int id, Model model){
        return "add-New-Service";
    }
}
