package com.android.reservationapp;

import android.os.SystemClock;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg ;
    RadioButton times,dates;
    Button start,finish;
    DatePicker dp;
    TimePicker tp;
    Chronometer cm ;
    TextView tv ;
    LinearLayout l1;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button)findViewById(R.id.choose);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        dp = (DatePicker)findViewById(R.id.datePicker);
        tp = (TimePicker)findViewById(R.id.timePicker);
        cm = (Chronometer)findViewById(R.id.chronometer);
        finish = (Button)findViewById(R.id.conf);
        l1=(LinearLayout)findViewById(R.id.linearLayout);
        tv = (TextView)findViewById(R.id.when);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setEnabled(false);
                finish.setEnabled(true);

                cm.stop();
                cm.setBase(SystemClock.elapsedRealtime());
                cm.start();

                rg.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);
                finish.setVisibility(View.VISIBLE);
                l1.setVisibility(View.VISIBLE);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.stop();

                start.setEnabled(true);
                finish.setEnabled(false);

                tv.setText(dp.getYear()+"년 "+(dp.getMonth()+1)+"월 "+dp.getDayOfMonth()+"일 "+tp.getCurrentHour()+"시 "+tp.getCurrentMinute()+"분 예약됨");
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.dates:
                        dp.setVisibility(View.VISIBLE);
                        tp.setVisibility(View.INVISIBLE);
                        break;
                    case R.id.times:
                        dp.setVisibility(View.INVISIBLE);
                        tp.setVisibility(View.VISIBLE);
                        break;
                }
            }
        });
    }
}
