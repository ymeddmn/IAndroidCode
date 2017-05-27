package com.example.mvplibrary.zpresenter.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/9/30.
 */
public interface BaseFragmentPresenter extends Presenter {
    void onActivityResult(int requestCode, int resultCode, Intent data);

    void onAttach(Context context);

    void onCreate(Bundle savedInstanceState);

    View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

    void onViewCreated(View view, Bundle savedInstanceState);

    void onActivityCreated(Bundle savedInstanceState);

    void onStart();

    void onResume();

    void onSaveInstanceState(Bundle outState);

    void onConfigurationChanged(Configuration newConfig);

    void onPause();

    void onStop();

    void onDestroyView();

    void onDestroy();

    void onDetach();
}
