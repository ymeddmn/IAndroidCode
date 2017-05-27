package com.example.demo.idemo.anim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;

import com.example.demo.idemo.base.BaseImageActivity;

public class RotationAnimationActivity extends BaseImageActivity implements View.OnClickListener {


    @Override
    protected void initListener() {
        ivIcon.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    public void onClick(View v) {
        showAnim();
    }

    private void showAnim() {
        RotateAnimation animation = new RotateAnimation(0f, 2000f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_PARENT, -0.15f);
        animation.setDuration(5000);
        animation.setFillAfter(true);

        ivIcon.startAnimation(animation);
    }
}
