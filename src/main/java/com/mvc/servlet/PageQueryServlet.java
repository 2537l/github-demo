package com.mvc.servlet;

import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import com.mvc.service.impl.StudentServiceImpl;
import com.mvc.utils.PageModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class PageQueryServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //1.设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //2.获取请求参数
        String pageNumStr = request.getParameter("pageNum");
        String pageSizeStr = request.getParameter("pageSize");
        if(pageNumStr == null || pageNumStr.equals("")){
            pageNumStr = "1";
        }
        if(pageSizeStr == null || pageSizeStr.equals("")){
            pageSizeStr = "5";
        }
        //3.执行业务逻辑
        StudentService studentService = new StudentServiceImpl();
        PageModel<Student> model = studentService.findPageStudent(Integer.parseInt(pageNumStr),Integer.parseInt(pageSizeStr));
        //4.传递参数
        request.setAttribute("model",model);
        //5.请求转发
        request.getRequestDispatcher("allStudent.jsp").forward(request,response);

    }
}
