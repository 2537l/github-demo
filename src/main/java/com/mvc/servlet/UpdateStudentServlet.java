package com.mvc.servlet;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import com.mvc.service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateStudentServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        String sname = request.getParameter("name");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        Student student = new Student(sname,sex,phone);
        student.setSid(sid);
        //3.执行业务操作：根据传入数据修改学生信息
        StudentService studentService = new StudentServiceImpl();
        boolean b  = studentService.updateStudentById(student);
        if(b){
            response.sendRedirect("updateSuccess.jsp");
        }else {
            response.sendRedirect("error.jsp");
        }
    }
}
