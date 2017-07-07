package com.uglygroup.controller;

import com.uglygroup.Utils.*;
import com.uglygroup.model.Comment;
import com.uglygroup.model.Message;
import com.uglygroup.model.Shop;
import com.uglygroup.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * UglyGroup
 * Created by xudas on 2017/6/5.
 */
@Controller
@SessionAttributes("user")
public class ApiController {
    @RequestMapping(path = "/api/user/login", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        User u = new User();
        Map<String, Object> map = new HashMap<>();
        Utils.loginStatus status;
        String str;
        status = UserDataUtils.login(username, password, u);
        if (status.equals(Utils.loginStatus.SUCCESS)) {
            map.put("status", true);
            request.getSession().setAttribute("user", u);
            String value = username + "#" + password;
            System.out.println(value);
            Cookie loginCookies = new Cookie("login", value);
            loginCookies.setMaxAge(Integer.MAX_VALUE);
            loginCookies.setPath("/");
            response.addCookie(loginCookies);
        } else {
            map.put("status", false);
            map.put("errorMessage", status.toString());
        }
        return map;
    }

    @RequestMapping(path = "/api/user/register", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userRegister(String username, String password, String nickname) {
        Map<String, Object> map = new HashMap<>();
        //..
        Utils.registerStatus status;
        String str;
        status = UserDataUtils.register(username, password, nickname);
        if (status.equals(Utils.registerStatus.SUCCESS)) {
            map.put("status", true);
        } else {
            map.put("status", false);
            map.put("errorMessage", status.toString());
        }

        return map;

    }

    @RequestMapping(path = "/api/user/set_sex", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userSetSex(String newSex, @ModelAttribute("user") User u) {
        Map<String, Object> map = new HashMap<>();
        u.setSex(newSex);
        return map;

    }

    @RequestMapping(path = "/api/user/set_age", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userSetAge(int newAge, @ModelAttribute("user") User u) {
        Map<String, Object> map = new HashMap<>();
        u.setAge(newAge);
        return map;

    }

    @RequestMapping(path = "/api/user/set_nickname", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userSetNickname(String newNickname, @ModelAttribute("user") User u) {
        Map<String, Object> map = new HashMap<>();
        u.setNickName(newNickname);
        return map;
    }


    @RequestMapping(path = "/api/user/set_password", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userSetPassword(String newPassword, @ModelAttribute("user") User u, String oldPassword) {
        Map<String, Object> map = new HashMap<>();
        if (u.getPassword().equals(oldPassword)) {
            u.setPassword(newPassword);
            map.put("status", true);
        } else {
            map.put("status", false);
        }
        return map;

    }

    @RequestMapping(path = "/api/user/set_headPicture", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userSetHeadPicture(String newHeadPicture, @ModelAttribute("user") User u) {
        Map<String, Object> map = new HashMap<>();
        u.setHeadPicture(newHeadPicture);
        return map;

    }

    @RequestMapping(path = "/api/user/set_birthday", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userSetBirthday(String newBirthday, @ModelAttribute("user") User u) {
        Map<String, Object> map = new HashMap<>();
        u.setBirthday(newBirthday);
        return map;

    }

    @RequestMapping(path = "/api/user/set_sign", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userSetSign(String newSign, @ModelAttribute("user") User u) {
        Map<String, Object> map = new HashMap<>();
        u.setSign(newSign);
        return map;
//
    }

    @RequestMapping(path = "/api/user/search_user", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userSearchUser(@ModelAttribute("user") User u, String keyword, int page, String searchWhat) {
        Map<String, Object> map = new HashMap<>();
        ArrayList<User> users = new ArrayList<>();
        users = UserDataUtils.searchUser(u.getId(), keyword, page, searchWhat);
        map.put("list", users);
        return map;
    }

    @RequestMapping(path = "/api/user/check_message", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> userCheckMessage(int type, int status, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        User u = (User) request.getSession().getAttribute("user");
        ArrayList<Message> messages = new ArrayList<>();
        messages = u.checkMessage(type, status);
        map.put("shops", messages);
        return map;
    }

    @RequestMapping(path = "/api/user/add_follow", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addFollow(int id, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        User u = (User) request.getSession().getAttribute("user");
        u.addFollow(id);
        return map;
    }


    @RequestMapping(path = "/api/message/send_message", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> sendMessage(@ModelAttribute("user") User u, int dst, int type) {
        Map<String, Object> map = new HashMap<>();
        MessageUtils.addMessage(u.getId(), dst, type);
        return map;
    }

    @RequestMapping(path = "/api/message/set_read", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> setRead(int id, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        User u = (User) request.getSession().getAttribute("user");
        u.setRead(id);
        return map;
    }
    @RequestMapping(path = "/api/shop/select_shop_comment", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> selectShopComment(HttpServletRequest request,int page) {
        Map<String, Object> map = new HashMap<>();
        Shop s=(Shop)request.getSession().getAttribute("shop");
        ArrayList<Comment> c=s.selectShopComment(page);
        map.put("list",c);
        return map;
    }
    @RequestMapping(path = "/api/shop/get_allShop", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> getAllShop(int page) {
        Map<String, Object> map = new HashMap<>();

        ArrayList<Shop> shops;
        shops = ShopDataUtils.getAllShop(page);
        map.put("list", shops);
        return map;
    }

    @RequestMapping(path = "/api/shop/get_todyShop", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getTodayShop() {
        Map<String, Object> map = new HashMap<>();
        ArrayList<Shop> shops;
        shops = ShopDataUtils.getRandomShop();
        map.put("list", shops);
        return map;
    }

    @RequestMapping(path = "/api/shop/searchShop", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> searchShop(int page, String keyword) {
        Map<String, Object> map = new HashMap<>();
        ArrayList<Shop> shops = ShopDataUtils.searchShop(keyword, page);
        map.put("list", shops);
        return map;
    }

    @RequestMapping(path = "/api/user/get_todayUser", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getTodayUser() {
        Map<String, Object> map = new HashMap<>();
        ArrayList<User> users = UserDataUtils.getRandomUser();
        map.put("list", users);
        return map;
    }
    @RequestMapping(path = "/api/shop/add_comment", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> addComment(String commentBody,int shopId,int userId,int score,String[]pic) {
        Map<String, Object> map = new HashMap<>();
        CommentUtils.addComment(commentBody,shopId,userId,score,pic);
        map.put("status", true);
        return map;
    }

}