package com.example.demo.idemo.main;

import android.os.Bundle;
import android.widget.ListView;

import com.example.demo.idemo.R;
import com.example.demo.idemo.anim.AnimListActivity;
import com.example.demo.idemo.base.BaseActivity;
import com.example.demo.idemo.base.InfoBean;

public class MainActivity extends BaseActivity {

    private InfoBean infoBeans[] = {new InfoBean("动画", AnimListActivity.class)};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv_main);
        setAdapter(infoBeans);
    }


}
