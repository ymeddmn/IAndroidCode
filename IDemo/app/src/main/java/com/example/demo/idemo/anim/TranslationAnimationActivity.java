package com.example.demo.idemo.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;

import com.example.demo.idemo.R;
import com.example.demo.idemo.base.BaseImageActivity;

/**
 * @author mayong
 * @date 创建时间 2017/5/27
 * @description TranslationAnimation讲解
 */

public class TranslationAnimationActivity extends BaseImageActivity implements View.OnClickListener {

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
        //动画并不会改变控件的真实位置，因为这是视图动画
        TranslateAnimation animation = new TranslateAnimation(0f, 100f, 0f, 200f);
        animation.setDuration(2000);
        animation.setFillAfter(true);
        ivIcon.startAnimation(animation);
    }
}
