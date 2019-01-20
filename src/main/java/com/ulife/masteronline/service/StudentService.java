package com.ulife.masteronline.service;

import com.ulife.masteronline.pojo.Student;

import javax.servlet.http.HttpServletRequest;

public interface StudentService {
    public void modifySelfInfo(Student student,HttpServletRequest request);
}
