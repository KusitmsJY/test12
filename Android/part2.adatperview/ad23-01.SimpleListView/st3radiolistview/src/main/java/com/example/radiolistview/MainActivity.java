package com.example.radiolistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언. 필드에
    private Button   btn_add, btn_modify, btn_delete;
    private ListView listview1;
    private EditText edittext1;
    private List<String> list;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        btn_add    = findViewById(R.id.btn_add    );
        btn_delete = findViewById(R.id.btn_delete );
        btn_modify = findViewById(R.id.btn_modify );
        listview1  = findViewById(R.id.listview1  );
        edittext1  = findViewById(R.id.edittext1  );

        // 위젯  설정(리스너)
        ClickHandler handler = new ClickHandler();
        btn_add   .setOnClickListener( handler );
        btn_modify.setOnClickListener( handler );
        btn_delete.setOnClickListener( handler );

        listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = list.get( position );
                edittext1.setText( text );
            }
        });

        // 데이터 만들기
        // array.xml에서 데이터 가져와 배열에 담기.
        String[] items = getResources().getStringArray( R.array.items );
        list = new ArrayList<String>( Arrays.asList( items ) ); // 배열을 리스트로 변환

        // adapter 생성 & adapter 데이터 추가
        adapter = new ArrayAdapter<String>(MainActivity.this
                                          , android.R.layout.simple_list_item_single_choice
                                          , list );

        // adapter 연결
        listview1.setAdapter( adapter );
    }

    private class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int position = -1;
            String temp = "";

            switch ( v.getId() ) {
                case R.id.btn_add: // 데이터 추가
                    temp = edittext1.getText().toString();
                    list.add( temp );
                    adapter.notifyDataSetChanged(); // ListView 새로고침.
                    listview1.smoothScrollToPosition( list.size() -1 ); // 마지막 레코드로 이동.

                    edittext1.setText("");  // 입력값 지우기
                    break;
                case R.id.btn_modify: // 데이터 수정
                    position = listview1.getCheckedItemPosition();  // 선택된 레코드의 인덱스 번호 가져오기.
                    temp = edittext1.getText().toString();
                    list.set( position, temp);
                    adapter.notifyDataSetChanged(); // ListView 새로고침.
                    listview1.smoothScrollToPosition( position ); // 수정하는 레코드로 이동.

                    edittext1.setText("");  // 입력값 지우기
                    break;
                case R.id.btn_delete: // 데이터 삭제.
                    position = listview1.getCheckedItemPosition();  // 선택된 레코드의 인덱스 번호 가져오기.
                    list.remove( position );
                    adapter.notifyDataSetChanged(); // ListView 새로고침.
                    listview1.clearChoices();  // radio 선택 해제
                    break;
            }

        }
    }
}
