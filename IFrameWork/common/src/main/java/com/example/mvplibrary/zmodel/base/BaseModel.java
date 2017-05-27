package com.example.mvplibrary.zmodel.base;

import retrofit2.Call;

/**
 * @author mayong
 * @function BaseModel
 * @time 2016/9/28 11:49
 **/
public interface BaseModel {
    public void addCall(Call call);

    public void removeCall(Call call);

    public void cancelCall(Call call);

    public void clear();

}
