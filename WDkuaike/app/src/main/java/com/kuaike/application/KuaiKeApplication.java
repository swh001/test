package com.kuaike.application;

import android.app.Application;


import com.volley.RequestQueue;
import com.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Administrator on 2016/7/28.
 */
public class KuaiKeApplication extends Application {
    private HashMap<String,Objects> mTemp=new HashMap<String,Objects>();
    // 建立请求队列
    public static RequestQueue volleyQueue;

    public static KuaiKeApplication kuaiKeApplication;

    public static KuaiKeApplication getInstance() {
        if (kuaiKeApplication == null) {
            kuaiKeApplication = new KuaiKeApplication();
        }
        return kuaiKeApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        /* Volley配置 */
        // 建立Volley的Http请求队列
        volleyQueue = Volley.newRequestQueue(getApplicationContext());
    }

    // 开放Volley的HTTP请求队列接口
    public static RequestQueue getRequestQueue() {
        return volleyQueue;
    }
}
