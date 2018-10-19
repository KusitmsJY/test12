package com.example.st1simplelistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    ListView listview1;
    EditText edittext1;
    Button   button1;

    List<String> list;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listview1  = findViewById(R.id.listview1);
        edittext1  = findViewById(R.id.edittext1);
        button1    = findViewById(R.id.button1 );

        // 위젯 리스너 설정
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = edittext1.getText().toString();

                if( !TextUtils.isEmpty(input) ){
                    // 데이터 추가.
                    list.add( input );

                    // ListView 새로고침 통보.
                    adapter.notifyDataSetChanged();

                    // ListView의 위치를 마지막 데이터로 이동.
                    listview1.smoothScrollToPosition( list.size() - 1 );
                }

            }
        });

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = (String)listview11.getItemAtPosition(position);
                Toast.makeText(MainActivity.this, "item : " + text, Toast.LENGTH_SHORT).show();
            }
        });

        // 4. 데이터 만들기
        String[] items = getResources().getStringArray(R.array.items );
        list = new ArrayList<String>(Arrays.asList(items)); // 배열을 리스트로 변환

        // 5. 어댑터 생성 & 6. 데이터 추가
        adapter = new ArrayAdapter<String>(MainActivity.this
        , android.R.layout.simple_list_item_1
        , list);

        // 7. 어댑터 연결
        listview1.setAdapter( adapter );

    }
}
