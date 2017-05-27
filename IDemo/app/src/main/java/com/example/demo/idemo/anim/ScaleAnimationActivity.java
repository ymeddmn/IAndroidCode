package com.example.demo.idemo.anim;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

import com.example.demo.idemo.base.BaseImageActivity;

/**
 * Created by mage on 2017/5/27.
 */

public class ScaleAnimationActivity extends BaseImageActivity implements View.OnClickListener {

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
        ScaleAnimation animation = new ScaleAnimation(0f, 3f, 0f, 3f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_PARENT, 0f);
        animation.setFillAfter(true);
        animation.setDuration(1500);
        ivIcon.startAnimation(animation);
    }
}
 