package com.example.demo.idemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.demo.idemo.R;

/**
 * Created by mage on 2017/5/27.
 */

public abstract class BaseImageActivity extends BaseActivity {
    public ImageView ivIcon;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_image);
        ivIcon = (ImageView) findViewById(R.id.iv_base_image);
        initView();
        initListener();
        initData();
    }

    protected abstract void initListener();

    protected abstract void initData();

    protected abstract void initView();
}
