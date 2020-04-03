package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/ecommerce/admin/home")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/customers")
    public MappingJacksonValue getCustomers(@RequestParam(defaultValue = "0") String page, @RequestParam(defaultValue = "10")String size, @RequestParam(defaultValue = "userId") String SortBy){
        return adminService.registeredCustomers(page, size, SortBy);
    }

    @GetMapping(path = "/sellers")
    public MappingJacksonValue getSellers(@RequestParam(defaultValue = "0") String page, @RequestParam(defaultValue = "10")String size, @RequestParam(defaultValue = "userId") String SortBy){
        return adminService.registeredSellers(page, size, SortBy);
    }

    @PatchMapping(path = "/activateCustomer/{id}")
    public String activateCustomer(@PathVariable(value = "id") Long id){
        return adminService.activateUser(id);
    }

    @PatchMapping(path = "/de-activateCustomer/{id}")
    public String deactivateCustomer(@PathVariable(value = "id") Long id){
        return adminService.deactivateUser(id);
    }

    @PatchMapping(path = "/activateSeller/{id}")
    public String activateSeller(@PathVariable(value = "id") Long id){
        return adminService.activateUser(id);
    }

    @PatchMapping(path = "/de-activateSeller/{id}")
    public String deactivateSeller(@PathVariable(value = "id") Long id){
        return adminService.deactivateUser(id);
    }
}

