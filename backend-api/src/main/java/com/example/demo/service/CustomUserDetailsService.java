package com.example.demo.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import com.example.demo.model.Customer;
import com.example.demo.model.Provider;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ProviderRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Customer customer = customerRepository.findByEmail(email).orElse(null);

        if (customer != null) {
            return new User(
                    customer.getEmail(),
                    customer.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_CUSTOMER")));
        }

        Provider provider = providerRepository.findByEmail(email);

        if (provider != null) {
            return new User(
                    provider.getEmail(),
                    provider.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_PROVIDER")));
        }

        throw new UsernameNotFoundException("User not found");
    }
}
