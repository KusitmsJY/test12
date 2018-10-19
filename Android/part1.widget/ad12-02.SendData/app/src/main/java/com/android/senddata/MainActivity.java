package com.android.senddata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 1. 위젯 선언
    private EditText edtName = null;
    private Button   btnSend = null;
    private TextView txtMsg  = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 2. 위젯 찾기
        edtName = findViewById( R.id.edtName );
        btnSend = findViewById( R.id.btnSend);
        txtMsg  = findViewById( R.id.txtMsg );

        // 3. 위젯 핸들러 설정
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 1. edtName 에서 값을 가져오기
                String tmp = edtName.getText().toString();

                // 2. txtMsg 에 값을 설정하기.
                txtMsg.setText( tmp );
            }
        });

    }
}
