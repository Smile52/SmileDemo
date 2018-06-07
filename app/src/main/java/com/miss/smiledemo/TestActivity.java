package com.miss.smiledemo;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    private ViewPager mPager;

    HeadAdapter loopVPAdapter;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mPager=findViewById(R.id.mvp);

        mPager.setClipToPadding(false);
        // set padding manually, the more you set the padding the more you see of prev & next page
        mPager.setPadding(50, 0, 50, 0);
        // sets a margin b/w individual pages to ensure that there is a gap b/w them
        mPager.setPageMargin(10);
        List<Integer> urls=new ArrayList<>();
        urls.add(R.mipmap.img1);
        urls.add(R.mipmap.img2);
        urls.add(R.mipmap.img3);
        loopVPAdapter=new HeadAdapter(getApplicationContext(), urls,mPager);

        mHandler=new Handler();

        mHandler.postDelayed(new TestActivity.TimerRunnable(), 3000);
        ViewPagerScroller scroller = new ViewPagerScroller(TestActivity.this);
        scroller.setScrollDuration(1500);
        scroller.initViewPagerScroll(mPager);//这个是设置切换过渡时间为2秒

    }

    class TimerRunnable implements Runnable{

        @Override
        public void run() {
            int curItem = mPager.getCurrentItem();
            mPager.setCurrentItem(curItem+1);
            if (mHandler!=null){
                mHandler.postDelayed(this,3000);
            }
        }
    }
}
