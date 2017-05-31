package com.example.demo.idemo.anim;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.demo.idemo.R;
import com.example.demo.idemo.anim.dialog.ShowImageDialog;
import com.example.demo.idemo.base.BaseActivity;

public class ImageShowActivity1 extends BaseActivity implements View.OnClickListener {

    private ImageView iv;
    private float screenWidth;
    private float screenHeight;
    private float topMagin;
    private float leftMargin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        iv = new ImageView(this);
        setContentView(R.layout.activity_image_show1);
        Intent intent = getIntent();
        x1 = intent.getFloatExtra("x", 0);
        y1 = intent.getFloatExtra("y", 0);
        ivWidth1 = intent.getFloatExtra("width", 0);
        ivHeight1 = intent.getFloatExtra("height", 0);
        topMagin = intent.getFloatExtra("topMargin",0);
        leftMargin = intent.getFloatExtra("leftMargin",0);

        iv = (ImageView) findViewById(R.id.iv_show1);

        iv.setOnClickListener(this);

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv.getLayoutParams();
        params.width = (int) ivWidth1;
        params.height = (int) ivHeight1;
        params.leftMargin = (int) leftMargin;
        params.topMargin = (int) topMagin;
        iv.setLayoutParams(params);
//        iv.setX(x1);
//        iv.setY(y1);
        showAnim1();
    }

    @Override
    public void onClick(View v) {
        showAnim2();
//        ShowImageDialog editNameDialog = new ShowImageDialog();
//        editNameDialog.show(getSupportFragmentManager(), "EditNameDialog");
    }


    float ivWidth1, ivHeight1;
    float x1, y1;

    private void showAnim1() {
        float ivWidth = iv.getWidth();
        float ivHeight = iv.getHeight();

        float x = iv.getX();
        float y = iv.getY();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float heightPixels = metrics.heightPixels - getStatusHeight();
        float widthPixels = metrics.widthPixels;
//        float xPivot = (x + ivWidth / 2) / widthPixels;
//        float yPivot = (y + ivHeight / 2) / heightPixels;
        float xPivot = (x / (widthPixels - ivWidth));
        float yPivot = (y / (heightPixels - ivHeight));
        ScaleAnimation animation = new ScaleAnimation(1f, (widthPixels / ivWidth), 1f, (heightPixels / ivHeight), Animation.RELATIVE_TO_SELF, xPivot, Animation.RELATIVE_TO_SELF, yPivot);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        iv.startAnimation(animation);
    }

    private void showAnim2() {
        float ivWidth = iv.getWidth();
        float ivHeight = iv.getHeight();

        float x = iv.getX();
        float y = iv.getY();
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        float heightPixels = metrics.heightPixels - getStatusHeight();
        float widthPixels = metrics.widthPixels;
//        float xPivot = (x + ivWidth / 2) / widthPixels;
//        float yPivot = (y + ivHeight / 2) / heightPixels;
        float xPivot = (x / (widthPixels - ivWidth));
        float yPivot = (y / (heightPixels - ivHeight));
        ScaleAnimation animation = new ScaleAnimation((widthPixels / ivWidth), 1f, (heightPixels / ivHeight), 1f, Animation.RELATIVE_TO_SELF, xPivot, Animation.RELATIVE_TO_SELF, yPivot);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        iv.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.setVisibility(View.GONE);
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
