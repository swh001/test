package com.kuaike.widget.filterView;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kuaike.wdkuaike.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/7/29.
 */
public class FilterView extends LinearLayout implements View.OnClickListener {

    @Bind(R.id.tv_all)
    TextView tvAll;
    @Bind(R.id.iv_all_arrow)
    ImageView ivAllArrow;
    @Bind(R.id.tv_nearby)
    TextView tvNearby;
    @Bind(R.id.iv_nearby_arrow)
    ImageView ivNearbyArrow;
    @Bind(R.id.tv_sort)
    TextView tvSort;
    @Bind(R.id.iv_sort_arrow)
    ImageView ivSortArrow;
    @Bind(R.id.tv_filter)
    TextView tvFilter;
    @Bind(R.id.iv_filter_arrow)
    ImageView ivFilterArrow;
    @Bind(R.id.rl_all)
    RelativeLayout rlAll;
    @Bind(R.id.rl_nearby)
    RelativeLayout rlNearby;
    @Bind(R.id.rl_sort)
    RelativeLayout rlSort;
    @Bind(R.id.rl_filter)
    RelativeLayout rlFilter;


    @Bind(R.id.lv_left)
    ListView lvLeft;
    @Bind(R.id.lv_right)
    ListView lvRight;
    @Bind(R.id.ll_content_list_view)
    LinearLayout llContentListView;
    @Bind(R.id.view_mask_bg)
    View viewMaskBg;

    private Context context;
    private int filterPosition = -1;
    private boolean isShowing = false;
    private int panelHeight;


    public FilterView(Context context) {
        super(context);
        init(context);
    }

    public FilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FilterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.context = context;
        View view = LayoutInflater.from(context).inflate(R.layout.view_filter_layout, this);
        ButterKnife.bind(this, view);

        initData();
        initView();
        initListener();

    }

    private void initData() {

    }

    private void initView() {
        viewMaskBg.setVisibility(GONE);
        llContentListView.setVisibility(GONE);
    }

    private void initListener() {
        rlAll.setOnClickListener(this);
        rlNearby.setOnClickListener(this);
        rlSort.setOnClickListener(this);
        rlFilter.setOnClickListener(this);
        llContentListView.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });


    }


    @Override
    public void onClick(View view) {
        int resId = view.getId();
        if (resId == R.id.rl_all) {
            filterPosition = 0;
            if (onFilterClickListener != null) {
                onFilterClickListener.onFilterClick(filterPosition);
            }
        }
        if (resId == R.id.rl_nearby) {
            filterPosition = 1;
            if (onFilterClickListener != null) {
                onFilterClickListener.onFilterClick(filterPosition);
            }
        }
        if (resId == R.id.rl_sort) {
            filterPosition = 2;
            if (onFilterClickListener != null) {
                onFilterClickListener.onFilterClick(filterPosition);
            }
        }
        if (resId == R.id.rl_filter) {
            filterPosition = 3;
            if (onFilterClickListener != null) {
                onFilterClickListener.onFilterClick(filterPosition);
            }
        }
    }


    // 复位筛选的显示状态
    public void resetFilterStatus() {
        tvAll.setTextColor(context.getResources().getColor(R.color.font_black_2));
//        ivAllArrow.setImageResource(R.mipmap.home_down_arrow);

        tvNearby.setTextColor(context.getResources().getColor(R.color.font_black_2));
//        ivNearbyArrow.setImageResource(R.mipmap.home_down_arrow);

        tvSort.setTextColor(context.getResources().getColor(R.color.font_black_2));
//        ivSortArrow.setImageResource(R.mipmap.home_down_arrow);

        tvFilter.setTextColor(context.getResources().getColor(R.color.font_black_2));
//        ivFilterArrow.setImageResource(R.mipmap.home_down_arrow);
    }

    // 显示筛选布局
    public void showFilterLayout(int position) {
        resetFilterStatus();
        switch (position) {
            case 0:
                setAllAdapter();
                break;
            case 1:
                setNearbyAdapter();
                break;
            case 2:
                setSortAdapter();
                break;
            case 3:
                setFilterAdapter();
                break;
        }

        if (isShowing) return;
        show();
    }

    private void show() {
        isShowing = true;
        viewMaskBg.setVisibility(VISIBLE);
        llContentListView.setVisibility(VISIBLE);
        llContentListView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                llContentListView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                panelHeight = llContentListView.getHeight();
                ObjectAnimator.ofFloat(llContentListView, "translationY", -panelHeight, 0).setDuration(200).start();
            }
        });
    }

    //设置筛选中筛选的数据
    private void setFilterAdapter() {
        tvFilter.setTextColor(context.getResources().getColor(R.color.colorTheme));
    }

    //设置筛选分类的数据
    private void setSortAdapter() {
        tvSort.setTextColor(context.getResources().getColor(R.color.colorTheme));
    }

    //设置筛选附近的数据
    private void setNearbyAdapter() {
        tvNearby.setTextColor(context.getResources().getColor(R.color.colorTheme));
    }


    //设置筛选全部的数据
    private void setAllAdapter() {
        tvAll.setTextColor(context.getResources().getColor(R.color.colorTheme));



    }


    // 筛选视图点击
    private OnFilterClickListener onFilterClickListener;

    public void setOnFilterClickListener(OnFilterClickListener onFilterClickListener) {
        this.onFilterClickListener = onFilterClickListener;
    }

    public interface OnFilterClickListener {
        void onFilterClick(int position);
    }
}
