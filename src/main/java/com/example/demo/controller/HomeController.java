package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller

public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    @GetMapping("/")
    public String home() {
        try {
            logger.info("Acessando a página inicial");
            return "home";
        } catch (Exception e) {
            logger.error("Erro ao acessar a página inicial {}", e.getMessage(), e);
            return "error";
        }
    }
}
