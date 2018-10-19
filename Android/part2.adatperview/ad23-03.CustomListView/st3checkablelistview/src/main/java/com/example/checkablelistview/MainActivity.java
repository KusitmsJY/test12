package com.example.checkablelistview;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Adapter 선언
    private List<ModelPerson> lists = null;
    private AdapterPerson adapter = null;
    
    // 위젯 선언
    private ListView listView3 = null;

    EditText edit_input;
    Button btn_search;


    private int[] images = {
              R.drawable.sample_0
            , R.drawable.sample_1
            , R.drawable.sample_2
            , R.drawable.sample_3
            , R.drawable.sample_4
            , R.drawable.sample_5
            , R.drawable.sample_6
            , R.drawable.sample_7
    };
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기.
        listView3 = findViewById(R.id.listView3 );

        // 위젯(리스너) 설정. 생략

        //  header_list_item inflation
        View headerView = LayoutInflater.from( MainActivity.this)
                                        .inflate(R.layout.header_list_item, null);
        edit_input = headerView.findViewById(R.id.edit_input );
        btn_search = headerView.findViewById(R.id.btn_search );

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit_input.getText().toString();
                if( !text.isEmpty() ) {
                    Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 데이터 만들기
        lists = makeData();

        // adatper 생성.
        adapter = new AdapterPerson(MainActivity.this, R.layout.view_person,  lists );
        
        // adapter 리스너 설정

        // listview와 adatpe 연결
        listView3.setAdapter( adapter );

        // headerview 추가
        
        // footerview 추가
        
        // divier 추가

    }

    private List<ModelPerson> makeData() {
        List<ModelPerson> items = new ArrayList<>();

        Random r = new Random();
        ModelPerson person;
        for( int i=0; i<20; i++) {
            person = new ModelPerson();
            person.setImageCheck( false );
            person.setTextName( "name " + i );

            person.setTextAge( i + " "+ r.nextInt( 30) );
            Drawable d  = getResources().getDrawable(  images[  i % images.length  ] , null);
            person.setImagePhoto( d );

            items.add( person );
        }

        return items;
    }

}
