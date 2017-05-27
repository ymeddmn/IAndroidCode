package com.example.mvplibrary.zview.base;

import android.app.Activity;
import android.support.annotation.StringRes;

/**
 * @author mayong
 * @function BaseView
 * @time 2016/9/28 11:49
 **/
public interface BaseView {

    /**
     * 显示消息
     *
     * @param message 消息
     */
    void showMessage(String message);

    /**
     * 显示消息
     *
     * @param messageResId 消息资源ID
     */
    void showMessage(@StringRes int messageResId);

    /**
     * 在通知栏正下方显示消息
     *
     * @param message
     */
    void showMessageOnTop(String message);

    /**
     * 加载数据的时候显示
     *
     * @param msg
     */
    void showDialog(String msg);

    /**
     * 取消dialog
     */
    void hideDialog();

    boolean isActive(Activity activity);

    Activity getActivity();
}
