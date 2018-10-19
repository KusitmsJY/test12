package com.example.senddata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private EditText edtInput;
    private Button   btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        edtInput = findViewById(R.id.edt_input);
        btnStart = findViewById(R.id.btn_start);

        // 위젯 설정: 리스너 포함.
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = edtInput.getText().toString();

                android.content.Intent i = new android.content.Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("name", str);
                startActivity(i);
            }
        });
    }
}
