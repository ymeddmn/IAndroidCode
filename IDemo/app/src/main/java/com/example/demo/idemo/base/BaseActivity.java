package com.example.demo.idemo.base;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mayong
 * @date 创建时间 2017/5/25
 * @description 基类activity
 */


public class BaseActivity extends AppCompatActivity {
    private List<InfoBean> datas = new ArrayList<>();
    public ListView lv;

    private MainAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void setAdapter(InfoBean[] beans) {
        if (lv != null) {
            datas = Arrays.asList(beans);
            adapter = new MainAdapter(this);
            lv.setDivider(new ColorDrawable(Color.WHITE));
            lv.setAdapter(adapter);
        }
    }

    class MainAdapter extends BaseAdapter {
        private final Context context;

        public MainAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            Button button = new Button(context);
            button.setText(datas.get(position).getActivityName());
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, datas.get(position).getClz()));
                }
            });
            return button;
        }
    }
}
