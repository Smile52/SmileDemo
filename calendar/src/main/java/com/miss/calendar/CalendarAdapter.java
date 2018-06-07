package com.miss.calendar;

import android.support.annotation.Nullable;
import android.util.Log;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

public class CalendarAdapter extends BaseQuickAdapter<DayEntity ,BaseViewHolder> {
    public CalendarAdapter( @Nullable List<DayEntity> data) {
        super(R.layout.item_day_layout, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DayEntity item) {
        Log.e("dandy","ee "+item.isData()+"  "+item.getDay());
        if (item.isData()){
            helper.setText(R.id.item_day, item.getDay());
            helper.setVisible(R.id.img, false);

        }else {
            helper.setText(R.id.item_day,"");
            helper.setVisible(R.id.img, false);
        }


        if (item.isSelect()){
            helper.setVisible(R.id.img, true);
        }
    }
}
