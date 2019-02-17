package com.ulife.masteronline.pojo;

public class Material {
    private int id;
    private String name;
    private String location;
    private int teacher_no;
    private int correspond_course;
    private String outline;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTeacher_no() {
        return teacher_no;
    }

    public void setTeacher_no(int teacher_no) {
        this.teacher_no = teacher_no;
    }

    public int getCorrespond_course() {
        return correspond_course;
    }

    public void setCorrespond_course(int correspond_course) {
        this.correspond_course = correspond_course;
    }

    public String getOutline() {
        return outline;
    }

    public void setOutline(String outline) {
        this.outline = outline;
    }
}
