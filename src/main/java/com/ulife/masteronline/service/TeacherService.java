package com.ulife.masteronline.service;

import com.ulife.masteronline.pojo.Materail;
import com.ulife.masteronline.pojo.Teacher;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface TeacherService {
    public void modifySelfInfo(Teacher teacher, HttpServletRequest request);
    public List<Materail> getMaterailsByJobno(int jobno);
}
