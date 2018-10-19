package com.example.startactivity;

import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;  // 직접 타이핑

public class MainActivity extends AppCompatActivity {
    // 위젯 선언
    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        ButtonListener blistener = new ButtonListener();
        btn1.setOnClickListener( blistener );
        btn2.setOnClickListener( blistener );
        btn3.setOnClickListener( blistener );
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            Intent intent = null;

            switch (v.getId() ) {
                case R.id.btn1:
                    intent = new Intent( getApplicationContext(), SecondActivity.class );
                    intent.putExtra("val", "1");
                    startActivity( intent ); // 새창 띄우기
                    break;

                case R.id.btn2:
                    intent = new Intent( MainActivity.this, SecondActivity.class );
                    intent.putExtra("val", "2");
                    startActivity( intent ); // 새창 띄우기
                    break;

                case R.id.btn3:
                    // 실행할 패키지의 정보.
                    ComponentName comname = new ComponentName("com.example.startactivity"
                                                             ,"com.example.startactivity.SecondActivity");
                    intent = new Intent();
                    intent.setComponent( comname );
                    intent.putExtra("val", "3");
                    startActivity( intent ); // 새창 띄우기
                    break;
            }
        }
    }
}
