package com.uglygroup.controller;

import com.uglygroup.Utils.MessageUtils;
import com.uglygroup.Utils.ShopDataUtils;
import com.uglygroup.Utils.UserDataUtils;
import com.uglygroup.model.Message;
import com.uglygroup.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

/**
 * UglyGroup
 * Created by xudas on 2017/6/4.
 *
 */
@Controller
@SessionAttributes("user")
public class MainController {
    //首页
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("shops",ShopDataUtils.getRandomShop());
        return modelAndView;
    }
    //用户个人首页
    @RequestMapping(path = "/user",method = RequestMethod.GET)
    public ModelAndView me(HttpServletRequest request,@ModelAttribute("user")User user){
        ModelAndView modelAndView=new ModelAndView("me");
        modelAndView.addObject("user",user);
        Message messages= MessageUtils.selectMessage(user.getId());

        modelAndView.addObject("");
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
    @RequestMapping(path = "/shop/{id}",method = RequestMethod.GET)
    public ModelAndView shop(HttpServletRequest request, @PathVariable("id") int id){
        ModelAndView modelAndView=new ModelAndView("shop");
        modelAndView.addObject("shop", ShopDataUtils.selectShop(id));

        return modelAndView;
    }
}
