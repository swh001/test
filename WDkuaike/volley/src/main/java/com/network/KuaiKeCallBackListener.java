package com.network;

import com.volley.VolleyError;

/**
 * Created by Administrator on 2016/7/28.
 */
public interface KuaiKeCallBackListener<T> {
    void onSuccessResponse(T response);
    void onErrorResponse(VolleyError error);
}
