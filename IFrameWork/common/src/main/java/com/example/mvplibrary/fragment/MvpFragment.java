package com.example.mvplibrary.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvplibrary.listener.DialogListener;
import com.example.mvplibrary.view.IBaseView;
import com.example.mvplibrary.zpresenter.base.BaseFragmentPresenter;


public abstract class MvpFragment<P extends BaseFragmentPresenter> extends BaseFragment {

    public FragmentActivity mContext;
    P presenter;
    private IBaseView rootView;
    private DialogListener dialogListener;

    public P getPresenter() {
        return presenter;
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        getPresenter().onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = getActivity();
        presenter = createPresenter();
        getPresenter().onAttach(context);
        getPresenter().attachView();
    }

    public abstract P createPresenter();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresenter().onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getPresenter().onCreateView(inflater, container, savedInstanceState);
        rootView = new IBaseView(mContext);
        rootView.addSuccessView(addFirstView());
        return rootView;
    }

    /**
     * 用于创建fragment的布局，子类实现这个方法代替onCreateView
     *
     * @return
     */
    protected abstract View addFirstView();


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getPresenter().onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        getPresenter().onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getPresenter().onSaveInstanceState(outState);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getPresenter().onConfigurationChanged(newConfig);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPresenter().onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        getPresenter().onDestroy();
        getPresenter().deattachView();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        getPresenter().onDetach();
    }

    public void showProgress() {

    }

    public void hidProgress() {

    }

    public boolean isShowing() {

        return false;
    }

    public void toast(String msg) {

    }

    public void addSuccessView(View view) {
        this.rootView.addView(view);
    }

    public void addErrorView(View view) {
        this.rootView.addView(view);
    }

    public void addLoadingView(View view) {
        this.rootView.addView(view);
    }

    @Override
    public void showDialog(String msg) {
        if(dialogListener != null) {
            dialogListener.showDialoglistener(msg);
        }
    }

    @Override
    public void hideDialog() {
        if(dialogListener != null) {
            dialogListener.hideDialoglistener();
        }
    }

    public void setDialogListener(DialogListener dialogListener) {
        this.dialogListener = dialogListener;
    }

}
