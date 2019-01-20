package com.ulife.masteronline.service.impl;

import com.ulife.masteronline.mapper.TeacherMapper;
import com.ulife.masteronline.pojo.Materail;
import com.ulife.masteronline.pojo.Student;
import com.ulife.masteronline.pojo.Teacher;
import com.ulife.masteronline.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    /*
    * 修改教师个人信息
     */
    @Override
    public void modifySelfInfo(Teacher teacher, HttpServletRequest request) {
        //修改存储在session里的个人信息
        HttpSession session = request.getSession();
        session.setAttribute("teacher",teacher);
        //修改数据库内容
        teacherMapper.modifySelfInfo(teacher);
    }
    /*
    * 查询教师上传的资料
    * 输入：教师id
    * 输出：list<Material>
     */
    public List<Materail> getMaterailsByJobno(int jobno){
        return new ArrayList<>();
    }
}
