package com.kuaike.fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kuaike.base.BaseFragment;
import com.kuaike.wdkuaike.R;

/**
 * Created by Administrator on 2016/7/28.
 */
public class FragmentAppointment extends BaseFragment {

    private View root;
    
    public static FragmentAppointment newInstance() {
        FragmentAppointment fragment = new FragmentAppointment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_appointment, container, false);
            initView();
        } else {
            ViewGroup parent = (ViewGroup) root.getParent();
            if (parent != null) {
                parent.removeAllViewsInLayout();
            }
        }
        return root;
    }

    private void initView() {
    }

}
