package com.ulife.masteronline.controller;

import com.ulife.masteronline.pojo.Materail;
import com.ulife.masteronline.pojo.PublishedTask;
import com.ulife.masteronline.pojo.Task;
import com.ulife.masteronline.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView selectCourse(int courseCode){
        return new ModelAndView();
    }

    /*
    * 功能：查询授课
    * 输入：教师工号
    * 输出：List<course>
     */
    @RequestMapping("getMyCourses")
    public ModelAndView getMyCourses(){
        return new ModelAndView();
    }

    /*
    * 功能：删除授课
    * 输入：教师id+课程id
    * 返回：操作结果
     */
    @RequestMapping("deleteMycourses")
    public ModelAndView deleteMycourses(){
        return new ModelAndView();
    }

    /*
    * 功能：添加资料
    * 输入：资料信息
    * 操作：插入资料表
    * 返回：插入成功/失败
     */
    @RequestMapping("addMaterial")
    public ModelAndView addMaterail(Materail materail){
        return new ModelAndView();
    }

    /*
    * 功能：获取上传资料
    * 输入：教师jobno
    * 输出：List<Materail>
     */
    @RequestMapping("getMaterials")
    public ModelAndView getMaterial(int jobno){
        return new ModelAndView();
    }

    /*
    * 功能：删除资料
    * 输入：资料id
    * 输出：删除成功/失败
     */
    @RequestMapping("deleteMaterail")
    public ModelAndView getMaterail(int mid){
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
