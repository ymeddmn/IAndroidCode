package com.example.mvplibrary.activity.base;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.common.R;
import com.example.mvplibrary.utils.ScreenUtils;
import com.example.mvplibrary.utils.SuperToast;
import com.example.mvplibrary.zview.base.BaseView;

public abstract class BaseActivity extends AppCompatActivity implements BaseView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        super.onAttachFragment(fragment);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }


    /**
     * 显示消息
     *
     * @param message 消息
     */
    @Override
    public void showMessage(@NonNull String message) {
        show(message, 42);
    }
    /**
     * 显示消息
     *
     * @param message 消息
     */
    @Override
    public void showMessage(int message) {
        showMessage(getString(message));
    }

    @Override
    public void showMessageOnTop(String message) {
        show(message, 0);
    }

    private void show(String message, int position) {
        SuperToast toast = new SuperToast(this);
        toast.setGravity(Gravity.TOP, 0, ScreenUtils.dip2px(this.getResources(), position));
        View view = LayoutInflater.from(this).inflate(R.layout.toast_view, null, false);
        ((TextView) view.findViewById(R.id.text)).setText(message);
        toast.setView(view);
        toast.setDuration(SuperToast.LENGTH_SHORT);
        toast.show();
    }

    /**
     * 加载数据的时候显示
     */
    @Override
    public void showDialog(String msg) {

    }

    /**
     * 取消dialog
     */
    @Override
    public void hideDialog() {

    }

    @Override
    public boolean isActive(@NonNull final Activity activity) {
        ActivityManager am = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        Log.d("PackageName      %s", cn.getPackageName());
        Log.d("ClassName        %s", cn.getClassName());
        return activity.getComponentName().getClassName().equals(cn.getClassName());

    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
