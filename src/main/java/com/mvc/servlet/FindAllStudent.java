package com.mvc.servlet;

import com.mvc.dao.StudentDao;
import com.mvc.dao.impl.StudentDaoImpl;
import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import com.mvc.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class FindAllStudent extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //2.获取请求参数（此处无需参数）
        //3.处理业务逻辑
        StudentService studentService = new StudentServiceImpl();
        List<Student> students = studentService.findAllStudent();
        //后端向前端反应数据
        //1.派发页面（单纯跳转页面/跳转页面的时候也携带数据）
        //携带数据的方法（1.四大作用域，2.JSON，3.XML（基本没人用））
        request.setAttribute("list",students);
        //此时不能使用重定向，因为会跳转2次，请求域中的数据会丢失，要用请求转发
        request.getRequestDispatcher("allStudent.jsp").forward(request,response);
    }
}
