package com.network;

import android.content.Context;

import com.volley.Request;
import com.volley.Response;
import com.volley.VolleyError;
import com.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/28.
 */
public class KuaiKeJsonObjectRequest extends KuaiKeBaseRequest<JSONObject> {
    protected KuaiKeJsonObjectRequest(Context pContext) {
        super(pContext);
    }

    /**
     * 请求返回JSONObject对象 Get请求 无参数，或者get请求的参数直接拼接在URL上面
     * @param url   请求地址
     * @param listener  数据回调接口
     */
    public void get(String url, final KuaiKeCallBackListener<JSONObject> listener){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(listener!=null){
                    listener.onSuccessResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(listener!=null){
                    listener.onErrorResponse(error);
                }
            }
        });
        addRequest(jsonObjectRequest);
    }

    /**
     * 普通请求返回JSONObject对象 Get请求 携带请求参数
     * @param url  请求地址
     * @param listener   数据返回回调接口
     * @param params    请求参数
     */
    public void get(String url, final KuaiKeCallBackListener<JSONObject> listener,Map<String,String> params){
        url=createGetUrlWithParams(url,params);
        this.get(url, listener);
    }

    /**
     * 发送POST请求, 返回JSONObject对象数据
     * @param url    请求地址
     * @param listener  数据返回回调接口
     * @param params   POST请求参数
     */
    public void post(String url, final KuaiKeCallBackListener<JSONObject> listener,Map<String,String> params){
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if(listener!=null){
                    listener.onSuccessResponse(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(listener!=null){
                    listener.onErrorResponse(error);
                }
            }
        });
        addRequest(jsonObjectRequest,params);
    }
}
