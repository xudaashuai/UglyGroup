package com.uglygroup.controller;

import com.uglygroup.Utils.MessageUtils;
import com.uglygroup.Utils.RankUtils;
import com.uglygroup.Utils.ShopDataUtils;
import com.uglygroup.Utils.UserDataUtils;
import com.uglygroup.model.Message;
import com.uglygroup.model.Rank;
import com.uglygroup.model.Shop;
import com.uglygroup.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * UglyGroup
 * Created by xudas on 2017/6/4.
 */
@Controller
@SessionAttributes("user")
public class MainController {
    //首页
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
        ArrayList<Shop> shops = ShopDataUtils.getRandomShop();

        modelAndView.addObject("shops", shops);
        modelAndView.addObject("users", UserDataUtils.getRandomUser());
        modelAndView.addObject("ranks", RankUtils.getRandomRank());
        return modelAndView;
    }

    //用户个人首页
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public ModelAndView me(HttpServletRequest request, @ModelAttribute("user") User user, Integer id) {
        if (id==null||id == user.getId()) {
            ModelAndView modelAndView = new ModelAndView("me");
            modelAndView.addObject("user", user);
            Message messages = MessageUtils.selectMessage(user.getId());
            modelAndView.addObject("");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("user");
            modelAndView.addObject("user", UserDataUtils.selectUserInfor(id));
            return modelAndView;
        }
    }

    //查看商家信息
    @RequestMapping(path = "/shop", method = RequestMethod.GET)
    public ModelAndView shop(HttpServletRequest request, Integer id) {
        ModelAndView modelAndView = new ModelAndView("shop");
        modelAndView.addObject("shop", ShopDataUtils.selectShop(id));
        return modelAndView;
    }
    @RequestMapping(path = "/search")
    public ModelAndView search(String keyword){
        ModelAndView modelAndView = new ModelAndView("search");
        modelAndView.addObject("shops", ShopDataUtils.searchShop(keyword,0));
        modelAndView.addObject("keyword",keyword);
        return modelAndView;
    }
    @RequestMapping(path = "/we")
    public String we(String keyword) {
        return "we";
    }
    @RequestMapping(path = "/rank")
    public ModelAndView rank(Integer id) {
        if (id==null){
            ModelAndView modelAndView = new ModelAndView("top");
            ArrayList<Rank> s=RankUtils.getAllRank(0);
            modelAndView.addObject("ranks",s);
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("rank");
            modelAndView.addObject("rank", RankUtils.selectRank(id));
            return modelAndView;
        }
    }
}
