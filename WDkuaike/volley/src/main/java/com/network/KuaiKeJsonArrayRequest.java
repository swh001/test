package com.network;

import android.content.Context;

import com.volley.Request;
import com.volley.Response;
import com.volley.VolleyError;
import com.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/28.
 */
public class KuaiKeJsonArrayRequest extends KuaiKeBaseRequest<JSONArray> {
    protected KuaiKeJsonArrayRequest(Context pContext) {
        super(pContext);
    }

    /**
     * 请求返回JSONArray对象 Get请求 无参数，或者get请求的参数直接拼接在URL上面
     * @param url  请求地址
     * @param listener  数据返回回调接口
     */
    public void get(String url, final KuaiKeCallBackListener<JSONArray> listener){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
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
        addRequest(jsonArrayRequest);
    }

    /**
     * 请求返回JSONArray对象 Get请求 有参数，或者get请求的参数直接拼接在URL上面
     * @param url  请求地址
     * @param listener  请求数据返回回调接口
     * @param params   请求参数
     */
    public void get(String url, final KuaiKeCallBackListener<JSONArray> listener,Map<String,String> params){
        url=createGetUrlWithParams(url,params);
        this.get(url, listener);
    }

    /**
     * POST请求返回JSONArray对象
     * @param url   请求地址
     * @param listener   请求数据返回回调接口
     * @param params   POST请求参数
     */
    public void post(String url, final KuaiKeCallBackListener<JSONArray> listener,Map<String,String> params){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
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
        addRequest(jsonArrayRequest,params);
    }
}
