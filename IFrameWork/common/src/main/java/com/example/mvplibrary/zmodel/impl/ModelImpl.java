package com.example.mvplibrary.zmodel.impl;

import com.example.mvplibrary.Callback;
import com.example.mvplibrary.zmodel.base.BaseModel;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import retrofit2.Call;

/**
 * @author mayong
 * @function ModelImpl  mvp中的model 需要继承这个model
 * @time 2016/10/10 13:57
 **/
public class ModelImpl implements BaseModel {
    private Callback callback;
    private Callback callback1;
    private Callback callback2;
    private Callback callback3;
    private ConcurrentHashMap<Integer, Call<?>> callMap = new ConcurrentHashMap<>();

    public void setOnCallBackListener(Callback callback) {
        this.callback = callback;

    }

    public Callback getCallBackListener() {
        if (callback != null) {
            return callback;
        } else {
            throw new IllegalArgumentException("未设置监听");
        }
    }

    public void setOnCallBackListener1(Callback callback) {
        this.callback1 = callback;

    }

    public Callback getCallBackListener1() {
        if (callback1 != null) {
            return callback1;
        } else {
            throw new IllegalArgumentException("未设置监听");
        }
    }

    public void setOnCallBackListener2(Callback callback) {
        this.callback2 = callback;

    }

    public Callback getCallBackListener2() {
        if (callback2 != null) {
            return callback2;
        } else {
            throw new IllegalArgumentException("未设置监听");
        }
    }

    public void setOnCallBackListener3(Callback callback) {
        this.callback3 = callback;

    }

    public Callback getCallBackListener3() {
        if (callback3 != null) {
            return callback3;
        } else {
            throw new IllegalArgumentException("未设置监听");
        }
    }

    @Override
    public void addCall(Call call) {
        callMap.put(call.hashCode(), call);
    }

    @Override
    public void removeCall(Call call) {
        if (call != null) {
            callMap.remove(call.hashCode());
        }
    }

    @Override
    public void cancelCall(Call call) {
        if (!call.isCanceled()) {
            call.cancel();
        }
    }

    @Override
    public void clear() {
        for (Map.Entry entry : callMap.entrySet()) {
            Call call = (Call) entry.getValue();
            if (!call.isCanceled()) {
                call.cancel();
            }
        }
    }
}