package com.ulife.masteronline.mapper;

import com.ulife.masteronline.pojo.Student;
import com.ulife.masteronline.pojo.Teacher;


public interface StudentMapper {
	public Student login(Student student);
	public void modifySelfInfo(Student student);
}
