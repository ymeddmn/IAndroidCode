package com.example.demo.idemo.anim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.demo.idemo.R;
import com.example.demo.idemo.base.BaseActivity;
import com.example.demo.idemo.base.InfoBean;

public class AnimListActivity extends BaseActivity {

    private InfoBean[] bean = {new InfoBean("ObjectAnimator", ObjectAnimatorActivity.class),
            new InfoBean("KeyFrame", KeyFrameAnimatorActivity.class)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_list);
        lv = (ListView) findViewById(R.id.lv_anim);
        setAdapter(bean);
    }
}
