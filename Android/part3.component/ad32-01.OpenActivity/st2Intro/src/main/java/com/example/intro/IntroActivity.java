package com.example.intro;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        // 3초 동안 기다렸다 실행하라.
        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                android.content.Intent i = new android.content.Intent( IntroActivity.this, MainActivity.class);
                startActivity(i);
                IntroActivity.this.finish();
            }
        };
        h.postDelayed(  r , 3000);
    }
}
