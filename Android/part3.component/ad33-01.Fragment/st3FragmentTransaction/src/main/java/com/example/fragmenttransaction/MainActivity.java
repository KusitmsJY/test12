package com.example.fragmenttransaction;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
                          implements FragmentTwo.OnMessageCallback {

    private static final String FRAGMENT_TAG_ONE = "fragone";
    private static final String FRAGMENT_TAG_TWO = "fragtwo";
    Button btn0, btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);

        ButtonListener blistener = new ButtonListener();
        btn0.setOnClickListener( blistener );
        btn1.setOnClickListener( blistener );
        btn2.setOnClickListener( blistener );
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId() ) {
                case R.id.btn_0:
                    Fragment old = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_ONE);

                    if( old == null ) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

                        FragmentOne f = new FragmentOne();
                        Bundle b = new Bundle();
                        b.putString(FragmentOne.KEY_INPUT, "bundle로 값 전달하기");
                        f.setArguments( b );

                        ft.replace(R.id.container, f, FRAGMENT_TAG_ONE  );
                        ft.commit();
                    }
                    break;

                case R.id.btn_1:
                    Fragment old2 = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG_TWO);

                    if( old2 == null ) {
                        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                        FragmentTwo f = FragmentTwo.newInstance("fragment two");
                        ft.replace(R.id.container, f, FRAGMENT_TAG_TWO  );
                        ft.commit();
                    }
                    break;

                case R.id.btn_2:

                    
                    break;
            }
        }
    }

    // 메서드 호출을 통한 값 전달: Fragment --> Activity
    public void update( String msg) {
        TextView fragmentReturn = findViewById(R.id.fragment_return);
        fragmentReturn.setText( "메서드 호출을 통한 값 전달 : \n" + msg );
    }

    // callback 호출을 통한 값 전달: Fragment --> Activity
    @Override
    public void displayMessage(String message) {
        TextView fragmentReturn = findViewById(R.id.fragment_return);
        fragmentReturn.setText( "callback 호출을 통한 값 전달 : \n" + message );
    }

}
