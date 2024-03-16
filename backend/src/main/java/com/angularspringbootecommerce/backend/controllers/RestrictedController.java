package com.angularspringbootecommerce.backend.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RestrictedController {

    @GetMapping("/authenticated")
    public String authenticatedPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("username", auth.getName()); // Passing username to the view
        return "authenticated"; // A secured page displaying user information
    }

    @GetMapping("/api/secure-data")
    public String secureData(Model model) {
        // Logic to access secure data after authentication
        return "secure-data"; // A page displaying secure data accessible after authentication
    }
}
