package com.example.backstack;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    //
    private Button btn_back  ;
    private Button btn_next  ;
    private Button btn_empty ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_back  = findViewById(R.id.btn_back );
        btn_next  = findViewById(R.id.btn_next );
        btn_empty = findViewById(R.id.btn_empty);

        ButtonListener  blistener = new ButtonListener();
        btn_back .setOnClickListener( blistener );
        btn_next .setOnClickListener( blistener );
        btn_empty.setOnClickListener( blistener );
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            int count = -1;
            FragmentManager fm = getSupportFragmentManager();

            switch ( v.getId() ) {
                case R.id.btn_back:
                    count = fm.getBackStackEntryCount();
                    if(count>0) {
                           fm.popBackStack();
                    }
                    break;
                case R.id.btn_next:
                    count = fm.getBackStackEntryCount();
                    if( count < 10 ) {
                        // MessageFramgment 인스턴스 생성
                        MessageFragment f = MessageFragment.newInstance( String.valueOf(count+1) );

                        // BackStack 에 추가.
                        fm.beginTransaction()
                          .replace(R.id.container, f)
                          .addToBackStack("entry"+count)
                          .commit();
                    }
                    break;
                case R.id.btn_empty:
                    fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    break;
            }

        }
    }
}
