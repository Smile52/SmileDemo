package com.miss.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.othershe.calendarview.bean.DateBean;
import com.othershe.calendarview.listener.CalendarViewAdapter;
import com.othershe.calendarview.listener.OnMultiChooseListener;
import com.othershe.calendarview.weiget.CalendarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView mMonth;
    ImageView mMinus,mAdd;
    CalendarView calendarView;
    ContentLayout mLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calendarView = (CalendarView) findViewById(R.id.calendar);
        mMinus=findViewById(R.id.minus);
        mAdd=findViewById(R.id.add);
        mMinus.setOnClickListener(this);
        mAdd.setOnClickListener(this);
//日历init，年月日之间用点号隔开


        List<String> list=new ArrayList<>();
        list.add("2018.5.22");
        list.add("2018.5.25");
        list.add("2018.5.03");
        calendarView
                .setStartEndDate("2010.7", "2018.12")
                .setInitDate("2018.5")
                .setMultiDate(list)
                .init();



        calendarView.setOnMultiChooseListener(new OnMultiChooseListener() {
            @Override
            public void onMultiChoose(View view, DateBean dateBean, boolean b) {
                    Log.e("dandy","date "+dateBean.getTerm()+"  e"+b);
            }
        });




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.minus:
                Log.e("dandy","减");
                calendarView.lastMonth();
                break;
            case R.id.add:
                Log.e("dandy","加");
                calendarView.nextMonth();
                break;
        }
    }
}
