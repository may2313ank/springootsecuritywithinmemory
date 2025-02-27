package com.microservices.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class MainController {

	@GetMapping("/public")
    public String publicPage(HttpServletRequest request) {
        return "public "+request.getSession().getId();
    }

//    @GetMapping("/user")
//    public String userPage() {
//        return "user";
//    }
//
//    @GetMapping("/admin")
//    public String adminPage() {
//        return "admin";
//    }
//
//    @GetMapping("/login")
//    public String loginPage() {
//        return "login";
//    }
}
