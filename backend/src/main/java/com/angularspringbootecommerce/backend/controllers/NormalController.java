package com.angularspringbootecommerce.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class NormalController {
    @GetMapping("/demo")
    public String logingoogle(){
        return "loginpage";
    }


}
