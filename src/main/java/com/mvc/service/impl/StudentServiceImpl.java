package com.mvc.service.impl;

import com.mvc.dao.StudentDao;
import com.mvc.dao.impl.StudentDaoImpl;
import com.mvc.entity.Student;
import com.mvc.service.StudentService;
import com.mvc.utils.PageModel;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {

    private static final StudentDao studentDao  = new StudentDaoImpl();
    @Override
    public boolean addStudent(Student student) throws SQLException, ClassNotFoundException {
        return  studentDao.addStudent(student);
    }

    @Override
    public List<Student> findAllStudent() {
        return studentDao.findAllStudent();
    }

    @Override
    public boolean deleteStudentById(int sid) {
        return studentDao.deleteStudentById(sid);
    }

    @Override
    public Student findStudentById(int sid) {
        return studentDao.findStudentById(sid);
    }

    @Override
    public boolean updateStudentById(Student student) {
        return studentDao.updateStudentById(student);
    }

    //分页查询
    @Override
    public PageModel<Student> findPageStudent(int pageNum, int pageSize) {

        PageModel<Student> model = new PageModel<>();
        //查询本页数据
        List<Student> list = studentDao.findPageModel((pageNum-1)*pageSize,pageSize);
        //填充页面数据
        model.setPageNum(pageNum);//起点
        model.setPageSize(pageSize);//单页面最大记录数
        model.setData(list);//页面数据
        model.setTotal(studentDao.findStudentTotal());//总记录数
        return model;
    }
}
