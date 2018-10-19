package com.example.studentlistview;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import org.apache.commons.collections.CollectionUtils;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    private ListView             listview1;
    private AdapterStudent       adapterListview;
    private List<ModelStudent>   data;


    // 위젯 선언
    private Spinner  spinner         = null;

    private EditText edit_name       = null;
    private EditText edit_number     = null;
    private EditText edit_department = null;
    private EditText edit_item       = null;

    private Button   btn_add         = null;
    private Button   btn_search      = null;
    private Button   btn_sort        = null;
    private Button   btn_del_all     = null;
    private Button   btn_init        = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listview1  = findViewById(R.id.list_view);

        edit_name       = findViewById(R.id.edit_name       );
        edit_number     = findViewById(R.id.edit_number     );
        edit_department = findViewById(R.id.edit_department );
        edit_item       = findViewById(R.id.edit_item       );

        btn_add         = findViewById(R.id.btn_add         );
        btn_search      = findViewById(R.id.btn_search      );
        btn_sort        = findViewById(R.id.btn_sort        );
        btn_del_all     = findViewById(R.id.btn_del_all     );
        btn_init        = findViewById(R.id.btn_init        );

        // 1. 버튼 핸들러 설정
        ButtonHanlder buttonHandler = new ButtonHanlder();
        btn_add    .setOnClickListener( buttonHandler );
        btn_search .setOnClickListener( buttonHandler );
        btn_sort   .setOnClickListener( buttonHandler );
        btn_del_all.setOnClickListener( buttonHandler );
        btn_init   .setOnClickListener( buttonHandler );

        // 2. ListView 핸들러 설정
        ListViewHandler lvHanlder = new ListViewHandler();
        listview1.setOnItemLongClickListener( lvHanlder );
        listview1.setOnItemClickListener    ( lvHanlder );

        // 데이터 만들기
        data = new ArrayList<>();
        for(int i=0; i<10; i++){
            ModelStudent student  = new ModelStudent();
            student.setName("name " + i );
            student.setNumber("number " + i );
            student.setDepartment(i+"-"+i);
            data.add(student);
        }

        // adapterListview 만들기
        adapterListview = new AdapterStudent( MainActivity.this, R.layout.view_student, data );

        // listview와 adapterListview 연결.
        listview1.setAdapter(adapterListview);

        // 리스트뷰에 머리 아이템 추가
        View headerView = getLayoutInflater().inflate( R.layout.list_view_header, null);
        TextView headerTitle = (TextView)headerView.findViewById( R.id.header_text );
        headerTitle.setText( "리스트의 시작입니다." );
        listview1.addHeaderView( headerView, null, false );

        // 리스트뷰에 꼬리 아이템 추가
        View footerView = getLayoutInflater().inflate( R.layout.list_view_footer, null );
        TextView footerTitle = (TextView)footerView.findViewById( R.id.footer_text );
        footerTitle.setText( "로딩 중..." );
        listview1.addFooterView( footerView, null, false );

        // 리스트뷰에 구분선 추가
        listview1.setDivider( new ColorDrawable(Color.GRAY) );
        listview1.setDividerHeight( 3 );

        // 3. 스피너 설정
        // 3-1. Spinner 찾기
        // 3-2. Spinner 데이터 만들기
        // 3-3. Spinner 어댑터 생성
        // 3-4. Spinner에 어댑터 연결
        spinner = findViewById(R.id.spinner );
        String [] spinneritems = getResources().getStringArray(R.array.spinneritems);
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(MainActivity.this
                                                                        , android.R.layout.simple_spinner_item
                                                                        , spinneritems );
        spinner.setAdapter( adapterSpinner );
    }

    private class ButtonHanlder implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String searchitem  = "";
            String searchvalue = "";

            switch (v.getId() ){
                case R.id.btn_add      :
                    ModelStudent s = new ModelStudent();
                    s.setDepartment( edit_name      .getText().toString() );
                    s.setNumber    ( edit_number    .getText().toString() );
                    s.setName      ( edit_department.getText().toString() );

                    //
                    data.add( s );

                    // 데이터 변경 알림
                    adapterListview.notifyDataSetChanged();

                    // listview의 마지막 레코드로 이동.
                    listview1.smoothScrollToPosition( data.size()-1 + listview1.getHeaderViewsCount());

                    init();
                    
                    break;
                case R.id.btn_del_all  :
                    data.clear(); // 전체 삭제.

                    // 데이터 변경 알림
                    adapterListview.notifyDataSetChanged();
                    break;
                case R.id.btn_init     :
                    init();
                    break;
                case R.id.btn_search   :
                    // spinner에서 선택값 가져오기.
                    searchitem  = getFieldName( spinner.getSelectedItem().toString() );
                    searchvalue = edit_item.getText().toString() ;

                    ModelStudent.MyPredicate predicate = new ModelStudent.MyPredicate(searchitem, searchvalue);
                    List<ModelStudent> result = (List<ModelStudent>) CollectionUtils.select( data, predicate );
                    AdapterStudent aa = new AdapterStudent(MainActivity.this, R.layout.view_student, result);
                    listview1.setAdapter( aa );

                    break;
                case R.id.btn_sort     :
                    // spinner에서 선택값 가져오기.
                    searchitem  = getFieldName( spinner.getSelectedItem().toString() );
                    searchvalue = edit_item.getText().toString() ;

                    // RadioGroup에서 선택값 가져오기
                    RadioGroup rgpAscDesc = findViewById(R.id.rgpAscDesc)  ;
                    int ascdesc = rgpAscDesc.getCheckedRadioButtonId();
                    boolean mode = false;
                    switch (ascdesc){
                        case R.id.rdoAsc: mode = false; break;
                        case R.id.rdoDesc: mode = true; break;
                        default: mode = false; break;
                    }

                    Comparator<ModelStudent> comparator = null;
                    if( searchitem.equals("name")  ) {
                        comparator = new ModelStudent.NameCompare( mode );
                    }
                    else if( searchitem.equals("number") ) {
                        comparator = new ModelStudent.NumberCompare( mode );
                    }
                    else if( searchitem.equals("department")  ) {
                        comparator = new ModelStudent.DeptCompare( mode );
                    }

                    Collections.sort(data, comparator);
                    adapterListview.notifyDataSetChanged();

                    break;
            }

        }

        private String getFieldName(String selectedItem) {

            if( selectedItem.equals("이름") ) {
                return "name";
            }
            else if( selectedItem.equals("학번") ) {
                return "number";
            }
            else if( selectedItem.equals("학과") ) {
                return "department";
            }
            else {
                return "";
            }
        }
    }

    private void init() {
        edit_name      .setText("");
        edit_number    .setText("");
        edit_department.setText("");
        edit_item      .setText("");

        listview1.setAdapter( adapterListview );
    }

    private class ListViewHandler implements ListView.OnItemClickListener
                                           , ListView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String msg = parent.getItemAtPosition(position).toString();
            Toast.makeText( getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

            // 확인,취소 대화상자 만들기
            AlertDialog.Builder  dlg = new AlertDialog.Builder( MainActivity.this );
            dlg.setTitle("삭제 확인");
            dlg.setMessage("정말로 삭제하시겠읍니까?");
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    data.remove( position - listview1.getHeaderViewsCount() );
                    adapterListview.notifyDataSetChanged();
                }
            });
            dlg.setNegativeButton("취소",null);
            dlg.show();

            return false;
        }
    }
}
