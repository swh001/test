package com.kuaike.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kuaike.base.BaseFragment;
import com.kuaike.ui.home.adapter.ClassifyGridViewAdapter;
import com.kuaike.ui.home.adapter.RestaurantListViewAdapter;
import com.kuaike.model.Restaurant;
import com.kuaike.utils.Log;
import com.kuaike.wdkuaike.R;
import com.kuaike.widget.ClassifyGridView;
import com.kuaike.widget.MyListView;
import com.kuaike.widget.MyScrollView;
import com.kuaike.widget.filterView.FilterView;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Administrator on 2016/7/28.
 */
public class FragmentHome extends BaseFragment implements TencentLocationListener {
    private String TAG = "fragment_home";
    private View root;
    private TextView textView;
    private ClassifyGridView gridViewClassify;
    private ClassifyGridViewAdapter classifyGridViewAdapter;
    private MyListView restaurantListView;
    private List<Restaurant> list = new ArrayList<>();
    private RestaurantListViewAdapter restaurantListViewAdapter;

    private RelativeLayout relativeLayout;
    private int filterPosition = -1; // 点击FilterView的位置：全部(0)、附近(1)、智能排序(2)、筛选(3)
    //筛选
    private FilterView filterView, ll_filter_true;
    private MyScrollView mScrollView;
    private ImageView imgViwe;
    private LinearLayout ly_filter;

    //地图定位
    private TencentLocationManager mLocationManager;


    //二维码
    private TextView tv_code;

    public static FragmentHome newInstance() {
        FragmentHome fragment = new FragmentHome();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_home, container, false);
            initData();
            initView();
            initListener();
        } else {
            ViewGroup parent = (ViewGroup) root.getParent();
            if (parent != null) {
                parent.removeAllViewsInLayout();
            }
        }
        return root;
    }

    private void initData() {
        startLocation();//定位

    }

    private void initListener() {
        mScrollView.setOnScrollViewListener(new MyScrollView.OnScrollViewListener() {
            @Override
            public void onScrollViewListener(View scrollView, int x, int y, int oldx, int oldy) {
                if (y > relativeLayout.getHeight()) {
                    ly_filter.setVisibility(View.VISIBLE);
                } else {
                    ly_filter.setVisibility(View.GONE);
                }
            }
        });
        tv_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    //定位：记得导入.so文件
    public void startLocation() {
        mLocationManager = TencentLocationManager.getInstance(getContext());
        // 创建定位请求
        TencentLocationRequest request = TencentLocationRequest.create()
                .setInterval(10000) // 设置定位周期
                .setRequestLevel(TencentLocationRequest.REQUEST_LEVEL_ADMIN_AREA); // 设置定位level

        // 开始定位
        int error = mLocationManager.requestLocationUpdates(request, this);
        Log.d(TAG, error + "");
    }


    private void initView() {
        tv_code = (TextView) root.findViewById(R.id.tv_code);
        relativeLayout = (RelativeLayout) root.findViewById(R.id.rl_head);
        textView = (TextView) root.findViewById(R.id.local_address);
        mScrollView = (MyScrollView) root.findViewById(R.id.mScrollView);
        imgViwe = (ImageView) root.findViewById(R.id.imgViwe);
        gridViewClassify = (ClassifyGridView) root.findViewById(R.id.gridView_classify);
        classifyGridViewAdapter = new ClassifyGridViewAdapter(getContext());
        gridViewClassify.setAdapter(classifyGridViewAdapter);
        ll_filter_true = (FilterView) root.findViewById(R.id.ll_filter_true);
        filterView = (FilterView) root.findViewById(R.id.ll_filter_false);
        filterView.setOnFilterClickListener(new FilterView.OnFilterClickListener() {
            @Override
            public void onFilterClick(int position) {
                filterPosition = position;
                ll_filter_true.showFilterLayout(position);
                mScrollView.smoothScrollTo(0, relativeLayout.getHeight());
            }
        });
        ly_filter = (LinearLayout) root.findViewById(R.id.ly_filter);

        restaurantListView = (MyListView) root.findViewById(R.id.listView_restaurant);
        restaurantListViewAdapter = new RestaurantListViewAdapter(getContext());
        for (int i = 0; i < 15; i++) {
            Restaurant restaurant = new Restaurant("远方私厨（软件园店）", "25/人", 2, "中餐", "会展中心" + i + "Km");
            list.add(restaurant);
        }
        restaurantListViewAdapter.setArrayList(list);
        restaurantListView.setAdapter(restaurantListViewAdapter);
    }


    @Override
    public void onLocationChanged(TencentLocation tencentLocation, int i, String s) {
        String msg = null;
        if (i == TencentLocation.ERROR_OK) {
            // 定位成功
            msg = tencentLocation.getCity();
            mLocationManager.removeUpdates(this);
        } else {
            // 定位失败
            msg = "未知";
            Log.d(TAG, s);
        }
        textView.setText(msg);

    }

    @Override
    public void onStatusUpdate(String s, int i, String s1) {

    }
}
