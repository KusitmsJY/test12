package com.android.datetime;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.DigitalClock;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private AnalogClock   aclock   = null;
    private DigitalClock  dclock   = null;
    private Chronometer   chromo   = null;
    private TimePicker    tpicker1 = null;
    private TimePicker    tpicker2 = null;
    private DatePicker    dpicker1 = null;
    private DatePicker    dpicker2 = null;
    private CalendarView  calview  = null;
    private Button        btn1     = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aclock   = findViewById(R.id.clock1);
        dclock   = findViewById(R.id.clock2);
        chromo   = findViewById(R.id.chromo);
        tpicker1 = findViewById(R.id.timepicker1);
        tpicker2 = findViewById(R.id.timepicker2);
        dpicker1 = findViewById(R.id.datepicker1);
        dpicker2 = findViewById(R.id.datepicker1);
        calview  = findViewById(R.id.calendarview1);
        btn1     = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Date d = new Date();
                d.setTime(calview.getDate());

                String msg = "";
                msg += "aclock   =  " + aclock.toString() + " \n";
                msg += "dclock   =  " + dclock.getText() + " \n";
                msg += "chromo   =  " + chromo.getText() + " \n";
                msg += "tpicker1 =  " + tpicker1.getCurrentHour() + " : " + tpicker1.getCurrentMinute() + " \n";
                msg += "tpicker2 =  " + tpicker2.getCurrentHour() + " : " + tpicker2.getCurrentMinute() + " \n";
                msg += "dpicker1 =  " + dpicker1.getYear() + "-" + dpicker1.getMonth() + "-" + dpicker1.getDayOfMonth() + " \n";
                msg += "dpicker2 =  " + dpicker2.getYear() + "-" + dpicker2.getMonth() + "-" + dpicker2.getDayOfMonth() + " \n";
                msg += "calview  =  " + d;

                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });

        // Chromometer 중지 & 시작.
        chromo.stop(); // Chromometer중지
        chromo.setBase(SystemClock.elapsedRealtime()); // 0 시작 해서 경과된 시간.
        chromo.start(); // Chromometer 시작

        // tpicker1 에 시간 설정하기
        tpicker1.setCurrentHour( 13 );
        tpicker1.setCurrentMinute( 35 );

        // dpicker1 에 날짜 설정하기
        // 자바에서 날짜를 처리하는 클래스
        //      java.util.Date 클래스
        //      java.util.Calendar 클래스
        java.util.Calendar c = Calendar.getInstance();
        //dpicker1.updateDate( c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH) );
        dpicker1.updateDate( 2017, 11, 13 );

        // calview 에 날짜 지정하기
        Date date = new Date( 114, 2, 18); // 1900/01/01 --> 2014/03/18
        calview.setDate( date.getTime() );
    }
}
