package com.miss.smiledemo;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 这个不是无限滚动的，看另一个activity
 */
public class MainActivity extends AppCompatActivity {
    private ViewPager mPager;
    private BannerAdapter mAdapter;
    private List<ImageView> mList;
    private int previousPosition = 0; // 前一个被选中的position
    private int mcurrent=1;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPager=findViewById(R.id.viewpager);
        init();
        mAdapter=new BannerAdapter(mList, mPager);
        mPager.setClipToPadding(false);
        mPager.setPadding(80, 0, 80, 0);
        mPager.setPageMargin(40);

        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(100);
        mPager.setOffscreenPageLimit(2);
        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
              /*  //重点！重点！这里是重点！
                int pageIndex = position;

                if (position == 0) {
                    // 当视图在第一个时，将页面号设置为图片的最后一张。
                    pageIndex = mList.size() - 2;
                } else if (position == mList.size() - 1) {
                    // 当视图在最后一个是,将页面号设置为图片的第一张。
                    pageIndex = 1;
                }
                if (position != pageIndex) {
                    // 这里注意下 setCurrentItem（arg1）和setCurrentItem（arg1，arg2）的区别。
                    mPager.setCurrentItem(pageIndex, false);
                    return;
                }*/

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        mHandler=new Handler();

        mHandler.postDelayed(new TimerRunnable(), 3000);

        ViewPagerScroller scroller = new ViewPagerScroller(MainActivity.this);
        scroller.setScrollDuration(1500);
        scroller.initViewPagerScroll(mPager);//这个是设置切换过渡时间为2秒


    }

    private void init(){
        int[] images={R.mipmap.img1, R.mipmap.img2, R.mipmap.img3};
        ImageView imageView;
        mList=new ArrayList<>();
        /*
        imageView=new ImageView(this);
        imageView.setImageResource(images[0]);
        mList.add(imageView);*/

        for (int i = 0; i < images.length; i++) {
            imageView=new ImageView(this);
            imageView.setImageResource(images[i]);
            mList.add(imageView);
        }
       /* imageView=new ImageView(this);
        imageView.setImageResource(images[2]);
        mList.add(imageView);*/

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler=null;
    }
}
