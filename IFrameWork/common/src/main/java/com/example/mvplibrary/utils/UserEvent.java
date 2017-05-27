package com.example.mvplibrary.utils;

import android.os.Bundle;

/**
 * 作者:  lll
 * 日期： 2016/11/29
 * 配合 RxBus 使用
 */
public class UserEvent {

    /**
     * 训练完成
     */
    public static final int EVENT_COMPLETE_TRAINING = 0;
    /**
     * 生成方案
     */
    public static final int EVENT_GENERATE_SOLUTIONS = 1;


    /**
     * 事件类型
     */
    public int eventType;

    /**
     * 消息
     */
    public String msg;

    /**
     * obj
     */
    public Object obj;

    /**
     * 数据集
     */
    public Bundle data;

    public UserEvent(int eventType, String msg, Object obj, Bundle data) {
        this.eventType = eventType;
        this.msg = msg;
        this.obj = obj;
        this.data = data;
    }


    public UserEvent(int eventType, String msg, Object obj) {
        this.eventType = eventType;
        this.msg = msg;
        this.obj = obj;
    }

    public UserEvent(int eventType, String msg) {
        this.eventType = eventType;
        this.msg = msg;
    }

    public UserEvent(int eventType) {
        this.eventType = eventType;
    }
}
