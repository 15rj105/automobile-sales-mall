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

    @GetMapping("/register.action")
    public String toRegister() {
        return "register";
    }

    @PostMapping("/register.action")
    public String toRegister(String username, String password, String phone, String email, Model model) {
        User user = new User();
        if (username == null || username.length() < 6 || username.length() > 12) {
            model.addAttribute("msg", "用户名长度在6到12之间");
            return "fail";
        }
        if (password == null || password.length() < 6 || password.length() > 12) {
            model.addAttribute("msg", "密码长度在6到12之间");
            return "fail";
        }
        String phoneRegex = "(13[0-9]|14[579]|15[0-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}";
        String emailRegex = "^[a-zA-Z0-9_\\.-]+@([a-zA-Z0-9-]+\\.)+[a-zA-Z0-9]{2,4}$";
        if (!phone.matches(phoneRegex)) {
            model.addAttribute("msg", "手机号格式不正确");
            return "fail";
        }
        if (!email.matches(emailRegex)) {
            model.addAttribute("msg", "邮箱格式不正确");
            return "fail";
        }
        user.setUserName(username)
                .setPassword(password)
                .setPhone(phone)
                .setEmail(email);
        if (userService.addUser(user)) {
            return "login";
        }
        model.addAttribute("msg", "注册失败");
        return "fail";
    }
}
