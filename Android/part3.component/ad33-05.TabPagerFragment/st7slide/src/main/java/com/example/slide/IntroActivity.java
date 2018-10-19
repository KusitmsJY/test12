package com.example.slide;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class IntroActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mLayoutDots;
    private Button mBtnSkip;
    private Button mBtnNext;

    private PrefManager mPref;

    private int[] mLayouts =  { R.layout.welcome_slide1
                              , R.layout.welcome_slide2
                              , R.layout.welcome_slide3
                              , R.layout.welcome_slide4 };

    private SlidePagerAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPref = new PrefManager( IntroActivity.this);

        // SharedPreferece를 이용하여 FirtstLaunch 값 체크
        if( mPref.isFirstTimeLaunch() ) {

            // intro 화면, 4개를 모두 본 경우에는 다시 IntroActivity가 출력되지 않게.
            launchMain();
        }

        setContentView(R.layout.activity_intro);

        // 위젯 찾기.
        mViewPager = findViewById(R.id.view_pager);
        mLayoutDots = findViewById(R.id.layout_dots);
        mBtnSkip   = findViewById(R.id.btn_skip);
        mBtnNext   = findViewById(R.id.btn_next);

        // 위젯 설정. 리스너, 어댑터
        mAdapter = new SlidePagerAdapter(  IntroActivity.this );
        mViewPager.setAdapter(  mAdapter );
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);

                //
                if(position == mLayouts.length -1 ) {
                    mBtnNext.setText(R.string.end);
                }
                else {
                    mBtnNext.setText(R.string.next);
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }


            @Override
            public void onPageScrollStateChanged(int state) { }
        });

        // 버튼 리스너 설정.
        ButtonListener blistener = new ButtonListener();
        mBtnSkip.setOnClickListener( blistener );
        mBtnNext.setOnClickListener( blistener );


        // 바닥에 있는 "....." 만들기
        addBottomDots( 0  );
    }

    private void addBottomDots(int currentPage ) {
        TextView[] dots = new TextView[mLayouts.length];

        int[] colorsActive   = getResources().getIntArray(R.array.array_dot_active  );
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        // LinearLayout 안의 모든 뷰를 삭제.
        mLayoutDots.removeAllViews();

        for( int i=0; i<mLayouts.length; i=i+1 ){
            dots[ i ] = new TextView(IntroActivity.this);
            dots[ i ].setText(  Html.fromHtml("&#8226;") );
            dots[ i ].setTextSize(35);
            dots[ i ].setTextColor( colorsInactive[ i ] );
            mLayoutDots.addView( dots[i] );
        }

        dots[ currentPage ].setTextColor( colorsActive[ currentPage ] );
    }

    private void launchMain() {
        mPref.setFirstTimeLaunch( true );

        android.content.Intent i = new android.content.Intent( IntroActivity.this, MainActivity.class);
        startActivity( i );

        finish();
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId() ){
                case R.id.btn_skip:
                    launchMain();
                    break;

                case R.id.btn_next:
                    int current = mViewPager.getCurrentItem() + 1;
                    if( current < mLayouts.length ){
                        mViewPager.setCurrentItem( current );
                    }
                    else {
                        launchMain();
                    }
                    break;

            }
        }
    }



    /**
     * View pager adapter
     */
    private class SlidePagerAdapter extends PagerAdapter {

        private final LayoutInflater inflater;

        public SlidePagerAdapter(Context context) {
            inflater = LayoutInflater.from(context);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = inflater.inflate( mLayouts[position], container, false);
            container.addView( view );
            return  view;
        }

        @Override
        public int getCount() {
            return mLayouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView( (View) object );
        }
    }
}
