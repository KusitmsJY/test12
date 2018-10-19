package com.android.button;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.android.button.HeightButtonActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 이벤트 핸들러 설정. 선언. 찾기. 설정.
        Button btn1 = null;
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 토스트로 메시지 출력
                // Toast.makeText(getApplicationContext(), "btn1", Toast.LENGTH_SHORT).show();
                // 새창 띄우기:
                Intent intent = new Intent( getApplicationContext(), RadioActivity.class);
                startActivity(intent);
            }
        });

        // 선언, 찾기, 설정
        Button btn2 = null;
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 새창 띄우기:
                Intent intent = new Intent( getApplicationContext(), WidthButtonActivity.class);
                startActivity(intent);
            }
        });

        // 선언, 찾기, 설정
        Button btn3 = null;
        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 새창 띄우기:
                Intent intent = new Intent( getApplicationContext(), HeightButtonActivity.class);
                startActivity(intent);
            }
        });

        // 선언, 찾기, 설정
        Button btn4 = null;
        btn4 = (Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 새창 띄우기:
                Intent intent = new Intent( getApplicationContext(), ColorButtonActivity.class);
                startActivity(intent);
            }
        });

        // 선언, 찾기, 설정
        Button btn5 = null;
        btn5 = (Button) findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 새창 띄우기:
                Intent intent = new Intent( getApplicationContext(), MarginActivity.class);
                startActivity(intent);
            }
        });

        // 선언, 찾기, 설정
        Button btn6 = null;
        btn6 = (Button) findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 새창 띄우기:
                Intent intent = new Intent( getApplicationContext(), PaddingActivity.class);
                startActivity(intent);
            }
        });

        // 선언, 찾기, 설정
        Button btn7 = null;
        btn7 = (Button) findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 새창 띄우기:
                Intent intent = new Intent( getApplicationContext(), VisibleActivity.class);
                startActivity(intent);
            }
        });
    }
}
