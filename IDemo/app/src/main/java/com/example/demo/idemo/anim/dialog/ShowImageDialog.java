package com.example.demo.idemo.anim.dialog;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.example.demo.idemo.R;

/**
 * @author mayong
 * @date 创建时间 2017/5/31
 * @description
 */

public class ShowImageDialog extends DialogFragment implements View.OnClickListener {
    private ImageView iv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_layout_image_show, container);
        iv = (ImageView) inflate.findViewById(R.id.iv_image_show);
        iv.setOnClickListener(this);
        return inflate;
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        showAnim1();
    }

    private void showAnim2() {
        float ivWidth = iv.getWidth();
        float ivHeight = iv.getHeight();

        float x = iv.getX();
        float y = iv.getY();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float heightPixels = metrics.heightPixels - getStatusHeight();
        float widthPixels = metrics.widthPixels;
//        float xPivot = (x + ivWidth / 2) / widthPixels;
//        float yPivot = (y + ivHeight / 2) / heightPixels;
        float xPivot = (x / (widthPixels - ivWidth));
        float yPivot = (y / (heightPixels - ivHeight));
        ScaleAnimation animation = new ScaleAnimation((widthPixels / ivWidth), 1f, (heightPixels / ivHeight), 1f, Animation.RELATIVE_TO_SELF, xPivot, Animation.RELATIVE_TO_SELF, yPivot);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        iv.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                dismiss();
            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    private void showAnim1() {
        float ivWidth = iv.getWidth();
        float ivHeight = iv.getHeight();

        float x = iv.getX();
        float y = iv.getY();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float heightPixels = metrics.heightPixels - getStatusHeight();
        float widthPixels = metrics.widthPixels;
//        float xPivot = (x + ivWidth / 2) / widthPixels;
//        float yPivot = (y + ivHeight / 2) / heightPixels;
        float xPivot = (x / (widthPixels - ivWidth));
        float yPivot = (y / (heightPixels - ivHeight));
        ScaleAnimation animation = new ScaleAnimation(1f, (widthPixels / ivWidth), 1f, (heightPixels / ivHeight), Animation.RELATIVE_TO_SELF, xPivot, Animation.RELATIVE_TO_SELF, yPivot);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        iv.startAnimation(animation);
    }

    public float getStatusHeight() {
        float statusBarHeight2 = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight2 = getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight2;
    }

    @Override
    public void onClick(View v) {
        showAnim2();
    }
}
