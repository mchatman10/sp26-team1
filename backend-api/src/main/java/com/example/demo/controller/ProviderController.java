package com.example.demo.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.ProviderService;
import com.example.demo.model.Provider;
import java.util.*;

@RestController
@RequestMapping("/api/provider")
public class ProviderController {
    @Autowired
    private ProviderService service;

    @GetMapping
    public List<Provider> getAll()
    {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id)
    {
        Provider provider = service.getProviderById(id);
        if (provider != null)
        {
            return ResponseEntity.ok(provider);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Provider create(@RequestBody Provider provider)
    {
        return service.createProvider(provider);
    }
}
