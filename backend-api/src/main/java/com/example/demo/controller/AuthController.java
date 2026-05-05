package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Customer;
import com.example.demo.model.Provider;
import com.example.demo.service.CustomerService;
import com.example.demo.service.ProviderService;

@Controller
public class AuthController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProviderService providerService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String accountType,
            @RequestParam String email,
            @RequestParam String password,
            @ModelAttribute Customer customer) {

        if ("provider".equals(accountType)) {
            Provider provider = new Provider();
            provider.setEmail(email);
            provider.setPassword(password);
            providerService.createProvider(provider);
        } else {
            customer.setEmail(email);
            customer.setPassword(password);
            customerService.saveCustomer(customer);
        }

        return "redirect:/login";
    }
}
