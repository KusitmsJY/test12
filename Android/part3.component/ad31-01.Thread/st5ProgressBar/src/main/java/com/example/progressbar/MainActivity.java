package com.example.progressbar;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private ProgressBar progressBar1;
    private Button      btnInc      ;
    private Button      btnDec      ;
    private Button      button1     ;
    private TextView    tvSeek      ;
    private SeekBar     seekBar1    ;
    private TextView    tv1         ;
    private SeekBar     pb1         ;
    private TextView    tv2         ;
    private SeekBar     pb2         ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        progressBar1 = findViewById(R.id.progressBar1 );
        btnInc       = findViewById(R.id.btnInc       );
        btnDec       = findViewById(R.id.btnDec       );
        button1      = findViewById(R.id.button1      );
        seekBar1     = findViewById(R.id.seekBar1     );
        tvSeek       = findViewById(R.id.tvSeek       );
        tv1          = findViewById(R.id.tv1          );
        tv2          = findViewById(R.id.tv2          );
        pb1          = findViewById(R.id.pb1          );
        pb2          = findViewById(R.id.pb2          );

        // 위젯 설정. 리스너 포함.
        ButtonListener btnlistener = new ButtonListener();
        btnDec.setOnClickListener( btnlistener );
        btnInc.setOnClickListener( btnlistener );
        button1.setOnClickListener( btnlistener );

        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvSeek.setText( "진행률: " + progress + " %");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) { }
        });


    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId() ) {
                case R.id.btnInc:
                    progressBar1.incrementProgressBy( 10 );
                    break;
                case R.id.btnDec:
                    progressBar1.incrementProgressBy( -10 );
                    break;
                case R.id.button1:

                    Thread th1 = new Thread() {
                        @Override
                        public void run() {
                            for( int i=pb1.getProgress(); i<=pb1.getMax(); i=i+2) {

                                // work thread 에서 main thread로 넘길 메시지 작성.
                                Runnable message = new Runnable() {
                                    @Override
                                    public void run() {
                                        // 실행 코드
                                        pb1.setProgress( pb1.getProgress()  + 2 );
                                        tv1.setText( "1번 진행률 : " + pb1.getProgress() + " %");
                                    }
                                };

                                // main thread의 message queue 로 전송
                                MainActivity.this.runOnUiThread( message );

                                // delay 추가 : 100ms
                                SystemClock.sleep( 100 );
                            }
                        }
                    };
                    th1.start();


                    Thread th2 = new Thread() {
                        @Override
                        public void run() {
                            for( int i=pb2.getProgress(); i<=pb2.getMax(); i=i+1) {

                                // work thread 에서 main thread로 넘길 메시지 작성.
                                Runnable message = new Runnable() {
                                    @Override
                                    public void run() {
                                        // 실행 코드
                                        pb2.setProgress( pb2.getProgress()  + 1 );
                                        tv2.setText( "1번 진행률 : " + pb2.getProgress() + " %");
                                    }
                                };

                                // main thread의 message queue 로 전송
                                MainActivity.this.runOnUiThread( message );

                                // delay 추가 : 100ms
                                SystemClock.sleep( 100 );
                            }
                        }
                    };
                    th2.start();

                    button1.setClickable( false );
                    break;
            }
        }
    }
}
