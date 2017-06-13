package com.uglygroup.controller;

import com.uglygroup.Utils.UserDataUtils;
import com.uglygroup.Utils.Utils;
import com.uglygroup.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login")) {
                Cookie cookie2 = new Cookie("login", null);
                cookie2.setMaxAge(0);
                cookie2.setPath("/");
                response.addCookie(cookie2);
                request.getSession().removeAttribute("user");
                break;
            }
        }
        return "redirect:/";
    }
}
