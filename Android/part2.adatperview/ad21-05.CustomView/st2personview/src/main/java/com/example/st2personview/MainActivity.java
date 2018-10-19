package com.example.st2personview;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private  PersonView personview1;
    private  PersonView personview2;
    private ImageView imageselect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        imageselect = findViewById(R.id.image_select);
        personview1 = findViewById(R.id.view_person1);
        personview2 = findViewById(R.id.view_person2);

        // 위젯 설정
        imageselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageselect.setVisibility(View.GONE);
            }
        });


        personview1.setOnImageClickListener(handler);
        personview2.setOnImageClickListener(handler);
        
        initData();
    }


    PersonView.OnImageClickListener handler = new PersonView.OnImageClickListener() {
        @Override
        public void onImageClick(PersonView view, PersonData person) {
            imageselect.setImageDrawable( person.getPhoto() );
            imageselect.setVisibility( View.VISIBLE );
        }
    };

    private void initData() {
        Drawable photo = ContextCompat.getDrawable(this, R.drawable.sample_5);
        PersonData p = new PersonData("ysi", 42, photo);
        personview1.setModelPerson(p);
    }
}
