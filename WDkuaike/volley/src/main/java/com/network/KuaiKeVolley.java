package com.network;

import android.content.Context;

import com.volley.RequestQueue;
import com.volley.toolbox.Volley;

/**
 * Created by Administrator on 2016/7/28.
 */
public class KuaiKeVolley {
    private static RequestQueue instance;
    public static RequestQueue getInstace(Context pContext){
        if(instance==null){
            instance= Volley.newRequestQueue(pContext);
        }
        return instance;
    }
}
