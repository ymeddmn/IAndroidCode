package com.example.demo.idemo.base;

/**
 * Created by mage on 2017/5/25.
 */

public class InfoBean {
    private String activityName;
    private Class clz;

    public InfoBean() {
    }

    public InfoBean(String activityName, Class clz) {
        this.activityName = activityName;
        this.clz = clz;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Class getClz() {
        return clz;
    }

    public void setClz(Class clz) {
        this.clz = clz;
    }
}
