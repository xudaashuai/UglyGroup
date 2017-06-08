package com.uglygroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by xudas on 2017/6/4.
 */
@Controller
public class IndexController {
    @RequestMapping(path = "/",method = RequestMethod.GET)
    public ModelAndView index(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("types",new String[]{"1","2","3","4"});
        return modelAndView;
    }
    @RequestMapping(path = "/user",method = RequestMethod.GET)
    public ModelAndView user(){
        ModelAndView modelAndView=new ModelAndView("user");
        return modelAndView;
    }
}
