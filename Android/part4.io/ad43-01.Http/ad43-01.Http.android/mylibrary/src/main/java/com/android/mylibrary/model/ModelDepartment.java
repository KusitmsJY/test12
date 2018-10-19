package com.android.mylibrary.model;

import java.lang.reflect.Type;
import java.util.List;


import com.google.gson.InstanceCreator;

public class ModelDepartment {

    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    @Override
    public String toString() {
        return "ModelDepartment [deptName=" + deptName + "]";
    }

    public ModelDepartment(String deptName) {
        this.deptName = deptName;
    }
}
