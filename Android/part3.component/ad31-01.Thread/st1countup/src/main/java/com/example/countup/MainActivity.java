package com.example.countup;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int      mCount = 0;
    TextView mCountTextView = null;
    private Handler handler = null;

    @Override
    protected void onCreate( Bundle savedInstanceState )  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCountTextView = (TextView) findViewById(R.id.textview1);

        // Handler
        // Thread
        // Runnable : 실행될 코드를 담는 객체(클래스)

        handler = new Handler();

        Thread countThread = new Thread(){
            @Override
            public void run() {

                // ① 10초 동안 1씩 카운트한다.
                for ( int i = 0 ; i < 10 ; i ++ )  {
                    mCount ++;

                    // ② 현재 카운트된 값을 로그로 출력한다.
                    Log.i("mainthread", "Current Count : " + mCount);
                    try {
                        // Runnable 생성:
                        Runnable message = new Runnable() {
                            @Override
                            public void run() {
                                // ③ 텍스트뷰에 현재까지 카운트된 수를 출력한다.
                                mCountTextView.setText( "Count : " + mCount );
                            }
                        };
                        // 메인스레드의 MessageQueue에 던진다.
                        //handler.post( message );
                        //mCountTextView.post( message );
                        MainActivity.this.runOnUiThread( message );

                        // 1초 동안 기다리기.
                        Thread.sleep( 1000 );
                    }
                    catch ( InterruptedException e ) { e.printStackTrace(); }
                }
            }
        };

        countThread.start(); // thread 시작.

    }
}

