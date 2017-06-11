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

    @RequestMapping(path = "/test/login", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String testLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();

        System.out.println(username + " " + password);
        User user = new User();
        switch (UserDataUtils.login(username, password, user)) {
            case SUCCESS:
                login(username, password, response, session);
                session.setAttribute("user", user);
                return "ok";
            case PASSWORDERROR:
                return "pe";
            case LOGINNAMENOEXIST:
                return "le";
        }
        return "e";
    }
    @RequestMapping(path = "/test/register", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String testRegister(String username, String password,String nickname, HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        System.out.println(username + " " + password);
        User user = new User();
        switch (UserDataUtils.register(username,password)) {
            case SUCCESS:
                if (UserDataUtils.login(username, password, user) == Utils.loginStatus.SUCCESS) {
                    login(username, password, response, session);
                    user.setNickName(nickname);
                    session.setAttribute("user", user);
                    return "ok";
                }
                break;
            case LOGINNAMEEXIST:
                return "le";
        }
        return "e";
    }

    private void login(String username, String password, HttpServletResponse response, HttpSession session) {
        String value = username + "#" + password;
        System.out.println(value);
        Cookie loginCookies = new Cookie("login", value);
        loginCookies.setMaxAge(Integer.MAX_VALUE);
        loginCookies.setPath("/");
        response.addCookie(loginCookies);
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
