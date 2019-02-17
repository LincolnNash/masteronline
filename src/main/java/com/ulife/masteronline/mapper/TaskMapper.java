package com.ulife.masteronline.mapper;

import com.ulife.masteronline.pojo.Task;

import java.util.ArrayList;

public interface TaskMapper {
    public void addTask(Task task);
    public ArrayList<Task> getTasks(int tid);
    public void deleteTask(int task_id);
    public Task getTask(int id);
}
