package com.kuaike.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.kuaike.model.Restaurant;
import com.kuaike.wdkuaike.R;

import java.util.List;

/**
 * Created by Administrator on 2016/7/29.
 */
public class RestaurantListViewAdapter extends BaseAdapter {

    private Context context;
    private List<Restaurant> arrayList;

    public RestaurantListViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList != null && arrayList.size() > 0 ? arrayList.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = null;
        if (holder == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(R.layout.restaurant_items, null);
            holder.bindView(view);
            view.setTag(holder);
        } else {
            holder = (Holder) view.getTag();
        }
        holder.reset(i);
        return view;
    }

    private class Holder {
        private View view;
        private ImageView img_restaurant;
        private TextView tv_restaurant_name, tv_restaurant_price, tv_restaurant_classify, tv_restaurant_distance;
        private RatingBar ratingBar;

        public void bindView(View convertView) {
            view = convertView;
            img_restaurant = (ImageView) convertView.findViewById(R.id.img_restaurant);
            tv_restaurant_name = (TextView) convertView.findViewById(R.id.tv_restaurant_name);
            ratingBar = (RatingBar) convertView.findViewById(R.id.ratingBar);
            tv_restaurant_price = (TextView) convertView.findViewById(R.id.tv_restaurant_price);
            tv_restaurant_classify = (TextView) convertView.findViewById(R.id.tv_restaurant_classify);
            tv_restaurant_distance = (TextView) convertView.findViewById(R.id.tv_restaurant_distance);

        }

        public void reset(final int position) {
            final Restaurant restaurant = arrayList.get(position);
            tv_restaurant_name.setText(restaurant.getRestaurantName());
            ratingBar.setRating(restaurant.getRantingBar());
            tv_restaurant_price.setText(restaurant.getResraurantPrice());
            tv_restaurant_classify.setText(restaurant.getRestaurantClassify());
            tv_restaurant_distance.setText(restaurant.getRestaurantDestince());

        }
    }

    public void setArrayList(List arrayList) {
        this.arrayList = arrayList;
        notifyDataSetChanged();
    }
}
