package com.example.mvplibrary.zpresenter.base;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;

/**
 * @author mayong
 * @function BaseActivityPresenter
 * @time 2016/9/28 11:49
 **/
public interface BaseActivityPresenter extends Presenter {

    void onCreate(Bundle savedInstanceState);

    public void onConfigurationChanged(Configuration newConfig);

    public void onStop();

    public void onDestroy();

    public void onSaveInstanceState(Bundle outState);

    public void onActivityResult(int requestCode, int resultCode, Intent data);

    /**
     * @return 返回true 表示拦截返回键点击事件
     */
    public boolean onBackPressed();

    public boolean onKeyDown(int keyCode, KeyEvent event);

    public void onPause();

    public void onResume();

    public void onStart();

    public void onRestart();

    public void onAttachFragment(Fragment fragment);

    public boolean onTouchEvent(MotionEvent event);
}
