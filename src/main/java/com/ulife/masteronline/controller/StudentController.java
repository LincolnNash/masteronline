package com.ulife.masteronline.controller;

import com.ulife.masteronline.pojo.Student;
import com.ulife.masteronline.pojo.Task;
import com.ulife.masteronline.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("student")
public class StudentController {
    @Autowired
    StudentService studentService;
    /*
    *修改学生个人信息
     */
    @RequestMapping("modifySelfInfo")
    public ModelAndView modifySelfInfo(Student student, HttpServletRequest request){
        ModelAndView mav = new ModelAndView("");
        studentService.modifySelfInfo(student,request);
        return mav;
    }
    /*
     * 功能：查询作业
     *
     */
    @RequestMapping("getTask")
    public ModelAndView modifySelfInfo(int id){
        ModelAndView mav = new ModelAndView("");
        Task task = studentService.getTask(id);
        mav.addObject("task",task);
        return mav;
    }

//    @RequestMapping("getCourse")
//    public ModelAndView getCourse

    /*
     * 功能：提交作业（注意处理重复提交的作业和同名作业）
     *
     */


}
