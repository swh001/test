package com.kuaike.utils;

import android.content.Context;
import android.graphics.Point;
import android.view.WindowManager;

/**
 * Created by xiaoping on 2015/11/20.
 */
public class ScreenUtils {

    private static int screenWidth;
    private static int screenHeight;
    private static ScreenUtils mInstance;


    public static ScreenUtils getInstence(Context context){
        if (mInstance==null) {
            synchronized (ScreenUtils.class) {
                if (mInstance==null) {
                    mInstance = new ScreenUtils(context);
                }
            }
        }
        return mInstance;
    }

    public ScreenUtils(Context context) {
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);
        screenWidth = point.x;
        screenHeight = point.y;
    }

    public static int getScreenWidth() {
        return screenWidth;
    }


    public static int getScreenHeight() {
        return screenHeight;
    }


    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static int getMeSureHeight(int width, int height) {
        int scaleHeight;
        float scale = (float) ScreenUtils.screenWidth / (float) width;
        scaleHeight = (int) (scale * height);
        return scaleHeight;
    }

}

