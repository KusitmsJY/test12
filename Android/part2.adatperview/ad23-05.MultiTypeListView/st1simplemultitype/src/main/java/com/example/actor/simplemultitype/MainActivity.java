package com.example.actor.simplemultitype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private ListView listview1;
    private List<ModelItem> list;
    private AdapterItem adapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listview1 = findViewById(R.id.listview1);

        // 위젯 설정: 리스너 설정. 없음.

        // 데이터 만들기
        list = makeData();

        // adapter 만들기
        this.adapter = new AdapterItem(MainActivity.this, -1, list);

        // listview와 adapter 연결하기.
        listview1.setAdapter( this.adapter );
    }

    private List<ModelItem> makeData() {
        List<ModelItem> list = new ArrayList<>();
        list.add( new ModelItem( "title1 " ," desc1 "));
        list.add( new ModelItem( "name 1", getResources().getDrawable(R.drawable.sample_1)));
        list.add( new ModelItem( "name 2", getResources().getDrawable(R.drawable.sample_2)));
        list.add( new ModelItem( "title2 " ," desc2 "));
        list.add( new ModelItem( "name 3", getResources().getDrawable(R.drawable.sample_3)));
        list.add( new ModelItem( "title3 " ," desc3 "));
        list.add( new ModelItem( "name 4", getResources().getDrawable(R.drawable.sample_4)));
        list.add( new ModelItem( "name 5", getResources().getDrawable(R.drawable.sample_5)));
        list.add( new ModelItem( "title4 " ," desc4 "));
        list.add( new ModelItem( "title5 " ," desc5 "));

        return list;
    }
}
