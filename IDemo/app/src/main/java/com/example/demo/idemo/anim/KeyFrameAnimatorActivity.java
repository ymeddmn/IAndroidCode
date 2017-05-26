package com.example.demo.idemo.anim;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.demo.idemo.R;
import com.example.demo.idemo.base.BaseActivity;

/**
 * @author mayong
 * @date 创建时间 2017/5/26
 * @description Keyframe动画探究  ，Keyframe动画和PropertyValueHolder和ObjectAnimator结合的使用
 */
public class KeyFrameAnimatorActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key_frame_animator);
        iv = (ImageView) findViewById(R.id.iv_keyframe);
        iv.setImageResource(R.drawable.lufei);
        initListener();
    }

    private void initListener() {
        iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_keyframe:
                showAnim();
                break;
        }
    }

    /**
     * 展示逐帧动画
     * 与ObjectAnimator一样动画中ImageView的值都是相对于ImageView起始位置的值而言的
     * 这里用PropertyValuesHolder可以将多个Keyframe结合到一起，而ObjectAnimator可以将多个PropertyValuesHolder结合
     * 到一起，这个可以实现多种动画同时做的效果，例如本例中向下平移的动画和旋转的动画就是一起执行的，
     */
    private void showAnim() {

        //平移动画定义
        Keyframe keyframe0 = Keyframe.ofFloat(0.1f, 100);
        Keyframe keyframe1 = Keyframe.ofFloat(0.3f, 200);
        Keyframe keyframe2 = Keyframe.ofFloat(0.6f, 200);
        Keyframe keyframe3 = Keyframe.ofFloat(1f, 500);
        PropertyValuesHolder holder = PropertyValuesHolder.ofKeyframe("Y", keyframe0, keyframe1, keyframe2, keyframe3);
        //旋转动画定义
        Keyframe r = Keyframe.ofFloat(0f, 0f);
        Keyframe r0 = Keyframe.ofFloat(0.4f, 0f);
        Keyframe r1 = Keyframe.ofFloat(0.6f, 720f);
        Keyframe r2 = Keyframe.ofFloat(1.0f, 720f);
        PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofKeyframe("rotationY", r, r0, r1, r2);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(iv, holder, rotationHolder);
        objectAnimator.setDuration(9000);
        objectAnimator.start();
    }
}
