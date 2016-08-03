package com.network;

import android.util.LruCache;
import android.graphics.Bitmap;

import com.volley.toolbox.ImageLoader;

/**
 * Created by Administrator on 2016/7/28.
 */
public class KuaiKeImageCache  implements ImageLoader.ImageCache{
    private LruCache<String, Bitmap> mCache=null;
    private static final int CACHE_MAX_SIZE = 8 * 1024 * 1024;  //默认缓存大小为8M
    public KuaiKeImageCache(){
        if(mCache==null){
            mCache = new LruCache<String, Bitmap>(CACHE_MAX_SIZE) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }
    }
    /**
     * 从缓存中获取图片
     * @param url  获取图片key  当然该key可以根据实际情况 使用url进行变换修改
     * @return
     */
    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }
    /**
     * 向缓存中添加图片
     * @param url  缓存图片key，当然该key可以根据实际情况 使用url进行变换修改 不过规格需要和上面方法的key保持一致
     * @param bitmap  需要缓存的图片
     */
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url,bitmap);
    }
}
