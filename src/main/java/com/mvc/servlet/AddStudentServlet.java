package com.mvc.servlet;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import com.mvc.service.impl.StudentServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public class AddStudentServlet extends HttpServlet {

    private static final StudentService studentService = new StudentServiceImpl();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String sname = request.getParameter("name");
        String sex = request.getParameter("sex");
        String phone = request.getParameter("phone");
        Student student = new Student(sname,sex,phone);
        //3.执行业务逻辑
        try {
            boolean b = studentService.addStudent(student);
            if(b){
                response.sendRedirect("addSuccess.jsp");
            }else {
                response.sendRedirect("error.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
