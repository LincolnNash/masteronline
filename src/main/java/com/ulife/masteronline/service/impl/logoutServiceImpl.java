package com.ulife.masteronline.service.impl;

import com.ulife.masteronline.service.LogoutService;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Service
public class logoutServiceImpl implements LogoutService {
    public void logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("student");
        session.removeAttribute("teacher");
    }
}
