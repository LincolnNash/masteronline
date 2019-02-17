package com.ulife.masteronline.mapper;

import com.ulife.masteronline.pojo.Submit;

import java.util.ArrayList;

public interface SubmitMapper {
    public ArrayList<Submit> getSubmits(int task_id);
    public void addSubmit(Submit submit);
}
