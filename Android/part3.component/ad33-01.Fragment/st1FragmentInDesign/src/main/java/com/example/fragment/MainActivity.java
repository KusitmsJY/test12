package com.example.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn0, btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = findViewById(R.id.btn_image0);
        btn1 = findViewById(R.id.btn_image1);
        btn2 = findViewById(R.id.btn_image2);

        ButtonListener blistener = new ButtonListener();

        btn0.setOnClickListener( blistener );
        btn1.setOnClickListener( blistener );
        btn2.setOnClickListener( blistener );
    }

    private class ButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            // Fragment 찾기
            FragmentThr fragment = (FragmentThr) getSupportFragmentManager().findFragmentById(R.id.fragmentthr);

            switch (v.getId() ) {
                case R.id.btn_image0:
                    fragment.update( 0 );
                    break;

                case R.id.btn_image1:
                    fragment.update( 1 );
                    break;

                case R.id.btn_image2:
                    fragment.update( 2 );
                    break;
            }
        }
    }
}
