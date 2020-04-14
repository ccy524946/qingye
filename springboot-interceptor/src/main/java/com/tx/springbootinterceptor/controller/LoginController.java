package com.tx.springbootinterceptor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @PostMapping("/doLogin")
    public String login(String userName, String password, HttpSession session) {
        if (userName.equals("wcy") && password.equals("123")) {
            session.setAttribute("user", userName);
            return "index";
        }
        return "login";
    }

    @GetMapping("/login")
    public String loginView() {
        return "login";
    }
}
