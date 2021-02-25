package com.duonghv.cm.crud.controllers;


import com.duonghv.cm.crud.entities.Customer;
import com.duonghv.cm.crud.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springboot.rest.entities.QueryParamWrapper;
import springboot.rest.exceptions.NotFoundException;
import springboot.rest.services.FilterService;
import springboot.rest.utils.QueryParamExtractor;

@RestController
@RequestMapping("api/v1")
public class CustomerController {

    @Autowired
    private FilterService<Customer, Integer> filterService;

    @Autowired
    private CustomerRepository repo;

    @RequestMapping(value = "customers", method = RequestMethod.POST)
    public Customer create(@RequestBody Customer customer) {
        return repo.save(customer);
    }

    @RequestMapping(value = "customers/{id}", method = RequestMethod.PUT)
    public Customer update(@RequestBody Customer customer, @PathVariable int id) {
        customer.id = id;
        return repo.save(customer);
    }

    @RequestMapping(value = "customers/{id}/published/{value}", method = RequestMethod.POST)
    public Customer publishedUpdate(@PathVariable int id, @PathVariable boolean value) {
        Customer customer = repo.findById(id).orElseThrow(NotFoundException::new);
        customer.published = value;
        return repo.save(customer);
    }


    @RequestMapping(value = "customers/{id}", method = RequestMethod.GET)
    public Customer getById(@PathVariable int id) {
        return repo.findById(id).orElseThrow(NotFoundException::new);
    }

    @RequestMapping(value = "customers", method = RequestMethod.GET)
    public Iterable<Customer> filterBy(
            @RequestParam(required = false, name = "filter") String filterStr,
            @RequestParam(required = false, name = "range") String rangeStr, @RequestParam(required = false, name="sort") String sortStr) {
        QueryParamWrapper wrapper = QueryParamExtractor.extract(filterStr, rangeStr, sortStr);
        return filterService.filterBy(wrapper, repo);
    }
}
