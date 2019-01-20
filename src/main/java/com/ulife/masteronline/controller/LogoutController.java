package com.ulife.masteronline.controller;

import com.ulife.masteronline.service.LogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

/*
 *学生/教师注销
 */
@Controller
@RequestMapping("logout")
public class LogoutController {
    @Autowired
    LogoutService logoutService;

    @RequestMapping("do")
    public ModelAndView logout(HttpServletRequest request){
        logoutService.logout(request);
        ModelAndView mav = new ModelAndView("index.jsp");
        return mav;
    }
}
