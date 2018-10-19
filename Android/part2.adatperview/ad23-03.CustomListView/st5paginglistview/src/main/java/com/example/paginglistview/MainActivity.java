package com.example.paginglistview;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private ListView listView1;
    private List<ModelItem> lists;
    
    // Adapter 선언
    private AdapterItem adapter;
    private boolean flagGetData = false ;
    
    private int [] imageIds = {
              R.drawable.icon01
            , R.drawable.icon02
            , R.drawable.icon03
            , R.drawable.icon04
            , R.drawable.icon05
            , R.drawable.icon06
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        listView1 = findViewById(R.id.listView1);

        // 데이터 만들기
        lists = makeData(0, 20);

        // adapter 생성
        adapter = new AdapterItem(MainActivity.this, R.layout.customview_item, lists);

        // adapter 연결
        listView1.setAdapter( adapter );

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // AlertDialog 로 출력하기
                ModelItem item = lists.get( position );

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle( item.getDataItem01() );
                builder.setMessage( item.toString() );
                builder.setIcon( R.mipmap.ic_launcher );
                builder.setPositiveButton("확인", null);
                builder.show();
            }
        });

        // adapter scroll 리스너 설정
        listView1.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                if( totalItemCount == firstVisibleItem + visibleItemCount ){
                    // 바닥이다.
                    // 데이터 추가.
                    if( flagGetData == false ) {
                        flagGetData = true;

                        // // 1. 네트워크를 통해 데이터 요청
                        // List<ModelItem> items = null;
                        // items = makeData(lists.size(), 20);
                        // 
                        // // 2. 통신 완료 후 받은 데이터 작업
                        // lists.addAll( items );
                        // adapter.notifyDataSetChanged();
                        // flagGetData = false;

                        new HttpGetData().execute(lists.size(), 20);
                    }
                }
            }
        });
    }

    private class HttpGetData extends AsyncTask< Integer,  Integer, List<ModelItem>  > {

        private ProgressDialog pdlg  = null;

        // 요청 전.네트워크로 데이터 요청하기 직전에 실행되는 메서드
        // 사용자에게 요청을 알림 표시. ProgressDialog 표시..
        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // Wait 동안 ProgressDialog 보여 주기
            pdlg = new ProgressDialog(MainActivity.this);
            pdlg.setMessage("데이터 가져오는 중");
            pdlg.show();
        }

        // 요청 중.
        @Override
        protected List<ModelItem> doInBackground(Integer... integers) {
            List<ModelItem> items = null;

            try {
                // 4초간 기다리기...  sleep 주기
                //Thread.sleep(4000);
                java.util.concurrent.TimeUnit.SECONDS.sleep( 10 );

                // 1. 네트워크를 통해 데이터 요청
                items = makeData(integers[0], integers[1]);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return items;
        }

        // 요청 후. 네트워크로 데이터 요청이 완료되었을 때 실행되는 메서드
        // 사용자에게 요청을 알림 제거. ProgreesDialog 제거.
        @Override
        protected void onPostExecute(List<ModelItem> modelItems) {
            super.onPostExecute(modelItems);

            // ProgreesDialog 제거.
            if( pdlg !=null ){
                pdlg.dismiss();
                pdlg = null;
            }

            // 2. 통신 완료 후 받은 데이터 작업
            lists.addAll( modelItems );
            adapter.notifyDataSetChanged();

            flagGetData = false;
        }
    }

    private List<ModelItem> makeData(int start, int count) {

        List<ModelItem> newitems = new ArrayList<ModelItem>();

        Random r = new Random();
        for(int i=start; i<start + count; i++){
            ModelItem person = new ModelItem();
            person.setIconItem( getResources().getDrawable( imageIds[ i % imageIds.length ] , null) );
            person.setDataItem01( "name " + i );
            person.setDataItem03( 20 + r.nextInt( 3000) + "");
            person.setDataItem02( getRandString() );

            newitems.add( person );
        }

        return newitems;
    }

    // 임의의 문자열 만들기.
    private String getRandString() {
        String str = "";
        for (int i = 1; i <= (int) (Math.random()*10000); i++) {
            char ch = (char) ((Math.random() * 11172) + 0xAC00);
            str += String.valueOf( (char) ((Math.random() * 26) + 97) );
        }
        return str;
    }

}
