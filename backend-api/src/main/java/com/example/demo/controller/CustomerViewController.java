package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomerViewController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerViewController(CustomerService customerService,
            CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/{id}")
    public String getCustomer(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer-profile";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @PostMapping
    public String saveCustomer(@ModelAttribute Customer customer) {
        Customer saved = customerService.create(customer);
        return "redirect:/customers/" + saved.getCustomerId();
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getById(id));
        return "customer-form";
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id,
            @ModelAttribute Customer customer) {

        Customer updated = customerService.update(id, customer);
        return "redirect:/customers/" + updated.getCustomerId();
    }

    @GetMapping("/profile")
    public String showProfile(Model model, Principal principal) {

        Customer customer = customerRepository
                .findByEmail(principal.getName())
                .orElseThrow();

        model.addAttribute("customer", customer);

        return "profile";
    }

    @PostMapping("/profile")
    public String updateProfile(@ModelAttribute Customer updated,
            Principal principal) {

        Customer customer = customerRepository
                .findByEmail(principal.getName())
                .orElseThrow();

        customer.setFname(updated.getFname());
        customer.setLname(updated.getLname());
        customer.setEmail(updated.getEmail());
        customer.setPhone(updated.getPhone());

        customerRepository.save(customer);

        return "redirect:/services";
    }
}
