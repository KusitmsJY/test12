package com.android.scrollview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class AutoIncrementScrollViewActivity extends AppCompatActivity {

    // 선언.
    private ScrollView scroll;
    private LinearLayout layout;

    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_increment_scroll_view);

        // 찾기.
        scroll = findViewById(R.id.scroll);
        layout = findViewById(R.id.layout);

        // 설정. ScrollView.OnScrollChangedListener 핸들러 작성.
        scroll.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {

                // 바닥이면
                if( layout.getHeight()  == scroll.getScrollY() + scroll.getHeight() ) {

                    for( int i=0; i<20; i++){

                        // step1.  LayoutParam 설정.  추가되는 버튼에 대한 LayoutParam 설정. 뷰영역 생성.
                        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.WRAP_CONTENT
                        );
                        // 마진 추가.
                        lp.setMargins(10, 10, 10, 10);


                        // step2. 버튼 생성.
                        Button btn = new Button( getApplicationContext() );
                        btn.setText("push me " + (++count) );
                        btn.setLayoutParams( lp ); // 생성된 버튼의 뷰영역 설정
                        btn.setBackgroundColor(Color.DKGRAY);

                        // step3. 생성된 버튼을 ScrollView의 LinearLayout 에 추가.
                        //        View.addView() 메서드 이용.
                        layout.addView( btn );
                    }
                }

            }
        });
    }
}
