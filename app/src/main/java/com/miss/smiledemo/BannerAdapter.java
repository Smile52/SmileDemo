package com.miss.smiledemo;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;

import java.util.List;

public class BannerAdapter extends PagerAdapter{

    private List<ImageView> mLists;
    private ViewPager mPager;

    public BannerAdapter(List<ImageView> mLists, ViewPager mPager) {
        this.mLists = mLists;
        this.mPager = mPager;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = mLists.get(position % mLists.size());
        ViewGroup parent = (ViewGroup) view.getParent();
        //如果当前要显示的view有父布局先将父布局移除（view只能有一个父布局）
        if (parent != null) {
            parent.removeView(view);
        }
        container.addView(view);
        return view;


    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
    }
}
