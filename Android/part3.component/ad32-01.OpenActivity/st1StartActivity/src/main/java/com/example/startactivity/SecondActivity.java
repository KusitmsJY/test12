package com.example.startactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class SecondActivity extends AppCompatActivity {

    // 위젯 선언
    private Button btnFinish;
    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 위젯 찾기
        textview1 = findViewById(R.id.textview1 );
        btnFinish = findViewById(R.id.btn_finish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // SecondActivity 종료
            }
        });

        //
        Intent intent = getIntent();
        String val = intent.getStringExtra("val"); // val --> 1
        textview1.setText( val );

    }
}
