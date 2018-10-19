package com.example.countdown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 위젯선언
    private TextView texview1;
    private Thread thread;
    private int count  = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯찾기
        texview1  = findViewById(R.id.textview1);

        thread = new Thread(){

            @Override
            public void run() {
                for( int i=20 ; i>=0;i-- ){
                    count = i;

                    // main thread로 보낼 메시지 작성.
                    // message 작성 방법
                    //  1. Runnable 를 이용하는 방법 : 실행 코드를 전달 때.
                    //  2. Handler  를 이용하는 방법 : 문자열이나 값을 전달 때.
                    Runnable message = new Runnable() {
                        @Override
                        public void run() {
                                texview1.setText( count + "" );
                        }
                    };

                    // work thread에서 main thread로 메시지 전송.
                    MainActivity.this.runOnUiThread( message );

                    // time delay : 1초 동안.
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start(); // work thread 작동 시작.

    }
}
