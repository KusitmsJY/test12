package com.example.viewpager;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private Button btn_one;
    private Button btn_two;
    private Button btn_three;
    private ViewPager pager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        btn_one = findViewById(R.id.btn_one);
        btn_two = findViewById(R.id.btn_two);
        btn_three = findViewById(R.id.btn_three);

        // 핸들러 설정
        ClickHandler handler = new ClickHandler();
        btn_one.setOnClickListener( handler );
        btn_two.setOnClickListener( handler );
        btn_three.setOnClickListener( handler );

        // pager 와 adpater 연결.
        pager = findViewById(R.id.pager);
        MyPagerAdater adapter = new MyPagerAdater( getApplicationContext() );
        pager.setAdapter( adapter  );
    }

    // 버튼 click 핸들러.
    private class ClickHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            switch ( v.getId() ) {
                case R.id.btn_one:
                    pager.setCurrentItem(0, true);
                    break;
                case R.id.btn_two:
                    pager.setCurrentItem(1, true);
                    break;
                case R.id.btn_three:
                    pager.setCurrentItem(2, true);
                    break;
            }
        }
    }

    // ViewPager adapter 만들기
    private class MyPagerAdater extends PagerAdapter {

        // 필드 선언.
        private LayoutInflater inflater;

        // 디폴트 생성자 : 반드시 Context 생성자의 매개변수로 받아야 한다.
        public MyPagerAdater(Context c) {
            this.inflater = LayoutInflater.from( c );
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(View container, int position) {
            View v = null;

            switch (position){
                case 0:
                    v = inflater.inflate(R.layout.inflate_one, null, false);
                    break;
                case 1:
                    v = inflater.inflate(R.layout.inflate_two, null, false);
                    break;
                case 2:
                    v = inflater.inflate(R.layout.inflate_three, null, false);
                    break;
            }
            pager.addView( v );

            return v;
        }

        @Override
        public void destroyItem(View container, int position, Object object) {
            pager.removeView( (View) object );
        }
    }
}
