package com.ulife.masteronline.service;

import com.ulife.masteronline.pojo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public interface StudentService {
    public void modifySelfInfo(Student student,HttpServletRequest request);
    public Task getTask(int id);
    public void submitTask(Submit submit,HttpServletRequest request);
    public ArrayList<Course> getCourses(int id);
    public ArrayList<Material>getMaterialsByCid(int cid);
}
