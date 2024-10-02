package com.javaweb.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.Servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.UUID;

public class FIleUpLoadServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //文件上传操作
        //1.创建DiskFileItemFactory工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //2.创建文件上传的解析器
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        //**设置文件上传大小限制
        fileUpload.setFileSizeMax(1024*1024);//设置允许上传的最大值
        fileUpload.setSizeMax(1024*1024);//设置整个表单允许的最大值
        try {
            //3.获取请求数据（所有的请求数据都会被封装到这个FIleItem对象中)
            List<FileItem> fileItemList = fileUpload.parseRequest(request);
            String name = fileItemList.get(0).getString();//根据下标取出文本框中输入的值
            for (FileItem fileItem : fileItemList) {
                if(!fileItem.isFormField()){//true为表单，false为文件
                    //当上传的是文件时
                    String fileName = fileItem.getName();//获取文件名
                    System.out.println(fileName);
                    //文件重命名处理
                    fileName = UUID.randomUUID()+"_"+fileName;
                    InputStream in = fileItem.getInputStream();//获取上传文件的输入流
                    //4.指定保存文件的路径
                    File path = new File("E:/upload");
                    /*
                    *getServletContext() 方法返回与当前Servlet关联的ServletContext对象，
                    * 它提供了对Web应用程序环境的访问。
                    * getRealPath(String path) 方法用于将一个虚拟路径转换为实际路径。
                    *在Web应用中，如果需要处理用户上传的文件，
                    * 通常会将文件存储在/WEB-INF/upload目录中，确保文件不被直接访问。
                    * 使用getRealPath方法可以方便地获得该目录的实际存储位置，
                    * 以便进行文件的保存、读取或删除等操作。
                    * */
                    if(!path.exists()){
                        //如果目录路径不存在，则创建
                        path.mkdir();
                    }
                    //5.读写文件
                    FileOutputStream out = new FileOutputStream(new File(path,fileName));
                    byte[] b = new byte[1024];
                    int length = 0;
                    while ((length=in.read(b))>=0){
                        out.write(b,0,length);
                    }
                    //6.关闭流
                    out.close();
                    in.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
