package com.mvc.dao;

import com.mvc.entity.Student;
import com.mvc.utils.PageModel;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //添加学生
    public boolean addStudent(Student student) throws ClassNotFoundException, SQLException;
    //查询全部学生信息
    public List<Student> findAllStudent();
    //根据id删除学生信息
    public boolean deleteStudentById(int sid);
    //根据id查找学生信息
    public Student findStudentById(int sid);
    //修改学生信息
    public boolean updateStudentById(Student student);
    //查询学生信息总记录数
    public int findStudentTotal();
    //分页查询
    public List<Student> findPageModel(int pageNum, int pageSize);
}
