package com.network;

import android.content.Context;

import com.volley.Request;
import com.volley.RequestQueue;
import com.volley.toolbox.Volley;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/28.
 */
public class KuaiKeBaseRequest<T> {


    private static final String TAG=KuaiKeBaseRequest.class.toString();
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    protected static RequestQueue requestQueue;
    private Context mContext;
    protected KuaiKeBaseRequest(Context pContext){
        this.mContext=pContext;
        requestQueue= KuaiKeVolley.getInstace(mContext);
    }
    /**
     * 请求加入到Volley Request请求队列中
     * @param request
     */
    protected void addRequest(Request request){
        this.addRequest(request,null);
    }

    /**
     * 请求和请求参数 加入到Volley Request请求队列中
     * @param request
     * @param params
     */
    protected void addRequest(Request request,Map<String,String> params){
        //请求中添加 请求参数
        request.setParams(params);
        requestQueue.add(request);
    }

    /**
     * 根据请求地址和请求参数进行拼接成新的请求地址
     * @param url  请求服务器地址
     * @param params  请求参数
     * @return  拼接过后的地址
     */
    protected  String createGetUrlWithParams(String url,Map<String,String> params){
        if(params!=null){
            StringBuffer stringBuffer=new StringBuffer(url);
            if(!url.contains("?")){
                stringBuffer.append('?');
            }
            for(Map.Entry<String,String> entry:params.entrySet()){
                String key=entry.getKey().toString();
                String value=null;
                if(entry.getValue()==null){
                    value="";
                }else {
                    value=entry.getValue().toString();
                }
                stringBuffer.append(key);
                stringBuffer.append("=");
                try {
                    KuaiKeLog.d(TAG,"get获取数据的key:"+key);
                    KuaiKeLog.d(TAG,"get获取数据的value:"+value);
                    value= URLEncoder.encode(value, DEFAULT_PARAMS_ENCODING);
                    KuaiKeLog.d(TAG,"get编码后value:"+value);
                    stringBuffer.append(value);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                stringBuffer.append('&');
            }
            //删除最后一个'&'
            stringBuffer.deleteCharAt(stringBuffer.length()-1);
            url=stringBuffer.toString();
        }
        KuaiKeLog.d(TAG,"get请求地址url:"+url);
        return url;
    }

}
