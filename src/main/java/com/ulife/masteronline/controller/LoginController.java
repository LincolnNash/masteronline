package com.ulife.masteronline.controller;

import com.ulife.masteronline.pojo.Student;
import com.ulife.masteronline.pojo.Teacher;
import com.ulife.masteronline.service.impl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/*
 *学生/教师登陆
 */
@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    LoginServiceImpl loginService;


    @RequestMapping("student")
    public ModelAndView studentLogin(Student student, HttpServletRequest request){
        ModelAndView mavSuccess = new ModelAndView("index.jsp");
        ModelAndView mavFail = new ModelAndView("loginerror.jsp");
        int state = loginService.login(student,request);
        if(state == 1){
            mavSuccess.addObject("message","登陆成功");
            return mavSuccess;
        }else{
            mavFail.addObject("message","登陆失败");
            return mavFail;
        }


    }

    @RequestMapping("teacher")
    public ModelAndView teacherLogin(Teacher teacher,HttpServletRequest request){
        ModelAndView mavSuccess = new ModelAndView("index.jsp");
        ModelAndView mavFail = new ModelAndView("loginerror.jsp");
        int state = loginService.login(teacher,request);
        if(state == 1){
            mavSuccess.addObject("message","登陆成功");
            return mavSuccess;
        }else{
            mavFail.addObject("message","登陆失败");
            return mavFail;
        }

    }
}
