package com.ulife.masteronline.mapper;

import com.ulife.masteronline.pojo.Teacher;

public interface TeacherMapper {
	public Teacher login(Teacher teacher);
	public void modifySelfInfo(Teacher teacher);
}
