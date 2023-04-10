package com.test.sc.controller;

import com.test.sc.assistants.mail.SendEmail;
import com.test.sc.entity.Services;
import com.test.sc.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyController {
    @Autowired
    private ServicesService servicesService;


    @RequestMapping("/All-Services")
    public String showAllServices(Model model) {
        List<Services> allServices = servicesService.getAllServices();
        model.addAttribute("allServices", allServices);
        return "show-All-Services";
    }

    @RequestMapping("/")
    @PreAuthorize("hasRole('USER')")
    public String addNewService(Model model) {
        Services services = new Services();
        model.addAttribute("services", services);
        return "add-New-Service";
    }
    @RequestMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminHome(Model model) {
        return "admin-home";
    }


    @RequestMapping("/saveService")
    public String saveService(@Valid @ModelAttribute("services") Services services,
                              BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-New-Service";
        } else {
            servicesService.saveServices(services);
            SendEmail.sendEmail(services.geteMail(), services.getFirstName(), services.getLastName(),
                            services.getSurName(), services.getServiceName(),
                            services.getCreatedDate(), services.getId());
            return "redirect:/All-Services";
        }
    }

    @RequestMapping("/more-info")
    public String showMoreInfo(@RequestParam("empId") int id, Model model) {
        Services services = servicesService.getServicesById(id);
        model.addAttribute("services", services);
        return "show-more-info";
    }
}
