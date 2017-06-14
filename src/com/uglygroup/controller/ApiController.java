package com.uglygroup.controller;

import com.uglygroup.Utils.ShopDataUtils;
import com.uglygroup.Utils.UserDataUtils;
import com.uglygroup.Utils.Utils;
import com.uglygroup.model.Shop;
import com.uglygroup.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
 *
 */
@Controller
public class ApiController {
    @RequestMapping(path = "/api/user/login",method = RequestMethod.POST)
    public @ResponseBody
    Map<String,Object> userLogin(String username, String password, HttpServletRequest request,HttpServletResponse response){
        User u=new User();
        Map<String,Object> map=new HashMap<>();
        Utils.loginStatus status;
        String str;
        status= UserDataUtils.login(username,password,u);
        if (status.equals(Utils.loginStatus.SUCCESS)){
            map.put("status",true);
            request.getSession().setAttribute("user",u);
            String value = username + "#" + password;
            System.out.println(value);
            Cookie loginCookies = new Cookie("login", value);
            loginCookies.setMaxAge(Integer.MAX_VALUE);
            loginCookies.setPath("/");
            response.addCookie(loginCookies);
        }
        else{
            map.put("status",false);
            map.put("errorMessage",status.toString());
        }
        return map;
    }

    @RequestMapping(path = "/api/user/register",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userRegister(String username, String password,String nickname){
        Map<String,Object> map=new HashMap<>();
        Utils.registerStatus status;
        String str;
        status= UserDataUtils.register(username,password,nickname);
        if (status.equals(Utils.registerStatus.SUCCESS)){
            map.put("status",true);
        }
        else{
            map.put("status",false);
            map.put("errorMessage",status.toString());
        }

        return map;

    }
    @RequestMapping(path = "/api/user/set_sex",method =RequestMethod.POST )
    public @ResponseBody


    Map<String,Object> userSetSex(String newSex,int id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(id);
        u.setSex(newSex);
        return map;

    }
    @RequestMapping(path = "/api/user/set_age",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSetAge(int newAge,int id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(id);
        u.setAge(newAge);
        return map;

    }
    @RequestMapping(path = "/api/user/set_nickname",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSetNickname(String newNickname,int id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(id);
        u.setNickName(newNickname);
        return map;
    }


    @RequestMapping(path = "/api/user/set_password",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object>  userSetPassword(String newPassword,int id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(id);
        u.setPassword(newPassword);
        return map;

    }
    @RequestMapping(path = "/api/user/set_headPicture",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSetHeadPicture(String newHeadPicture,int id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(id);
        u.setHeadPicture(newHeadPicture);
        return map;

    }
    @RequestMapping(path = "/api/user/set_birthday",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSetBirthday(String newBirthday,int id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(id);
        u.setBirthday(newBirthday);
        return map;

    }
    @RequestMapping(path = "/api/user/set_sign",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSetSign(String newSign,int id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(id);
        u.setSign(newSign);
        return map;
//
    }
    @RequestMapping(path = "/api/user/search_user",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSearchUser(String keyword){
        Map<String,Object> map=new HashMap<>();
        ArrayList<User> users=new ArrayList<>();
        users=UserDataUtils.searchUser(keyword);
        map.put("list",users);
        return map;

    }
    @RequestMapping(path = "/api/user/add_friend",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userAddFriend(int id,int friendId){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(id);
        Utils.addStatus status;
        status=u.addFriend(friendId);
        if(status.equals(Utils.addStatus.ADDSUCCESS)){
            map.put("status",true);
        }
        else map.put("status",false);
        return map;

    }
    @RequestMapping(path = "/api/shop/get_todayShop",method =RequestMethod.GET )
    public @ResponseBody
    Map<String,Object> getTodayShop(){
        Map<String,Object> map=new HashMap<>();
        ArrayList<Shop>shops=new ArrayList<>();
        shops=ShopDataUtils.getRandomShop();
        map.put("shops",shops);
        return map;

    }

}