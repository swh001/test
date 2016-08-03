package com.kuaike.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kuaike.wdkuaike.R;

/**
 * Created by Administrator on 2016/8/3.
 */
public class TitleBar extends RelativeLayout {

    private Context context;
    private View titleBar;

    private TextView tv_left,tv_title,tv_right;

    public TitleBar(Context context) {
        this(context, null);
        this.context = context;
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.view_titlebar,this,true);
        tv_title= (TextView) findViewById(R.id.tv_title);
        tv_left= (TextView) findViewById(R.id.tv_left);
        tv_right= (TextView) findViewById(R.id.tv_right);
    }

    public TitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
