package com.forum.framework.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 身份验证拦截器
 */
@Component
public class AuthVerifyInterceptor implements HandlerInterceptor {
    /**
     * controller 层接收到请求之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("拦截器校验");
        return true;
        // 判断sessionid是否正确
//        System.out.println(request.getContextPath());
//        boolean sessionVer = false;
//        Cookie[] cookies = request.getCookies();
//        // 判断是否存在cookie
//        if (cookies == null) return sessionVer;
//
//        for (int i = 0;i < cookies.length;i++) {
//            if (cookies[i].getName().equals("JSESSIONID")) {
//                // cookie中的sessionid和sessionid中的相等
//                if (cookies[i].getValue().equals(request.getSession().getId())) {
//                    sessionVer = true;
//                    break;
//                }
//            }
//        }
//        return sessionVer;
    }
}
