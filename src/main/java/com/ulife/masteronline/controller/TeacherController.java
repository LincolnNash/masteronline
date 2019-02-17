package com.ulife.masteronline.controller;

import com.ulife.masteronline.mapper.MaterialMapper;
import com.ulife.masteronline.pojo.*;
import com.ulife.masteronline.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    /*
    * 功能：选课
    * 输入：课程id
    * 操作：插入授课表
    * 返回：选课成功/失败
     */
    @RequestMapping("selectCourse")
    public ModelAndView selectCourse(int cid,HttpServletRequest request){
        teacherService.selectCourse(cid,request);
        ModelAndView mav = new ModelAndView("selectcourse.jsp");
        mav.addObject("message","选课成功");
        return mav;
    }

    /*
    * 功能：查询授课
    * 输入：教师工号
    * 输出：List<course>
     */
    @RequestMapping("getMyCourses")
    public ModelAndView getMyCourses(HttpServletRequest request){
        ModelAndView mav = new ModelAndView("courselist.jsp");
        mav.addObject("courseList",teacherService.getMyCourses(request));
        return mav;
    }

    /*
    * 功能：删除授课
    * 输入：教师id+课程id
    * 返回：操作结果
     */
    @RequestMapping("deleteMyCourse")
    public ModelAndView deleteMyCourse(int cid,HttpServletRequest request){
        teacherService.deleteMyCourse(cid,request);
        ModelAndView mav = new ModelAndView("");
        return mav;
    }

    /*
    * 功能：添加资料
    * 输入：资料信息
    * 操作：插入资料表/
    * 返回：插入成功/失败
     */
    @RequestMapping("addMaterial")
    public ModelAndView addMaterial(Material material,HttpServletRequest request){
        teacherService.addMaterial(material,request);
        return new ModelAndView();
    }

    /*
    * 功能：获取上传资料
    * 输入：教师jobno
    * 输出：List<Material>
     */
    @RequestMapping("getMaterials")
    public ModelAndView getMaterial(int tid){
        ArrayList<Material> materialList = teacherService.getMaterials(tid);
        ModelAndView mav = new ModelAndView();
        mav.addObject("material",materialList);
        return mav;
    }

    /*
    * 功能：删除资料
    * 输入：资料id
    * 输出：删除成功/失败
     */
    @RequestMapping("deleteMaterial")
    public ModelAndView deleteMaterial(int mid){
        teacherService.deleteMaterial(mid);
        return new ModelAndView();
    }

    /*
    * 功能：发布作业
    * 输入：作业信息
    * 流程；插入作业表、插入教师作业关系表
    * 输出：发布成功/失败
     */
    @RequestMapping("publishTask")
    public ModelAndView publishTask(Task task, PublishedTask publishedTask){

        return new ModelAndView();
    }

    /*
    * 功能：查询已发布作业
    * 输入：教师jobno
    * 输出：list<task>
     */
    @RequestMapping("getTasks")
    public ModelAndView getTasks(int jobno){
        return new ModelAndView();
    }

    /*
    * 功能：删除已发布作业
    * 输入：作业id
    * 输出：操作结果
     */
    @RequestMapping("deletePublishedTask")
    public ModelAndView deletePubedTask(int tid){
        return new ModelAndView();
    }

    /*
    * 功能：查询学生已经提交的作业
    * 输入：作业id
    * 输出：List<Submit>
     */
    @RequestMapping("getSubmits")
    public ModelAndView getSubmits(int tid){
        return new ModelAndView();
    }

    /*
    * 功能：下载作业
    * 输入：作业no+学生no
    * 输出：提交结果
     */
    @RequestMapping("downloadTask")
    public void downloadTask(int jobno,int school_no){

    }
}
