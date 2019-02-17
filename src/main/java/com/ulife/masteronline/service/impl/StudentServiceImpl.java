package com.ulife.masteronline.service.impl;

import com.ulife.masteronline.mapper.*;
import com.ulife.masteronline.pojo.*;
import com.ulife.masteronline.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.ArrayList;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    StudentMapper studentMapper;

    @Autowired
    SubmitMapper submitMapper;

    @Autowired
    TaskMapper taskMapper;

    @Autowired
    CourseMapper courseMapper;

    @Autowired
    MaterialMapper materialMapper;
    /*
    *修改学生个人信息
     */
    @Override
    public void modifySelfInfo(Student student,HttpServletRequest request) {
        //修改存储在session里的个人信息
        HttpSession session = request.getSession();
        session.setAttribute("student",student);
        //修改数据库内容
        studentMapper.modifySelfInfo(student);
    }

    /*
    *查询教师布置的作业
    * 输入：作业号
     */
    public Task getTask(int id){
        return taskMapper.getTask(id);
    }

    /*
    * 提交完成的作业
     */
    public void submitTask(Submit submit, HttpServletRequest request){
        /*
         * 新建唯一文件存储路径
         * 更新submit属性 location
         * 将文件存储到磁盘
         * insert into task and publishedTask
         */
        //新建唯一文件存储路径
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("student");
        String dir = "/resources/submit/"+student.getSchool_no();
        String savePath = request.getSession().getServletContext().getRealPath(dir)+submit.getName();
        //将文件存储到磁盘
        MultipartHttpServletRequest mRequest = (MultipartHttpServletRequest)request;
        MultipartFile file = mRequest.getFile("submitfile");
        File fileSavePath = new File(savePath);
        try {
            file.transferTo(fileSavePath);
        }catch (IOException e){
            e.printStackTrace();
        }
        submit.setLocation(savePath);
        submitMapper.addSubmit(submit);
    }
    /*
    * 查询课程
    * 输入：课程id
     */
    public ArrayList<Course>getCourses(int id){
        return courseMapper.getCourses(id);
    }

    /*
    * 查询资料
    * 输入：课程id
     */
    public ArrayList<Material>getMaterialsByCid(int cid){
        return materialMapper.getMaterialsByCid(cid);
    }

    /*
     * 下载资料
     * path为下载文件的路径
     */
    public void downloadSubmit(HttpServletResponse response, Material material)throws IOException{
        //获取输入流
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(material.getLocation())));
        //转码，免得文件名中文乱码
        String filename = material.getName();
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
