package com.javaweb.servlet;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class HttpServletDemo extends HttpServlet {

//    get请求会分配到doget方法，post请求分配到dopost请求
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("进入post方法");
        //固定步骤
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //3.执行业务逻辑(这里后期可以和数据库查询匹配)
        if("admin".equals(username) && "123456".equals(password)){
            //4.页面跳转
            response.sendRedirect("success.jsp");
        }else {
            //application作用域
//            ServletContext servletContext = request.getServletContext();
            HttpSession session = request.getSession();
            session.setAttribute("msg","登录失败！");
            response.sendRedirect("index.jsp");
        }
    }
    @Override
    protected  void  doGet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("进入get方法");
    }
}
