package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer create(Customer c) {
        return repo.save(c);
    }

    public Customer update(Long id, Customer updated) {
        Customer c = repo.findById(id).orElseThrow();

        c.setFname(updated.getFname());
        c.setLname(updated.getLname());
        c.setEmail(updated.getEmail());
        c.setPhone(updated.getPhone());

        return repo.save(c);
    }
    public void delete(Long id) {
    repo.deleteById(id);
}
}