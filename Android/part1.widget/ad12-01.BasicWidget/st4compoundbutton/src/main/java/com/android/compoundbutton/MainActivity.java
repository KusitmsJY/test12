package com.android.compoundbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private RadioGroup  rgpDirection = null;
    private RadioGroup  rgpGravity   = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //찾기
        rgpDirection = findViewById(R.id.rgpDirection);
        rgpGravity = findViewById(R.id.rgpGravity);

        //설정
        rgpDirection.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if( checkedId == R.id.rdoH ){
                    rgpDirection.setOrientation(LinearLayout.HORIZONTAL);
                }
                else if( checkedId == R.id.rdoV ){
                    rgpDirection.setOrientation(LinearLayout.VERTICAL);
                }
            }
        });

        rgpGravity.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if( checkedId == R.id.rdoLeft ){
                    rgpGravity.setGravity(Gravity.LEFT);
                }

                else if( checkedId == R.id.rdoCenter ){
                    rgpGravity.setGravity(Gravity.CENTER);
                }

                else if( checkedId == R.id.rdoRight ){
                    rgpGravity.setGravity(Gravity.RIGHT);
                }
            }
        });
    }
}
