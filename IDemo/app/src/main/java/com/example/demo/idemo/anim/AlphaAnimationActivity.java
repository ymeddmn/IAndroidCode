package com.example.demo.idemo.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.example.demo.idemo.R;
import com.example.demo.idemo.base.BaseActivity;

/**
 * @author mayong
 * @date 创建时间 2017/5/27
 * @description 透明度动画
 */
public class AlphaAnimationActivity extends BaseActivity implements View.OnClickListener {
    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha_animation);
        iv = (ImageView) findViewById(R.id.iv_alpha_amin);
        iv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_alpha_amin:
                showAnim();
                break;
        }
    }

    private void showAnim() {
        AlphaAnimation animation = new AlphaAnimation(0f, 0.5f);
        animation.setDuration(2000);
        animation.setFillAfter(true);//动画结束的时候停留在结束时候的状态
//        animation.setStartOffset(1000);//点击后一秒后再执行动画
        animation.setStartTime(System.currentTimeMillis()+1000);//不知道这个是啥意思
        iv.startAnimation(animation);
    }
}
