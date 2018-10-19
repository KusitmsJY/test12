package com.android.eventlistener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStructure;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    // 위젯 선언
    private Button button1 = null;
    private Button button2 = null;
    private Button button3 = null;
    private Button button4 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 찾기
        button1 = findViewById(R.id.button1 );
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText( getApplicationContext(), "무명 클래스 리스너", Toast.LENGTH_SHORT).show();
            }
        });

        //
        button3 = findViewById(R.id.button3);
        innerclass handler = new innerclass();
        button3.setOnClickListener( handler );

        //
        button4 = findViewById(R.id.button4);
        button4.setOnClickListener( handler );
    }

    public void inlineclick(View view) {
        Toast.makeText(getApplicationContext(), "인라인 리스너", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getApplicationContext(), "implements 리스너", Toast.LENGTH_SHORT).show();
    }

    private class innerclass implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            int id= view.getId(); // 클릭된 버튼 id. int 값.
            switch (  id  ) {
                case  R.id.button1:
                    break;
                case  R.id.button2:
                    break;
                case  R.id.button3:
                    Toast.makeText( getApplicationContext(),"내부 클래스 리스너", Toast.LENGTH_SHORT).show();
                    break;
                case  R.id.button4:
                    break;
            }

        }
    }
}
