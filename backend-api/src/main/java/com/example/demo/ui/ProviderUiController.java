package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Provider;
import com.example.demo.service.ProviderService;

@Controller
@RequestMapping("/provider")
public class ProviderUiController {
    @Autowired
    private ProviderService service;

    @GetMapping("")
    public String login(@RequestParam(required = false) Boolean error, Model model)
    {
        model.addAttribute("error", error);
        return "provider-login";
    }
    @PostMapping("/login")
    public String loginProvider(@RequestParam String email, @RequestParam String password, Model model)
    {
        Provider provider = service.login(email, password);
        if (provider != null)
            return "redirect:/provider/dashboard/" + provider.getProviderId();
        else
        {
            model.addAttribute("error", true);
            return "provider-login";
        }
    }

    @GetMapping("/dashboard/{id}")
    public String hub(Model model,@PathVariable Long id)
    {
        model.addAttribute("provider", service.getProviderById(id));
        return "provider-page";
    }

    @GetMapping("/register")
    public String register(Model model)
    {
        model.addAttribute("provider", new Provider());
        return "provider-signup";
    }
    @PostMapping("/register")
    public String createAccount(Provider provider)
    {
        Provider newProvider = service.createProvider(provider);
        if (newProvider != null)
            return "redirect:/provider";
        else
            return "redirect:/provider/add?error=true";
    }

    @GetMapping("/update/{id}")
    public String showUpdatePage(Model model, @PathVariable Long id)
    {
        model.addAttribute("provider", service.getProviderById(id));
        return "provider-update-profile";
    }
    @PostMapping("/update/{id}")
    public String updateProfile(@PathVariable Long id, Provider updated)
    {
        Provider provider = service.updateProvider(id, updated);
        if (provider != null)
            return "redirect:/provider/dashboard/" + provider.getProviderId();
        else
            return "redirect:/provider/update/" + id + "?error=true";
    }
}
