package com.miss.calendar;

public class DayEntity {
    private boolean isData;
    private String day;
    private boolean isSelect;

    public boolean isData() {
        return isData;
    }

    public void setData(boolean data) {
        isData = data;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
