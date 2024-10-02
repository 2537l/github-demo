package com.mvc.servlet;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import com.mvc.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class FindStudentByIdServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String sidStr = request.getParameter("sid");
        int sid = Integer.parseInt(sidStr);
        //3.执行业务逻辑:根据传入的sid属性返回给修改页面Student对象
        StudentService studentService = new StudentServiceImpl();
        Student student = studentService.findStudentById(sid);
        request.setAttribute("studentinfo",student);
        //4.请求转发
        request.getRequestDispatcher("update.jsp").forward(request,response);
    }

}
