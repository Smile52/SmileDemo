package com.miss.calendar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ContentLayout extends LinearLayout implements View.OnClickListener {

    private List<DayEntity> mDayList;

    private int[] daynum=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    private RecyclerView mContentView;

    private CalendarAdapter mAdapter;
    private Context mContext;
    private View view;
    private TextView mMonth,mYear;
    private ImageView mMinus, mAdd;
    private boolean isCurrentMonth=true;
    private List<DayEntity> mLastDayList;


    public ContentLayout(@NonNull Context context) {
        super(context);
    }

    public ContentLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        view = LayoutInflater.from(context).inflate(R.layout.test_layout, this, true);
        mContext=context;
    }


    public ContentLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mContentView=view.findViewById(R.id.rlv);
        mMonth=view.findViewById(R.id.month_tv);
        mYear=view.findViewById(R.id.year_tv);
        mAdd=view.findViewById(R.id.add_img);
        mMinus=view.findViewById(R.id.minus_img);
        mAdd.setOnClickListener(this);
        mMinus.setOnClickListener(this);
        mLastDayList=new ArrayList<>();
        mDayList=new ArrayList<>();
        initData();


        mContentView.setLayoutManager(new GridLayoutManager(mContext,7));
        mAdapter=new CalendarAdapter(mDayList);
        mContentView.setAdapter(mAdapter);

    }

    int currentWeek;
    private void initData() {
        Calendar c = Calendar.getInstance();
                 c.add(Calendar.MONTH, 0);
                 c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        int week =c.get(Calendar.DAY_OF_WEEK);

        int month =c.get(Calendar.MONTH);
        for (int i=1;i<=week-1;i++){
            DayEntity d =new DayEntity();
            d.setData(false);
            mDayList.add(d);
        }

        for (int i=1 ;i <=daynum[month];i++){
            DayEntity d=new DayEntity();
            d.setData(true);
            d.setDay(String.valueOf(i));
            d.setSelect(false);
            if (i==10||i==20){
                d.setSelect(true);
            }
            mDayList.add(d);
        }


    }

    private void initLastData(){
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        int lastWeek;
        int lastMonth;
        lastWeek =c.get(Calendar.DAY_OF_WEEK);

        lastMonth =c.get(Calendar.MONTH);
        Log.e("dandy","ee "+lastMonth);

        for (int i=1;i<=lastWeek-1;i++){
            DayEntity d =new DayEntity();
            d.setData(false);
            mLastDayList.add(d);
        }
        for (int i=1 ;i <=daynum[lastMonth];i++){
            DayEntity d=new DayEntity();
            d.setData(true);
            d.setDay(String.valueOf(i));
            d.setSelect(false);
            if (i==10||i==20){
                d.setSelect(true);
            }
            mLastDayList.add(d);
        }




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.add_img:
                    if (isCurrentMonth){

                    }else {
                        mDayList.clear();
                        mLastDayList.clear();
                        mAdapter.notifyDataSetChanged();
                        initData();
                        mAdapter.setNewData(mDayList);
                        isCurrentMonth=true;
                    }
                break;

            case R.id.minus_img:
                    if (isCurrentMonth){
                        mDayList.clear();
                        mLastDayList.clear();
                        mAdapter.notifyDataSetChanged();
                        initLastData();
                        mAdapter.setNewData(mLastDayList);
                        isCurrentMonth=false;
                    }
                break;
        }
    }
}
