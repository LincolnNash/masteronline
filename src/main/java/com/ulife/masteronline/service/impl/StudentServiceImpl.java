package com.ulife.masteronline.service.impl;

import com.ulife.masteronline.mapper.StudentMapper;
import com.ulife.masteronline.pojo.Student;
import com.ulife.masteronline.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper studentMapper;

    /*
    *修改学生个人信息
     */
    @Override
    public void modifySelfInfo(Student student,HttpServletRequest request) {
        //修改存储在session里的个人信息
        HttpSession session = request.getSession();
        session.setAttribute("student",student);
        //修改数据库内容
        studentMapper.modifySelfInfo(student);
    }
}
