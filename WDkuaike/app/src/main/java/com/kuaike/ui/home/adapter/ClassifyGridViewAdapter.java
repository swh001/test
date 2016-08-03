package com.kuaike.ui.home.adapter;

import android.content.ComponentName;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kuaike.wdkuaike.R;

/**
 * Created by Administrator on 2016/7/29.
 */
public class ClassifyGridViewAdapter extends BaseAdapter {

    private Context context;
    int[] resource = {R.mipmap.icon_chinese_food, R.mipmap.icon_western_food, R.mipmap.icon_dessert, R.mipmap.icon_barbecue, R.mipmap.icon_cafeteria,
            R.mipmap.icon_jk_food, R.mipmap.icon_snack, R.mipmap.icon_cuisine};

    String[] classifyTitle = {"中餐", "西餐", "甜点饮品", "烧烤烤肉", "自助餐", "日韩料理", "小吃快餐", "川湘菜"};

    public ClassifyGridViewAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return resource.length;
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
            view = LayoutInflater.from(context).inflate(R.layout.classify_items, null);
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
        private TextView textView;
        private ImageView imageView;

        public void bindView(View convertView) {
            view = convertView;
            textView = (TextView) convertView.findViewById(R.id.tv_classify_title);
            imageView = (ImageView) convertView.findViewById(R.id.img_classify);
        }

        public void reset(final int position) {
            imageView.setImageResource(resource[position]);
            textView.setText(classifyTitle[position]);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, classifyTitle[position], Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
