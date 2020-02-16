package com.school.design.automobile_sales_mall.controller;

import com.school.design.automobile_sales_mall.entity.User;
import com.school.design.automobile_sales_mall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
//@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login.action")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login.action")
    public String login(String username, String password, HttpSession session, Model model) {
        User user = userService.getUserByName(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                session.setAttribute("user", user);
                model.addAttribute("user", user);
                return "index";
            }
        }
        return "login";
    }
}
