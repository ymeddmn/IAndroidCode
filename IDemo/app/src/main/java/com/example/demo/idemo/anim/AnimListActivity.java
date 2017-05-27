package com.example.demo.idemo.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.demo.idemo.R;
import com.example.demo.idemo.base.BaseActivity;
import com.example.demo.idemo.base.InfoBean;

public class AnimListActivity extends BaseActivity {

    private InfoBean[] bean = {new InfoBean("ObjectAnimator", ObjectAnimatorActivity.class),
            new InfoBean("KeyFrame", KeyFrameAnimatorActivity.class),
            new InfoBean("图片转换为圆形", CircleImageActivity.class),
            new InfoBean("AlphaAnimation动画", AlphaAnimationActivity.class),
            new InfoBean("TranslationAnimation动画", TranslationAnimationActivity.class),
            new InfoBean("ScaleAnimation动画", ScaleAnimationActivity.class),
            new InfoBean("RotationAnimation动画", RotationAnimationActivity.class),
            new InfoBean("ValueAnimator动画", ValueAnimatorActivity.class)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_list);
        lv = (ListView) findViewById(R.id.lv_anim);
        setAdapter(bean);
    }
}
