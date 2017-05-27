package com.example.mvplibrary.zpresenter.base;

/**
 * @author mayong
 * @function Presenter
 * @time 2016/9/28 11:49
 **/
public interface Presenter {
    void attachView();

    void deattachView();

    // TODO: 2016/10/28 似乎用处不大 之后考虑是否去掉
    void showErrorMsg(String msg);
}
