package com.android.imageview;

import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txt1 = null;
    private TextView txt2 = null;
    private TextView txt3 = null;
    private Button   btn1 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);

        // 3. 위젯 핸들러 설정
        Button btn1 = null;
        btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 타이틀 변경.
                setTitle(R.string.app_name2);

                // txt1 size 변경.
                txt1.setTextSize(30);

                // txt2. color 변경
                txt2.setTextColor(Color.BLUE);

                // txt3. italic 변경
                txt3.setTypeface(txt3.getTypeface(), Typeface.BOLD | Typeface.ITALIC);
                txt3.setTypeface(txt3.getTypeface(), Typeface.BOLD_ITALIC);


            }
        });
    }
}
