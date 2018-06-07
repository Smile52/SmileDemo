package com.miss.smiledemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



import java.util.ArrayList;
import java.util.List;

public class HeadAdapter extends BaseAdapter<Integer> {
    public HeadAdapter(Context context, List<Integer> datas, ViewPager viewPager) {

        super(context, datas, viewPager);
}

    private ViewGroup.LayoutParams layoutParams;
    @Override
    protected View getItemView(Integer data) {
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        View view= LayoutInflater.from(mContext).inflate(R.layout.item_layout,null);
        ImageView i =view.findViewById(R.id.item_image1);
        i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        i.setImageResource(data);

        return view;
    }

}
