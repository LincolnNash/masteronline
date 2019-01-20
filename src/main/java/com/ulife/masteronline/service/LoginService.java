package com.ulife.masteronline.service;

import com.ulife.masteronline.pojo.Student;
import com.ulife.masteronline.pojo.Teacher;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    public int login(Student student, HttpServletRequest request);
    public int login(Teacher teacher,HttpServletRequest request);
}
