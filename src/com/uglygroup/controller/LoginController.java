package com.uglygroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by xudas on 2017/6/2.
 */
@Controller
public class LoginController {
    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println(username + " " + password);
        if (username.equals("xudashuai") && password.equals("19980819")) {
            Cookie userNameCookie = new Cookie("loginUserName", username);
            Cookie passwordCookie = new Cookie("loginPassword", password);
            userNameCookie.setMaxAge(Integer.MAX_VALUE);
            userNameCookie.setPath("/");
            passwordCookie.setMaxAge(Integer.MAX_VALUE);
            passwordCookie.setPath("/");
            response.addCookie(userNameCookie);
            response.addCookie(passwordCookie);
            return "index";
        } else {
            return "/login";
        }
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return "login";
    }
}
