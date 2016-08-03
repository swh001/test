package com.kuaike.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.kuaike.base.BaseActivity;
import com.kuaike.fragment.FragmentAppointment;
import com.kuaike.fragment.FragmentHome;
import com.kuaike.fragment.FragmentMine;
import com.kuaike.fragment.FragmentService;
import com.kuaike.wdkuaike.R;
import com.kuaike.widget.HomeViewPager;

import java.util.ArrayList;


/**
 * Created by Administrator on 2016/7/28.
 */
public class ActivityHomePage extends BaseActivity implements View.OnClickListener {

    private HomeViewPager homeViewPager;
    private RadioGroup main_radio;
    private ArrayList<Fragment> mFragmentList = null;
    private FragmentViewPagerAdapter fragmentViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_pager);
        initView();
    }

    private void initView() {
        homeViewPager = (HomeViewPager) findViewById(R.id.msg_view_pager);
        main_radio = (RadioGroup) findViewById(R.id.main_radio);
        main_radio.check(R.id.tab_home);
        main_radio.findViewById(R.id.tab_home).setOnClickListener(this);
        main_radio.findViewById(R.id.tab_appointment).setOnClickListener(this);
        main_radio.findViewById(R.id.tab_service).setOnClickListener(this);
        main_radio.findViewById(R.id.tab_mine).setOnClickListener(this);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(FragmentHome.newInstance());
        mFragmentList.add(FragmentAppointment.newInstance());
        mFragmentList.add(FragmentService.newInstance());
        mFragmentList.add(FragmentMine.newInstance());

        fragmentViewPagerAdapter = new FragmentViewPagerAdapter(getSupportFragmentManager(), mFragmentList);
        homeViewPager.setAdapter(fragmentViewPagerAdapter);
    }

    @Override
    public void onClick(View view) {
        int resId = view.getId();
        if (resId == R.id.tab_home) {
            homeViewPager.setCurrentItem(0, false);

        }
        if (resId == R.id.tab_appointment) {
            homeViewPager.setCurrentItem(1, false);
        }
        if (resId == R.id.tab_service) {
            homeViewPager.setCurrentItem(2, false);
        }
        if (resId == R.id.tab_mine) {
            homeViewPager.setCurrentItem(3, false);
        }


    }

    private class FragmentViewPagerAdapter extends FragmentStatePagerAdapter {

        private final ArrayList<Fragment> mViewPagerFragments;

        public FragmentViewPagerAdapter(FragmentManager fm, ArrayList<Fragment> list) {
            super(fm);
            mViewPagerFragments = list;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        @Override
        public Fragment getItem(int position) {
            return mViewPagerFragments.get(position);
        }


        @Override
        public int getCount() {
            return mViewPagerFragments.size();
        }
    }
}
