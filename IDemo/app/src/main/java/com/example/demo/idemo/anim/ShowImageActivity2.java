package com.example.demo.idemo.anim;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.demo.idemo.R;

public class ShowImageActivity2 extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv;
    private LinearLayout llContainer;
    private float left, right, top, bottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image2);
        llContainer = (LinearLayout) findViewById(R.id.ll_show2);
        iv = (ImageView) findViewById(R.id.iv_show2);
//         iv = new ImageView(this);
//        iv.setImageResource(R.drawable.lufei);
//        setContentView(iv);


        iv.setOnClickListener(this);
        Intent intent = getIntent();
        x1 = intent.getFloatExtra("x", 0);
        y1 = intent.getFloatExtra("y", 0);
        width1 = intent.getFloatExtra("width", 0);
        height1 = intent.getFloatExtra("height", 0);
        left = intent.getFloatExtra("left", 0);
        right = intent.getFloatExtra("right", 0);
        top = intent.getFloatExtra("top", 0);
        bottom = intent.getFloatExtra("bottom", 0);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//        FrameLayout.LayoutParams params = (FrameLayout.LayoutParams) iv.getLayoutParams();
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv.getLayoutParams();
        params.width = (int) width1;
        params.height = (int) height1;
        params.leftMargin = (int) left;
        params.topMargin = (int) top;
        iv.setLayoutParams(params);

//        iv.setLeft((int) left);
//        iv.setRight((int) right);
//        iv.setTop((int) top);
//        iv.setBottom((int) bottom);
//        iv.setX(x1);
//        iv.setY(y1);
        llContainer.requestLayout();
        iv.invalidate();
        handler.postDelayed(null,200); 
    }
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            showAnim();

            return false;
        }
    });
    @Override
    public void onClick(View view) {
        showAnim1();
    }

    float width1, height1, x1, y1;

    private void showAnim() {
        float width = iv.getWidth();
        int height = iv.getHeight();
        float x = iv.getX();
        float y = iv.getY();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float widthPixels = displayMetrics.widthPixels;
        float heightPixels = displayMetrics.heightPixels - getStatusHeight();
        float sX = width * x / (widthPixels - width);
        float sY = height * y / (heightPixels - height);
        ScaleAnimation animation = new ScaleAnimation(1f, widthPixels / width, 1f, heightPixels / height, sX, sY);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        iv.startAnimation(animation);

    }

    private void showAnim1() {
        float width = iv.getWidth();
        float height = iv.getHeight();
        float x = iv.getX();
        float y = iv.getY();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float widthPixels = displayMetrics.widthPixels;
        float heightPixels = displayMetrics.heightPixels - getStatusHeight();
        float sX = width * x / (widthPixels - width);
        float sY = height * y / (heightPixels - height);
        ScaleAnimation animation = new ScaleAnimation(widthPixels / width, 1f, heightPixels / height, 1f, sX, sY);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        iv.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                overridePendingTransition(0, 0);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

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
}
