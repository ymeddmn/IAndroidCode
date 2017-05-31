package com.example.demo.idemo.anim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.demo.idemo.R;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mayong
 * @date 创建时间 2017/5/31
 * @description 选择图片的专场动画
 */
public class ImageTurnActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv;
    private List<String> datas = new ArrayList<>();
    private String path = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496219845273&di=ed7d4390de59ae72546c82ab685d43ad&imgtype=0&src=http%3A%2F%2Fwww.51wendang.com%2Fpic%2F26f8d945d0da9369a99dc51c%2F1-810-jpg_6-1080-0-0-1080.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_turn);
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);
        iv = (ImageView) findViewById(R.id.iv_image_turn);
        iv.setOnClickListener(this);
        Glide.with(this).load(path).into(iv);
    }

    @Override
    public void onClick(View v) {
        float ivWidth = iv.getWidth();
        float ivHeight = iv.getHeight();
        float x = iv.getX();
        float y = iv.getY();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv.getLayoutParams();
        Intent intent = new Intent(this, ImageShowActivity1.class);
        int[] location = new int[2];
        iv.getLocationOnScreen(location);
        float topMargin = params.topMargin;
        float leftMargin = params.leftMargin;
        intent.putExtra("locationX", location[0]);//必须
        intent.putExtra("locationY", location[1]);//必须
        intent.putExtra("width", ivWidth);
        intent.putExtra("height", ivHeight);
        intent.putExtra("topMargin", topMargin);
        intent.putExtra("leftMargin", leftMargin);
        intent.putExtra("x", x);
        intent.putExtra("y", y);
        startActivity(intent);
    }
}
