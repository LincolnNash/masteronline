package com.ulife.masteronline.mapper;

import com.ulife.masteronline.pojo.Course;
import com.ulife.masteronline.pojo.Teacher;

import java.util.ArrayList;

public interface TeacherMapper {
	public Teacher login(Teacher teacher);
	public void modifySelfInfo(Teacher teacher);
	public void selectCourse(int cid,int tid);
	public ArrayList<Course> getMyCourses(int tid);
	public void deleteMyCourse(int cid,int tid);
}
