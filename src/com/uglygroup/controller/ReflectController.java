package com.uglygroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * UglyGroup
 * Created by xudas on 2017/6/17.
 */
@Controller
public class ReflectController {
    //test path = user
    @RequestMapping(path = "/test")
    public @ResponseBody
    Map<String,Object> api(HttpServletRequest request) throws ClassNotFoundException {
        Map<String,Object>map=new HashMap<>();
        return map;
    }
}
