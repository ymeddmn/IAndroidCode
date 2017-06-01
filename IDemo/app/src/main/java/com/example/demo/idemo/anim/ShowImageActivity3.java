package com.example.demo.idemo.anim;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.demo.idemo.R;

import static android.R.attr.width;

public class ShowImageActivity3 extends AppCompatActivity implements View.OnClickListener {
    private ImageView iv;
    private LinearLayout llContainer;
    private float left, right, top, bottom;
    private int outWidth;
    private int outHeight;
    private int screenWidth;
    private float screenHeight;
    private float screenScale;
    private int bitmapScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_image2);
        llContainer = (LinearLayout) findViewById(R.id.ll_show2);
        iv = (ImageView) findViewById(R.id.iv_show2);

        iv.setOnClickListener(this);
        Intent intent = getIntent();
        width1 = intent.getFloatExtra("width", 0);
        height1 = intent.getFloatExtra("height", 0);
        left = intent.getFloatExtra("left", 0);
        top = intent.getFloatExtra("top", 0);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        screenWidth = displayMetrics.widthPixels;
        screenHeight = displayMetrics.heightPixels - getStatusHeight();
        BitmapFactory.Options options = new BitmapFactory.Options();
        //设置为true,表示解析Bitmap对象，该对象不占内存
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), R.drawable.llll, options);
        outWidth = options.outWidth;
        outHeight = options.outHeight;
        screenScale = screenHeight / screenWidth;
        bitmapScale = outHeight / outWidth;
        if (bitmapScale > screenScale) {
            outHeight = (int) screenHeight;
            outWidth = outHeight / bitmapScale;
        } else {
            outWidth = (int) screenWidth;
            outHeight = outWidth * bitmapScale;
        }
        RelativeLayout.LayoutParams rParams = (RelativeLayout.LayoutParams) llContainer.getLayoutParams();
        rParams.width = outWidth;
        rParams.height = outHeight;
        rParams.topMargin = (int) ((screenHeight - outHeight) / 2);
        rParams.leftMargin = (screenWidth - outWidth) / 2;
        llContainer.setLayoutParams(rParams);
        //设置为false,解析Bitmap对象加入到内存中
        options.inJustDecodeBounds = false;
        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iv.getLayoutParams();
        params.width = (int) width1;
        params.height = (int) height1;
        float top1 = top;
        top1 = top1 - (screenHeight - outHeight) / 2;
        float left1 = left;
        left1 = left1 - (screenWidth - outWidth) / 2;
        params.leftMargin = (int) left1;
        params.topMargin = (int) top1;
        iv.setLayoutParams(params);
        llContainer.requestLayout();
        iv.invalidate();
        handler.postDelayed(null, 100);
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

    float width1, height1;

    private void showAnim() {
      /*  float x = iv.getX();
        float y = iv.getY();
        float w = iv.getWidth();
        float h = iv.getHeight();
        float ox = outWidth;

        float oy = outHeight;
        float w1 = screenWidth;
        float h1 = screenHeight;
        float x2 = (w1 - ox) / 2;
        float y2 = (h1 - oy) / 2;


//        float sX = (w * x2 + x2 * x - ox * x - x * x) / (w + x2 - ox);
//        float sY = (h * y2 + y2 * y - oy * y - y * y) / (h + y2 - oy);
        float sX = ox * x / (ox - w);
        float sY = oy * y / (oy - h);
        sX = sX - x;
        sY = sY - y;
//        if (bitmapScale > screenScale) {
//            sY = 0;
//        }
        ScaleAnimation animation = new ScaleAnimation(1f, ox / w, 1f, oy / h, Animation.RELATIVE_TO_PARENT, sX / (sX + x - x2), Animation.RELATIVE_TO_PARENT, sY / (sY + y - y2));
        animation.setDuration(3000);
        animation.setFillAfter(true);
        iv.startAnimation(animation);*/


//        float transY = screenHeight / 2 - iv.getY() - iv.getHeight() / 2;
//        TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 0f, h1 / 2 - (sY + y));
//        AnimationSet animationSet = new AnimationSet(true);
//        animationSet.setDuration(500);
//        animationSet.addAnimation(translateAnimation);
//        animationSet.addAnimation(animation);
//        animationSet.setFillAfter(true);
//        iv.startAnimation(animationSet);


        float width = iv.getWidth();
        float height = iv.getHeight();
        float x = iv.getX();
        float y = iv.getY();
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        float widthPixels = displayMetrics.widthPixels;
//        float heightPixels = displayMetrics.heightPixels - getStatusHeight();
//        float widthPixels = llContainer.getWidth();
//        float heightPixels = llContainer.getHeight();
        float widthPixels = outWidth;
        float heightPixels = outHeight;
        float sX = width * x / (widthPixels - width);
        float sY = height * y / (heightPixels - height);
        ScaleAnimation animation = new ScaleAnimation(1f, widthPixels / width, 1f, heightPixels / height, sX, sY);
        animation.setDuration(500);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setFillAfter(true);
        iv.startAnimation(animation);

    }


    private void showAnim1() {
        float width = iv.getWidth();
        float height = iv.getHeight();
        float x = iv.getX();
        float y = iv.getY();
//        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//        float widthPixels = displayMetrics.widthPixels;
//        float heightPixels = displayMetrics.heightPixels - getStatusHeight();
//        float widthPixels = llContainer.getWidth();
//        float heightPixels = llContainer.getHeight();
        float widthPixels = outWidth;
        float heightPixels = outHeight;
        float sX = width * x / (widthPixels - width);
        float sY = height * y / (heightPixels - height);
        ScaleAnimation animation = new ScaleAnimation(widthPixels / width, 1f, heightPixels / height, 1f, sX, sY);
        animation.setDuration(500);
        animation.setFillAfter(true);animation.setInterpolator(new AccelerateDecelerateInterpolator());
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
