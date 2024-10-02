package com.javaweb.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImgServletDemo extends HttpServletDemo{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        File dir = new File("E:\\javaTextFile\\1.jpg");
        FileInputStream in = new FileInputStream(dir);
        byte[] b = new byte[1024*1024];
        int length = 0;
        ServletOutputStream servletOutputStream = response.getOutputStream();
        while ((length = in.read(b))!=-1){
            servletOutputStream.write(b,0,length);
        }
        servletOutputStream.close();
        in.close();

    }
}
