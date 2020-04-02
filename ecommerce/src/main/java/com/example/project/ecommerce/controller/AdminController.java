package com.example.project.ecommerce.controller;

import com.example.project.ecommerce.model.Customer;
import com.example.project.ecommerce.model.Seller;
import com.example.project.ecommerce.repos.CustomerRepository;
import com.example.project.ecommerce.repos.SellerRepository;
import com.example.project.ecommerce.services.AdminService;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/ecommerce/admin/home")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @GetMapping(path = "/customers")
    public MappingJacksonValue getCustomers(@RequestParam(defaultValue = "0") String page, @RequestParam(defaultValue = "10")String size, @RequestParam(defaultValue = "userId") String SortBy){
        List<Customer> customers = customerRepository.findAll(PageRequest.of(Integer.parseInt(page),Integer.parseInt(size), Sort.by(SortBy))).getContent();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userId","firstName","lastName","email","active");
        FilterProvider filterProvider =  new SimpleFilterProvider().addFilter("CustomerFilter",filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(customers);

        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
    }

    @GetMapping(path = "/sellers")
    public MappingJacksonValue getSellers(@RequestParam(defaultValue = "0") String page, @RequestParam(defaultValue = "10")String size, @RequestParam(defaultValue = "userId") String SortBy){
        List<Seller> sellers = sellerRepository.findAll(PageRequest.of(Integer.parseInt(page),Integer.parseInt(size), Sort.by(SortBy))).getContent();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userId","firstName","lastName","email","active");
        FilterProvider filterProvider =  new SimpleFilterProvider().addFilter("SellerFilter",filter);

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(sellers);

        mappingJacksonValue.setFilters(filterProvider);

        return mappingJacksonValue;
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

