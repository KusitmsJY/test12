package com.android.scrollview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class AddButtonActivity extends AppCompatActivity {

    // 선언.
    private Button btnAdd;
    private LinearLayout scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_button);
        // 찾기
        btnAdd = findViewById(R.id.btnAdd);
        scroll = findViewById(R.id.scroll);

        // 설정
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // step1.  LayoutParam 설정.  추가되는 버튼에 대한 LayoutParam 설정. 뷰영역 생성.
                // step2. 버튼 생성과 뷰영역 설정
                // step3. 생성된 버튼을 LinearLayout 에 추가.  View.addView() 메서드 이용.

                // step1.  LayoutParam 설정.  추가되는 버튼에 대한 LayoutParam 설정. 뷰영역 생성.
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
                // 마진 추가.
                lp.setMargins(10, 10, 10, 10);


                // step2. 버튼 생성.
                Button btn = new Button(getApplicationContext());
                btn.setText(R.string.app_name);
                btn.setText("push me");
                btn.setLayoutParams(lp); // 생성된 버튼의 뷰영역 설정
                btn.setBackgroundColor(Color.DKGRAY);

                // step3. 생성된 버튼을 ScrollView의 LinearLayout 에 추가.
                //        View.addView() 메서드 이용.
                scroll.addView(btn);
            }
        });


    }
}
