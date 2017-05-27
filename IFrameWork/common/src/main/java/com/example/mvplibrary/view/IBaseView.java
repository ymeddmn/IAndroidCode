package com.example.mvplibrary.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

/**
 * Created by Administrator on 2016/10/18.
 */
public class IBaseView extends FrameLayout {
    private View successView;
    private View errorView;
    private View loadingView;
    private boolean hasLoadingView = false;
    private boolean hasErrorView = false;
    private boolean hasSuccessView = false;

    public IBaseView(Context context) {
        super(context);
    }

    public IBaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IBaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void addSuccessView(View view) {

        removeAll();
        addView(view);
        if(successView == null){
            this.successView = view;
        }
        successView.setVisibility(VISIBLE);
        hasSuccessView = true;
    }

    public void addErrorView(View view) {
        removeAll();
        addView(view);
        if(errorView == null){
            this.errorView = view;
        }
        errorView.setVisibility(VISIBLE);
        hasErrorView = true;
    }

    public void addLoadingView(View view) {
        removeAll();
        addView(view);
        if(loadingView == null){
            loadingView = view;
        }
        loadingView.setVisibility(VISIBLE);
        hasLoadingView = true;
    }

    private void removeAll() {
        if (hasSuccessView) {
            successView.setVisibility(GONE);
            hasSuccessView = false;
        }
        if (hasErrorView) {
            errorView.setVisibility(GONE);
            hasErrorView = false;
        }
        if (hasLoadingView) {
            loadingView.setVisibility(GONE);
            hasLoadingView = false;
        }
    }
}
