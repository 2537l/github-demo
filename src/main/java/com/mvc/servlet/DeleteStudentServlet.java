package com.mvc.servlet;

import com.mvc.service.StudentService;
import com.mvc.service.impl.StudentServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class DeleteStudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String sidStr = request.getParameter("sid");
        int sid = Integer.parseInt(sidStr);
        //3.执行业务逻辑
        //删除指定学生
        StudentService studentService = new StudentServiceImpl();
        boolean b =  studentService.deleteStudentById(sid);
        if(b){
            response.sendRedirect("deleteSuccess.jsp");
        }else {
            response.sendRedirect("error.jsp");
        }
    }
}
