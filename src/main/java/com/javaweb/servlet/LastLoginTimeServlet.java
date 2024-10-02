package com.javaweb.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class LastLoginTimeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String time;
        Cookie [] cookies = request.getCookies();
        int i =0;
        if(cookies != null && cookies.length >0){
            for (Cookie cookie : cookies) {
                if("time".equals(cookie.getName())){
                    response.getWriter().println("上一次访问时间是："+cookie.getValue());
                    //更新登录时间
                    time = format.format(date);
                    Cookie cookie1 = new Cookie("time",time);
                    response.addCookie(cookie1);
                    break;
                }
                i++;
            }
            //未找到登录记录
            if(i == cookies.length){
                //设置登录时间
                time = format.format(date);
                Cookie cookie1 = new Cookie("time",time);
                response.addCookie(cookie1);
                response.getWriter().println("首次登录");
            }
        }
    }
}
