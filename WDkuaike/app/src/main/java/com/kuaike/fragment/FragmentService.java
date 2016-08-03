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
public class FragmentService extends BaseFragment {
    
    private View root;
    public static FragmentService newInstance() {
        FragmentService fragment = new FragmentService();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (root == null) {
            root = inflater.inflate(R.layout.fragment_service, container, false);
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
