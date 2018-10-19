package com.example.nas_pc_067.st9scrollviewtest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class AutoincrementScrollViewActivity extends AppCompatActivity {
    private ScrollView scroll;
    private LinearLayout layout;
    //카운트 값
    private int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_increment_scroll);


        //찾기
        scroll = findViewById(R.id.scroll);
        layout = findViewById(R.id.layout);

        //설정 핸들러 작성
        scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                //바닥이면
                if (layout.getHeight() == scroll.getScrollY() + scroll.getHeight()) {
                    System.out.print(scroll.getScrollY());
                    System.out.print(scroll.getHeight());
                    for (int i = 0; i < 20; i++) {
                        //20개 생성? 뷰 영역
                        LinearLayout.LayoutParams Ip = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );

                        //마진추가
                        Ip.setMargins(10, 10, 10, 10);


                        //step2 버튼생성
                        Button btn = new Button(getApplicationContext());
                        btn.setText("push me" + (++count));
                        btn.setLayoutParams(Ip);
                        btn.setBackgroundColor(Color.DKGRAY);

                        //step3 생성된 버튼을 ScrolView의 LinearLayout에 추가
                        layout.addView(btn);


                    }
                }


            }
        });
    }
}
