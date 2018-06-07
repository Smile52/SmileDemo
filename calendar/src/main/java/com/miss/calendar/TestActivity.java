package com.miss.calendar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TestActivity extends AppCompatActivity {
    private List<DayEntity> mDayList;

    private int[] daynum=new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
    private RecyclerView mContentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

    }


}
