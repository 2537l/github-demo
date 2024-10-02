package com.javaweb.servlet;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileDownServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //2.向浏览器响应一个图片（因为图片是存在后端的，所以需要响应给浏览器以附件形式，这样别人才能下载）
        //读本地图片
        String filePathStr = "E://upload//down.jpeg";
        //设置附件格式
        String ContentType = this.getServletContext().getMimeType(filePathStr);//获取文件格式
        //设置ContentDisposition
        String ContentDisposition = "attachment;filename=down.jpeg";
        //设置两个响应头
        response.setHeader("Content-Type",ContentType);//指定文件类型
        response.setHeader("Content-Disposition",ContentDisposition);//指定响应回去的文件打开方式
        FileInputStream in = new FileInputStream(filePathStr);
        byte[] b = new byte[1024];
        int length = 0;
        //向浏览器响应图片，获取浏览器中的输出流
        ServletOutputStream out = response.getOutputStream();
        while ((length = in.read(b))!=-1){
            //写入
            out.write(b,0,length);
        }
        //关闭流
        out.close();
        in.close();
    }
}
