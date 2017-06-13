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
    Map<String,Object> userLogin(String loginName,String password,User u){
        Map<String,Object> map=new HashMap<>();
        Utils.loginStatus status;
        String str;
        status= UserDataUtils.login(loginName,password,u);
        if (status.equals(Utils.loginStatus.SUCCESS)){
            map.put("status",true);
        }
        else{
            map.put("status",false);
            map.put("errorMassage",status.toString());
        }


        return map;
    }
    @RequestMapping(path = "/api/user/register",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userRegister(String userName, String userPassword){
        Map<String,Object> map=new HashMap<>();
        Utils.registerStatus status;
        String str;
        status= UserDataUtils.register(userName,userPassword);
        if (status.equals(Utils.registerStatus.SUCCESS)){
            map.put("status",true);
        }
        else{
            map.put("status",false);
            map.put("errorMassage",status.toString());
        }

        return map;

    }
    @RequestMapping(path = "/api/user/set/sex",method =RequestMethod.POST )
    public @ResponseBody


    Map<String,Object> userSetSex(String newSex,int Id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(Id);
        u.setSex(newSex);
        return map;

    }
    @RequestMapping(path = "/api/user/set/age",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSetAge(int newAge,int Id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(Id);
        u.setAge(newAge);
        return map;

    }
    @RequestMapping(path = "/api/user/set/nickname",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSetNickname(String newNickname,int Id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(Id);
        u.setNickName(newNickname);
        return map;
    }


    @RequestMapping(path = "/api/user/set/password",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object>  userSetPassword(String newPassword,int Id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(Id);
        u.setPassword(newPassword);
        return map;

    }
    @RequestMapping(path = "/api/user/set/headPicture",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSetHeadPicture(String newHeadPicture,int Id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(Id);
        u.setHeadPicture(newHeadPicture);
        return map;

    }
    @RequestMapping(path = "/api/user/set/birthday",method =RequestMethod.POST )
    public @ResponseBody
    Map<String,Object> userSetBirthday(String newBirthday,int Id){
        Map<String,Object> map=new HashMap<>();
        User u;
        u=UserDataUtils.selectUserInfor(Id);
        u.setBirthday(newBirthday);
        return map;

    }


}