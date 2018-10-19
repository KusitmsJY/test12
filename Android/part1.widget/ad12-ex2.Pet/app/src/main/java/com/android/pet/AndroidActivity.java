package com.android.pet;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class AndroidActivity extends AppCompatActivity {

    // 1.위젯 선언
    TextView text1, text2;
    Switch swhAgree;
    RadioGroup rGroup1;
    RadioButton rdoMar, rdoNou, rdoLol;
    Button btnFinish;
    ImageView imgAnd;
    private Button btnInit;
    LinearLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android);

        setTitle("애완동물 사진 보기");

        // 2.위젯 찾기
        text1 = (TextView) findViewById(R.id.txt_android_1);
        swhAgree = (Switch) findViewById(R.id.swh_android_agree);

        text2 = (TextView) findViewById(R.id.txt_android_2);
        rGroup1 = (RadioGroup) findViewById(R.id.rgroup_android_1);
        rdoMar = (RadioButton) findViewById(R.id.rdo_android_marshmallow);
        rdoNou = (RadioButton) findViewById(R.id.rdo_android_nougat);
        rdoLol = (RadioButton) findViewById(R.id.rdo_android_lollipop);

        btnInit   = (Button) findViewById(R.id.btn_android_init);
        btnFinish = (Button) findViewById(R.id.btn_android_finish);
        imgAnd = (ImageView) findViewById(R.id.img_android_1);

        layout2 = (LinearLayout) findViewById(R.id.layout_android_2);


        // 3.핸들러 설정
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                finish();
            }
        });
        btnInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swhAgree.setChecked(false);
                layout2.setVisibility(View.INVISIBLE);
            }
        });
        swhAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( swhAgree.isChecked()){
                    layout2.setVisibility(View.VISIBLE);
                }
                else {
                    layout2.setVisibility(View.INVISIBLE);
                }
            }
        });

        rGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                switch (rGroup1.getCheckedRadioButtonId()) {
                    case R.id.rdo_android_marshmallow:
                        imgAnd.setImageResource(R.drawable.marshmallow);
                        break;
                    case R.id.rdo_android_nougat:
                        imgAnd.setImageResource(R.drawable.nougat);
                        break;
                    case R.id.rdo_android_lollipop:
                        imgAnd.setImageResource(R.drawable.lollipop);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
