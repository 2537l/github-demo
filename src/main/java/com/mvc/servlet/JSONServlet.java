package com.mvc.servlet;

import com.google.gson.Gson;
import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import com.mvc.service.impl.StudentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class JSONServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doPost(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //2.获取请求参数（此处无参数）
        //3.执行业务逻辑
        Gson gson = new Gson();
        StudentService studentService = new StudentServiceImpl();
        List<Student> students = studentService.findAllStudent();
        String stu_JSON = gson.toJson(students);//对象转成的json字符串
        response.getWriter().print(stu_JSON);
    }
}
