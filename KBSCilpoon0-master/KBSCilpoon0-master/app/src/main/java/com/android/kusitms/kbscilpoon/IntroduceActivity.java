package com.android.kusitms.kbscilpoon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class IntroduceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduce);
    }

    public void onSkipClicked(View view) {
        Intent intent = new Intent(IntroduceActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
