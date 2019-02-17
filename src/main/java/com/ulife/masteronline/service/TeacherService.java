package com.ulife.masteronline.service;

import com.ulife.masteronline.pojo.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public interface TeacherService {
    public void modifySelfInfo(Teacher teacher, HttpServletRequest request);
    public void selectCourse(int cid,HttpServletRequest request);
    public ArrayList<Course> getMyCourses(HttpServletRequest request);
    public void deleteMyCourse(int cid,HttpServletRequest request);

    public void addMaterial(Material material,HttpServletRequest request);
    public ArrayList<Material> getMaterials(int id);
    public void deleteMaterial(int id);

    public void addTask(HttpServletRequest request,Task task,PublishedTask publishedTask);
    public ArrayList<Task> getTasks(int tid);
    public ArrayList<Submit> getSubmit(int task_id);
}
