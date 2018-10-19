package com.example.st1layoutinflater;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private Button btn1;
    private Button btn2;
    private Button btn3;
    LinearLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        btn1 = findViewById(R.id.btn);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent = findViewById(R.id.parent);
                LayoutInflater inflater = (LayoutInflater) getSystemService( LAYOUT_INFLATER_SERVICE);

                // inflater.inflate(R.layout.layout_sub1, parent)  == inflater.inflate(R.layout.layout_sub1, parent, false);
                inflater.inflate(R.layout.layout_sub1, parent, true);

                // checkbox 찾기
                CheckBox chk = parent.findViewById(R.id.checkBox);
                chk.setText("infation 완료");

                // 버튼 찾기
                Button button3 = parent.findViewById(R.id.button3);
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView textView = findViewById(R.id.textView);
                                 textView = parent.findViewById(R.id.textView);

                        textView.setText( "btn2 눌림" );
                    }
                });
            }
        });

        btn2 = findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent = findViewById(R.id.parent);
                LayoutInflater.from( MainActivity.this )
                              .inflate(R.layout.layout_sub1, parent, true);

                // checkbox 찾기
                CheckBox chk = parent.findViewById(R.id.checkBox);
                chk.setText("infation 완료");

                // 버튼 찾기
                Button button3 = parent.findViewById(R.id.button3);
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView textView = findViewById(R.id.textView);
                        textView = parent.findViewById(R.id.textView);

                        textView.setText( "btn2 눌림" );
                    }
                });

            }
        });

        btn3 = findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parent = findViewById(R.id.parent);
                View child = LayoutInflater.from( MainActivity.this )
                                           .inflate(R.layout.layout_sub1, null, false);
                parent.addView(child);

                // checkbox 찾기
                CheckBox chk = parent.findViewById(R.id.checkBox);
                chk.setText("btn3 infation 완료");

                // 버튼 찾기
                Button button3 = parent.findViewById(R.id.button3);
                button3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TextView textView = findViewById(R.id.textView);
                        textView = parent.findViewById(R.id.textView);

                        textView.setText( "btn3 눌림" );
                    }
                });

            }
        });
    }
}
