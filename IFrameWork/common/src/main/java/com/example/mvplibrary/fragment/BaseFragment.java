package com.example.mvplibrary.fragment;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.common.R;
import com.example.mvplibrary.utils.ScreenUtils;
import com.example.mvplibrary.utils.SuperToast;
import com.example.mvplibrary.zview.base.BaseView;


public abstract class BaseFragment extends Fragment implements BaseView {


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void showMessage(int message) {
        showMessage(getString(message));
    }

    @Override
    public void showMessage(String message) {
        SuperToast toast = new SuperToast(getContext());
        toast.setGravity(Gravity.TOP, 0, ScreenUtils.dip2px(this.getResources(), 42));
        View view = LayoutInflater.from(getContext()).inflate(R.layout.toast_view, null, false);
        ((TextView) view.findViewById(R.id.text)).setText(message);
        toast.setView(view);
        toast.setDuration(SuperToast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    public void showMessageOnTop(String message) {

    }

    @Override
    public boolean isActive(@NonNull Activity activity) {
        ActivityManager am = (ActivityManager) getActivity().getSystemService(Context.ACTIVITY_SERVICE);
        ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
        Log.d("PackageName      %s", cn.getPackageName());
        Log.d("ClassName        %s", cn.getClassName());
        return activity.getComponentName().getClassName().equals(cn.getClassName());
    }

    public void onNewIntent(Intent intent) {
    }
}
