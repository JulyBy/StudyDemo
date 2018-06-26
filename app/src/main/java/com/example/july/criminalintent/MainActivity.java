package com.example.july.criminalintent;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.util.Calendar;

/**
 * Created by july on 18-6-26.
 */

public class MainActivity extends Activity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取日历的一个对象
        calendar = Calendar.getInstance();

        //获取年月日时分的信息

        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);

        setTitle(year+"-"+month+"-"+day+"-"+hour+":"+minute);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timePicker);

        //datePicker初始化
        datePicker.init(year, calendar.get(Calendar.MONTH), day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                setTitle(i+"-"+i1+1+"-"+i2);
            }
        });

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                setTitle(i+":"+i1);
            }
        });


        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                setTitle(i+"-"+i1+"-"+i2);

            }
        }, year, calendar.get(Calendar.MONTH), day).show();


        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                setTitle(i+"-"+i1);
            }
        }, hour, minute, true).show();




    }
}
