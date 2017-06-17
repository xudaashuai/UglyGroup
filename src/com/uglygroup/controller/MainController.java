package com.uglygroup.controller;

import com.uglygroup.Utils.ShopDataUtils;
import com.uglygroup.Utils.UserDataUtils;
import com.uglygroup.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * UglyGroup
 * Created by xudas on 2017/6/4.
 *
 */
@Controller
public class MainController {
    //首页
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("types",new String[]{"1","2","3","4"});
        return modelAndView;
    }
    //用户个人首页
    @RequestMapping(path = "/user",method = RequestMethod.GET)
    public ModelAndView me(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("me");
        User user=(User)request.getSession().getAttribute("user");
        modelAndView.addObject("user",user);
        modelAndView.addObject("friend",UserDataUtils .selectUserFriend(user.getId()));
        modelAndView.addObject("follow",UserDataUtils.selectUserFollow(user.getId()));
        return modelAndView;
    }
    //查看其他用户信息
    @RequestMapping(path = "/user/{userId}",method = RequestMethod.GET)
    public ModelAndView user(HttpServletRequest request, @PathVariable("userId") String userId){
        //todo 判断是否是自己
        ModelAndView modelAndView=new ModelAndView("user");
        modelAndView.addObject("user", UserDataUtils.selectUserInfor(Integer.parseInt(userId)));
        return modelAndView;
    }
    //查看商家信息
    @RequestMapping(path = "/shop",method = RequestMethod.GET)
    public ModelAndView shop(HttpServletRequest request){
        ModelAndView modelAndView=new ModelAndView("shop");
        //modelAndView.addObject("shop", ShopsDataUtils.selectShop("qeq"));

        return modelAndView;
    }
}
