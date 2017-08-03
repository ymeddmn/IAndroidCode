package com.example.demo.idemo.anim;

import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.example.demo.idemo.R;
import com.example.demo.idemo.base.BaseActivity;

public class ValueAnimatorActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);
        iv = (ImageView) findViewById(R.id.iv_value_anim1);
        iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_value_anim1:
                showAnim1();
                break;
        }
    }

    private void showAnim1() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 3000);
        animator.setDuration(2000);
        animator.setInterpolator(new TimeInterpolator() {
            @Override
            public float getInterpolation(float input) {
                return input * input;
            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                iv.setY(value);
            }
        });
        animator.start();
    }
}
