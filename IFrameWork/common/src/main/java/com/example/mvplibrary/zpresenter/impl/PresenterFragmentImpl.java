package com.example.mvplibrary.zpresenter.impl;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvplibrary.utils.RxManager;
import com.example.mvplibrary.zmodel.base.BaseModel;
import com.example.mvplibrary.zpresenter.base.BaseFragmentPresenter;
import com.example.mvplibrary.zview.base.BaseView;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/9/30.
 */
public abstract class PresenterFragmentImpl<M extends BaseModel, V extends BaseView> implements BaseFragmentPresenter {
    private WeakReference<Context> weakContext;
    private WeakReference<V> weakView;
    protected RxManager mRxManager = new RxManager();
    //    private V view;
    private M model;
    private boolean canReach = true;

    public PresenterFragmentImpl(Context context, V view) {
        this.weakContext = new WeakReference<Context>(context);
        this.weakView = new WeakReference<V>(view);
        model = createModel();
    }

    /**
     * 得到上下文
     *
     * @return
     */
    public Context getContext() {
        if(weakContext != null) {
            Context context = weakContext.get();
            return context;
        }
        return null;
    }

    public V getView() {
        return weakView.get();
    }

    public void setView(V view) {
        this.weakView = new WeakReference<V>(view);
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public abstract M createModel();

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

    }

    @Override
    public void onAttach(Context context) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroyView() {

    }

    @Override
    public void onDestroy() {
        mRxManager.clear();
        setCanReach(false);
    }

    public boolean isCanReach() {
        return canReach;
    }

    @Override
    public void onDetach() {

    }

    @Override
    public void showErrorMsg(String msg) {
        if(TextUtils.isEmpty(msg)) {
            return;
        }
        BaseView view = getView();
        if(view != null) {
            view.showMessage(msg);
        }
    }

    public void setCanReach(boolean canReach) {
        this.canReach = canReach;
    }

    @Override
    public void attachView() {

    }

    @Override
    public void deattachView() {

    }
}
