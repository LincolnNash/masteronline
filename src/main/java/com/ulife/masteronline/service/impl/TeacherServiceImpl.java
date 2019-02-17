package com.ulife.masteronline.service.impl;

import com.ulife.masteronline.mapper.*;
import com.ulife.masteronline.pojo.*;
import com.ulife.masteronline.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Autowired
    MaterialMapper materialMapper;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    PublishedTaskMapper publishedTaskMapper;

    @Autowired
    SubmitMapper submitMapper;

    /*
    * 修改教师个人信息（展示不提供）
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
     * 教师选课
     * 输入：课程编码
     * 输出：结果选课
     */

    @Override
    public void selectCourse(int cid,HttpServletRequest request) {
        //获取教师工号
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        int tid = teacher.getId();
        //插入选课标表
        teacherMapper.selectCourse(cid,tid);
    }

    /*
     * 查询选课
     */
    public ArrayList<Course> getMyCourses(HttpServletRequest request){
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return teacherMapper.getMyCourses(teacher.getId());
    }
    /*
     *删除教师选课
     */

    public void deleteMyCourse(int cid,HttpServletRequest request){
        HttpSession session = request.getSession();
        int tid = ((Teacher)session.getAttribute("teacher")).getId();
        teacherMapper.deleteMyCourse(cid,tid);
    }

    /*
    *上传资料
     */
    public void addMaterial(Material material,HttpServletRequest request){
        /*
         * 新建唯一文件存储路径
         * 更新material属性 location
         * 将文件存储到磁盘
         * insert into material
         */
        //新建唯一文件存储路径,更新material属性 location
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        String dir = "/resources/material/"+teacher.getJobno();
        String savePath = request.getSession().getServletContext().getRealPath(dir)+material.getName();

        //将文件存储到磁盘
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
        MultipartFile file = mRequest.getFile("material");
        File fileSavePath = new File(savePath);
        try {
            file.transferTo(fileSavePath);
        }catch (IOException e){
            e.printStackTrace();
        }

        //插入资料表
        material.setLocation(savePath);
        materialMapper.addMaterial(material);
    }

    /*
     * 查询教师上传的资料
     * 输入：教师id
     * 输出：list<Material>
     */
    public ArrayList<Material> getMaterials(int id){
        return materialMapper.getMaterials(id);
    }

    /*
    * 删除上传资料
    * 输入：material id
     */
    public void deleteMaterial(int id){
        Material material = materialMapper.getMaterial(id);
        String delPath = material.getLocation();
        File file = new File(delPath);
        file.delete();
        materialMapper.deleteMaterial(id);
    }

    /*
    * 发布作业
    * 输入：Task,PublishedTask
     */
    public void addTask(HttpServletRequest request, Task task, PublishedTask publishedTask){
        /*
         * 新建唯一文件存储路径
         * 更新task属性 location
         * 将文件存储到磁盘
         * insert into task and publishedTask
         */
        //新建唯一文件存储路径
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        String dir = "/resources/tasks/"+teacher.getJobno();
        String savePath = request.getSession().getServletContext().getRealPath(dir)+task.getName();
        //将文件存储到磁盘
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
        MultipartFile file = mRequest.getFile("taskfile");
        File fileSavePath = new File(savePath);
        try {
            file.transferTo(fileSavePath);
        }catch (IOException e){
            e.printStackTrace();
        }

        task.setLocation(savePath);
        taskMapper.addTask(task);
        publishedTask.setTask_id(task.getId());
        publishedTaskMapper.addPublishedTask(publishedTask);
    }

    /*
    *查询已经布置的作业
     */
    public ArrayList<Task> getTasks(int tid){
        return taskMapper.getTasks(tid);
    }

    /*
    * 删除已经发布的作业
     */
    public void deletePublihedTask(int task_id){
        publishedTaskMapper.deletePulishedTask(task_id);
        Task task = taskMapper.getTask(task_id);
        File file = new File(task.getLocation());
        file.delete();
        taskMapper.deleteTask(task_id);
    }

    /*
    * 查看提交的作业
     */
    public ArrayList<Submit> getSubmit(int task_id){
        return submitMapper.getSubmits(task_id);
    }

    /*
    * 下载提交的作业
    * path为下载文件的路径
     */
    public void downloadSubmit(HttpServletResponse response,Submit submit)throws IOException{
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(submit.getLocation())));
        //转码，免得文件名中文乱码
        String filename = submit.getName();
        filename = java.net.URLEncoder.encode(filename,"UTF-8");
        //设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
        int len = 0;
        while((len = bis.read()) != -1){
            out.write(len);
            out.flush();
        }
        out.close();

    }

}
