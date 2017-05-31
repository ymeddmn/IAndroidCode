package com.example.demo.idemo.anim.view;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.demo.idemo.R;

/**
 * Created by mage on 2017/5/31.
 */

public class ImageShowView extends View {

    private int width;
    private int height;
    private int imageWidth = 1;
    private int imageHeight = 1;
    private int left;
    private int top;
    private float newLeft;
    private float newTop;

    public ImageShowView(Context context) {
        super(context);
    }

    public ImageShowView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageShowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
    }

    private Bitmap bitmap;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        canvas.drawBitmap(bitmap, newLeft, newTop, null);
        canvas.restore();
    }

    public void setImageUrl(String path) {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.lufei);
        imageWidth = bitmap.getWidth();
        imageHeight = bitmap.getHeight();
    }

    public void startAnim() {
        ValueAnimator animator = ValueAnimator.ofObject(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                ScaleType startType = (ScaleType) startValue;
                ScaleType endType = (ScaleType) endValue;

                newLeft = left - left * (endType.widthScale - startType.widthScale) * fraction;
                newTop = top - top - top * (endType.heightScale - startType.heightScale) * fraction;
                int zoomWidth = (int) (imageWidth * (endType.widthScale - startType.widthScale) * fraction);
                int zoomHeight = (int) (imageHeight * (endType.heightScale - startType.heightScale) * fraction);
                if (zoomWidth <= 0) {
                    zoomWidth = 1;
                }
                if (zoomHeight <= 0) {
                    zoomHeight = 1;
                }
                zoomImg(bitmap, zoomWidth, zoomHeight);
                invalidate();
                return null;
            }
        }, new ScaleType(0, 0), new ScaleType(width / imageWidth, height / imageHeight));
        animator.setDuration(2000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                ScaleType value = (ScaleType) animation.getAnimatedValue();
//                newLeft = left - left * value.widthScale;
//                newTop = top - top - top * value.heightScale;
//                zoomImg(bitmap, (int) (imageWidth * value.widthScale), (int) (imageHeight * value.heightScale));
//                invalidate();
            }
        });
    }

    class ScaleType {
        public ScaleType(float widthScale, float heightScale) {
            this.widthScale = widthScale;
            this.heightScale = heightScale;
        }

        public float widthScale;
        public float heightScale;
    }

    public static Bitmap zoomImg(Bitmap bm, int newWidth, int newHeight) {
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片   www.2cto.com
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }
}
