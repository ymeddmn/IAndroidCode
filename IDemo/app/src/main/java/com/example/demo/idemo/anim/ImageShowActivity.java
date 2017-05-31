package com.example.demo.idemo.anim;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.demo.idemo.R;
import com.example.demo.idemo.anim.view.ImageShowView;
import com.example.demo.idemo.anim.view.SmoothImageView;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class ImageShowActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv;
    private ArrayList<String> mDatas;
    private int mPosition;
    private int mLocationX;
    private int mLocationY;
    private int mWidth;
    private int mHeight;
    private String path;
    private float x;
    private float y;
    private LinearLayout ll;
    private float width;
    private float height;
    private SmoothImageView show;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mDatas = (ArrayList<String>) getIntent().getSerializableExtra("images");
//        mPosition = getIntent().getIntExtra("position", 0);
//        mLocationX = getIntent().getIntExtra("locationX", 0);
//        mLocationY = getIntent().getIntExtra("locationY", 0);
//        mWidth = getIntent().getIntExtra("width", 0);
//        mHeight = getIntent().getIntExtra("height", 0);
//
//        imageView = new SmoothImageView(this);
//        imageView.setOriginalInfo(mWidth, mHeight, mLocationX, mLocationY);
//        imageView.transformIn();
//        imageView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
//        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        setContentView(R.layout.activity_image_show);
        imageView = (ImageView) findViewById(R.id.iv_show);
        ImageLoader.getInstance().displayImage(mDatas.get(mPosition), imageView);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        /*iv.setX(x);
        iv.setY(y);
        index = 0;
        startAnim();*/
    }

    private int index;

    private void startAnim() {
        float width = iv.getMeasuredWidth();
        float height = iv.getMeasuredHeight();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float screenWidth = metrics.widthPixels;
        float statusHeight = getStatusHeight();
        float screenHeight = metrics.heightPixels - statusHeight;
        float x = iv.getX();
        float y = iv.getY();
        float scaleX = (x) / screenWidth;
        float scaleY = (y) / screenHeight;
        ScaleAnimation animation = null;
        if (index % 2 == 0) {
            animation = new ScaleAnimation(0f, (screenWidth / width), 0f, (screenHeight / height), Animation.RELATIVE_TO_SELF, scaleX, Animation.RELATIVE_TO_SELF, scaleY);
        } else {
            animation = new ScaleAnimation((screenWidth / width), 1f, (screenHeight / height), 1f, Animation.RELATIVE_TO_SELF, scaleX, Animation.RELATIVE_TO_SELF, scaleY);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    iv.setVisibility(View.GONE);
                    handler.postDelayed(null, 300);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
        animation.setFillAfter(true);
        animation.setDuration(1500);
        iv.startAnimation(animation);
    }

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            finish();
            return false;
        }
    });

    public float getStatusHeight() {
        float statusBarHeight2 = -1;
        try {
            Class<?> clazz = Class.forName("com.android.internal.R$dimen");
            Object object = clazz.newInstance();
            int height = Integer.parseInt(clazz.getField("status_bar_height")
                    .get(object).toString());
            statusBarHeight2 = getResources().getDimensionPixelSize(height);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return statusBarHeight2;
    }

    @Override
    public void onClick(View v) {
        index = 1;
        startAnim();
    }
}
