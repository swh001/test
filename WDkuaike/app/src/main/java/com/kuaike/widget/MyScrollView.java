package com.kuaike.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by Administrator on 2016/7/30.
 */
public class MyScrollView extends ScrollView {

    private OnScrollViewListener onScrollViewListener;

    public MyScrollView(Context context) {
        super(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (onScrollViewListener != null) {
            onScrollViewListener.onScrollViewListener(this, l, t, oldl, oldt);
        }

    }

    public void setOnScrollViewListener(OnScrollViewListener onScrollViewListener) {
        this.onScrollViewListener = onScrollViewListener;
    }

    public interface OnScrollViewListener {
        void onScrollViewListener(View scrollView, int x, int y, int oldx, int oldy);
    }
}
