package com.ulife.masteronline.service.impl;

import com.ulife.masteronline.mapper.StudentMapper;
import com.ulife.masteronline.mapper.TeacherMapper;
import com.ulife.masteronline.pojo.Student;
import com.ulife.masteronline.pojo.Teacher;
import com.ulife.masteronline.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    TeacherMapper teacherMapper;
    /*
    * 学生登陆将学生登陆信息存入session
     */
    public int login(Student student, HttpServletRequest request){
        Student student1= studentMapper.login(student);
        if(student1 == null)
            return 0;
        else{
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*30);
            session.setAttribute("student",student1);
            return 1;
        }

    }

    /*
    * 教师登陆将教师登陆信息存入session
     */
    public int login(Teacher teacher,HttpServletRequest request){
        Teacher teacher1= teacherMapper.login(teacher);
        if(teacher1 == null)
            return 0;
        else{
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(60*30);
            session.setAttribute("teacher",teacher1);
            return 1;
        }

    }
}
