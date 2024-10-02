package com.mvc.service;

import com.mvc.entity.Student;
import com.mvc.utils.PageModel;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {

   public boolean addStudent(Student student) throws SQLException, ClassNotFoundException;
    public List<Student> findAllStudent();
    public boolean deleteStudentById(int sid);
    public Student findStudentById(int sid);
    public boolean updateStudentById(Student student);
    //分页查询
    public PageModel<Student> findPageStudent(int pageNum, int pageSize);

}
