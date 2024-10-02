package com.mvc.dao.impl;

import com.mvc.dao.StudentDao;
import com.mvc.entity.Student;
import com.mvc.utils.PageModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/javawebDemo?useUnicode=true&characterEncoding=utf8&useSSL=true";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "lxb032412";

    @Override
    public boolean addStudent(Student student) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName(DRIVER);
        //2.建立连接
        Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        //3.执行sql语句
        String sql = "insert student(sname,sex,phone) values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1,student.getSname());
        ps.setString(2,student.getSex());
        ps.setString(3,student.getPhone());
        int i = ps.executeUpdate();
        //4.关闭连接
        ps.close();
        con.close();
        //5.处理执行结果
        if(i == 1){
            return true;
        }
        return false;
    }

    @Override
    public List<Student> findAllStudent() {
        List<Student> students = new ArrayList<>();
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.获取连接
            Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //3.执行sql语句
            String sql = "select * from student";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            //4.处理查询结果
            while (rs.next()){
                Student stu = new Student();
                stu.setSid(rs.getInt("sid"));
                stu.setSname(rs.getString("sname"));
                stu.setSex(rs.getString("sex"));
                stu.setPhone(rs.getString("phone"));
                students.add(stu);
            }
            //5.关闭连接
            rs.close();
            preparedStatement.close();
            con.close();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public boolean deleteStudentById(int sid) {
        int i = 0;
       try {
           //1.加载驱动
           Class.forName(DRIVER);
           //2.获取连接
           Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
           //3.执行sql语句
           String sql = "delete from student where sid = ?";
           PreparedStatement ps = con.prepareStatement(sql);
           ps.setInt(1,sid);
           i = ps.executeUpdate();
           //4.关闭连接
           ps.close();
           con.close();
       } catch (ClassNotFoundException e) {
           e.printStackTrace();
       } catch (SQLException e) {
           e.printStackTrace();
       }
       //5.处理结果
        if(i == 1){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Student findStudentById(int sid) {
        Student student = new Student();
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.获取连接
            Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //3.执行sql语句
            String sql = "select * from student where sid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,sid);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                student.setSid(rs.getInt("sid"));
                student.setSname(rs.getString("sname"));
                student.setSex(rs.getString("sex"));
                student.setPhone(rs.getString("phone"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    @Override
    public boolean updateStudentById(Student student) {
        int i = 0;
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.获取连接
            Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //3.执行sql语句
            String sql = "update student set sname = ?, sex = ?, phone = ? where sid = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,student.getSname());
            ps.setString(2,student.getSex());
            ps.setString(3,student.getPhone());
            ps.setInt(4,student.getSid());
            i = ps.executeUpdate();
            //4.关闭连接
            ps.close();
            con.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //5.处理结果
        if(i == 1){
            return true;
        }
        return false;
    }

    @Override
    public int findStudentTotal() {
        int total = 0;
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.获取连接
            Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //3.执行sql语句
            String sql = "select count(1) totalCount from student";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                total = rs.getInt("totalCount");
            }
            //4.关闭连接
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return total;
    }

    @Override
    public List<Student> findPageModel(int pageNum, int pageSize) {
        List<Student> list = new ArrayList<Student>();
        try {
            //1.加载驱动
            Class.forName(DRIVER);
            //2.获取连接
            Connection con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            //3.执行sql
            String sql = "select * from student limit ?,?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,pageNum);
            ps.setInt(2,pageSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Student stu = new Student();
                stu.setSid(rs.getInt("sid"));
                stu.setSname(rs.getString("sname"));
                stu.setSex(rs.getString("sex"));
                stu.setPhone(rs.getString("phone"));
                list.add(stu);
            }
            //4.关闭连接
            rs.close();
            ps.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //结果处理
        return list;
    }
}
