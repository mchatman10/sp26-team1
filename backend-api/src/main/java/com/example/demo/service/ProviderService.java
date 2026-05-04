package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Provider;
import com.example.demo.repository.ProviderRepository;
import java.util.*;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository repo;
    
    public ProviderService(ProviderRepository rep)
    {
        repo = rep;
    }

    public Provider createProvider(Provider provider)
    {
        return repo.save(provider);
    }

    public List<Provider> getAll()
    {
        return repo.findAll();
    }

    public Provider getProviderById(Long id)
    {
        return repo.findById(id).orElse(null);
    }

    public Provider login(String email, String password)
    {
        Provider provider = repo.findByEmail(email);
        if (provider != null && provider.getPassword().equals(password))
            return provider;
        else
            return null;
    }
    public Provider updateProvider(Long id, Provider provider)
    {
        return repo.findById(id)
        .map(account -> {
            account.setEmail(provider.getEmail());
            account.setPassword(provider.getPassword());
            account.setName(provider.getName());
            account.setGameUser(provider.getGameUser());
            account.setSocials(provider.getSocials());
            account.setBio(provider.getBio());
            return repo.save(account);
        })
        .orElse(null);
    }

    public void deleteProvider(Long id)
    {
        repo.deleteById(id);
    }
}
