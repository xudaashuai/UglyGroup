package com.uglygroup.controller;

import com.uglygroup.model.Shop;
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
    @RequestMapping(path = "/api/today_recommend",method = RequestMethod.GET)
    public @ResponseBody
    Map<String,Object> todayRecommend(){
        Map<String,Object> map=new HashMap<>();
        Shop shop=new Shop();
        //shop.allSet("1","1","1","1",1,1,1,1,1,"1","1","1","1",1);
        ArrayList<Shop> list=new ArrayList<Shop>();
        //list.add(shop);
        map.put("key",list);
        return map;
    }
}