package com.tx.springbootinterceptor.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


public class LoginInterceptor implements HandlerInterceptor {

    //用于存储排除拦截的url  （登录/login.html, /css,/js,/img）
    private List<String> urls = new ArrayList<String>();

    /**
     * 进入控制器之前拦截
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            return true;
        }
        //未登录，拦截
        response.sendRedirect("/login");    //未登录，跳转到登录页
        return false;
    }


    public List<String> getUrls() {
        urls.add("/login");//登录页
        urls.add("/doLogin");//登录请求

        //静态资源
        urls.add("/img/*");
        urls.add("/js/*");
        urls.add("/css/*");
        return urls;
    }
}
