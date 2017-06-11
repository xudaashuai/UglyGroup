package com.uglygroup.interceptor;

import com.uglygroup.Utils.UserDataUtils;
import com.uglygroup.Utils.Utils;
import com.uglygroup.model.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.interceptor.Interceptor;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Objects;


/**
 * UglyGroup
 * Created by xudas on 2017/6/9.
 *
 */
@Interceptor
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        HttpSession session=httpServletRequest.getSession();

        User user= (User) session.getAttribute("user");
        if (user != null){
            return true;
        }else{
            Cookie[] cookies=httpServletRequest.getCookies();
            if (cookies!=null){
                for (Cookie cookie:cookies) {
                    if (cookie.getName().equals("login")){
                        String s[]=cookie.getValue().split(",");
                        User user1=new User();
                        if (s.length==2&& UserDataUtils.login(s[0],s[1],user1)== Utils.loginStatus.SUCCESS){
                            session.setAttribute("user",user1);
                            return true;
                        }
                    }
                }
            }
        }
        httpServletRequest.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(httpServletRequest,httpServletResponse);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
