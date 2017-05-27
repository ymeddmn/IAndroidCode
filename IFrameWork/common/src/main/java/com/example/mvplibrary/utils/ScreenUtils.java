package com.example.mvplibrary.utils;

import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.lang.reflect.Field;

/**
 * 功能：获取应用程序的屏幕信息
 *
 * @author ${mayong}
 *         创建时间 2016/7/16.
 *         1.initScreen   初始化屏幕宽度和高度
 *         2.isHorizontal 判断应用是否横屏
 *         3.px2Dip
 *         4.dip2px
 *         5.px2sp
 *         6.sp2px
 *         7.getStatusBarHeight得到状态栏高度
 */
public class ScreenUtils {
    /**
     * 屏幕宽度
     **/
    public static int screenWidth;
    /**
     * 屏幕高度
     **/
    public static int screenHeight;
    /**
     * 屏幕密度
     **/
    public static int screenDpi;


    /**
     * 1
     * 初始化屏幕宽度和高度
     *
     * @param activity
     * @author YOLANDA
     */
    public static void initScreen(Activity activity) {
        DisplayMetrics metric = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metric);


        screenWidth = metric.widthPixels;
        screenHeight = metric.heightPixels;
        screenDpi = metric.densityDpi;
    }

    /**
     * 2
     * 是否是横屏
     *
     * @return
     * @author YOLANDA
     */
    public static boolean isHorizontal() {
        return screenWidth > screenHeight;
    }

    /**
     * 3
     *
     * @param resources
     * @param inParam
     * @return
     */
    public static int px2dip(Resources resources, float inParam) {
        float f = resources.getDisplayMetrics().density;
        return (int) (inParam / f + 0.5F);
    }

    /**
     * 4
     *
     * @param resources
     * @param inParam
     * @return
     */
    public static int dip2px(Resources resources, float inParam) {
        float f = resources.getDisplayMetrics().density;
        return (int) (inParam * f + 0.5F);
    }

    /**
     * 5
     *
     * @param resources
     * @param inParam
     * @return
     */
    public static int px2sp(Resources resources, float inParam) {
        float f = resources.getDisplayMetrics().scaledDensity;
        return (int) (inParam / f + 0.5F);
    }

    /**
     * 6
     *
     * @param resources
     * @param inParam
     * @return
     */
    public static int sp2px(Resources resources, float inParam) {
        float f = resources.getDisplayMetrics().scaledDensity;
        return (int) (inParam * f + 0.5F);
    }
    /**   7
     * 拿到状态栏的高度
     * @author YOLANDA
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Activity context) {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return context.getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
