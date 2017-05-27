package com.example.mvplibrary.zpresenter.impl;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;

import com.example.mvplibrary.utils.RxManager;
import com.example.mvplibrary.zmodel.base.BaseModel;
import com.example.mvplibrary.zpresenter.base.BaseActivityPresenter;
import com.example.mvplibrary.zview.base.BaseView;

import java.lang.ref.WeakReference;

import rx.Subscription;

/**
 * @author mayong
 * @function PresenterActivityImpl
 * @time 2016/9/28 16:54
 **/
public abstract class PresenterActivityImpl<M extends BaseModel, V extends BaseView> implements BaseActivityPresenter {


    //    private WeakReference<Context> weakContext;
    private WeakReference<V> weakView;
    private boolean canReach = true;
    protected RxManager mRxManager = new RxManager();
    private Context context;

    public PresenterActivityImpl(Context context, V view) {
//        this.weakContext = new WeakReference<Context>(context);
        this.weakView = new WeakReference<V>(view);
        this.context = context;
        model = createModel();

    }

    public abstract M createModel();

    private M model;

    public M getModel() {
        if (model == null) {
            throw new IllegalArgumentException("请实现createModel方法");
        }
        return model;
    }


    public V getView() {
        return weakView.get();
    }

    public void setView(V view) {
        this.weakView = new WeakReference<V>(view);
    }

    public Context getContext() {

//        Context context = weakContext.get();
        return context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onStop() {

    }

    public void add(Subscription m) {
        mRxManager.add(m);
    }

    @Override
    public void onDestroy() {
        weakView = null;
//        weakContext = null;
        mRxManager.clear();
        setCanReach(false);

        /*try {
            M model1 = getModel();
            if (model1 != null) {
                getModel().clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/

    }

    /**
     * 如果canReach为false，getView方法将不可用
     *
     * @return
     */
    public boolean isCanReach() {
        return canReach;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return false;
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onAttachFragment(Fragment fragment) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void deattachView() {
        if (this.weakView != null) {
            this.weakView.clear();
            this.weakView = null;
        }
    }

    @Override
    public void showErrorMsg(String msg) {
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        BaseView view = getView();
        if (view != null) {
            view.showMessage(msg);
        }
    }


    public void setCanReach(boolean canReach) {
        this.canReach = canReach;
    }


}
