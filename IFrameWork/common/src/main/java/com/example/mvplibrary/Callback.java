package com.example.mvplibrary;

/**
 * @author mayong
 * @function Callback 回调接口，用于model和presenter之间进行通信
 * @time 2016/10/10 13:52
 **/
public interface Callback<T> {
    void call(T t, Object... s);

    /**
     * 网络请求失败
     *
     * @param msg
     */
    void error(String msg);
}
