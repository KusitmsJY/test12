package com.android.http.paginglistview;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.mylibrary.ImageHelper;
import com.android.mylibrary.model.ModelItem;
import com.android.mylibrary.HttpItem;

import java.util.ArrayList;
import java.util.List;

public class ListviewPagingActivity extends AppCompatActivity {

    private boolean calling  = false;

    AdapterCustom adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_paging);

        ListView lv = (ListView) findViewById(R.id.listView1);

        // 데이터 생성
        List<ModelItem> list  = new ArrayList<>();

        // 어댑터 객체 생성
        adapter = new AdapterCustom(this, R.layout.activity_listview_paging_item, R.id.dataItem01,  list );
        adapter.setInitData(0, 9);

        // 리스뷰와 어댑터 연결
        lv.setAdapter(adapter);

        // item click listener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

            }
        });

        // item long click listener
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

            public boolean onItemLongClick(AdapterView parent, View v, int posotion, long id) {
                return true;
            }
        });

        lv.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                // Sample calculation to determine if the last item is fully visible.
                final int lastItem = firstVisibleItem + visibleItemCount;    
                if(lastItem == totalItemCount) {
                    if( !calling ) {
                        calling = true;
                        //to avoid multiple calls for last item
                        new HttpLogin().execute(adapter.getCount(), adapter.getCount()  + 10);
                    }
                }
            }
        });

    }

    public class AdapterCustom extends ArrayAdapter<ModelItem> {

        public Context context            = null;
        private AdapterCustom.ViewHolder holder         = null;
        private LayoutInflater inflater  = null;

        private class ViewHolder {
            private ImageView mIcon;
            private TextView mText01;
            private TextView  mText02;
            private TextView  mText03;

        }

        public AdapterCustom(@NonNull Context context, @LayoutRes int resource, @IdRes int textViewResourceId, @NonNull List<ModelItem> objects) {
            super(context, resource, textViewResourceId, objects);
            this.context = context;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Log.i("getView", "started");

            View itemLayout = super.getView( position, convertView, parent );

            AdapterCustom.ViewHolder viewHolder = (AdapterCustom.ViewHolder)itemLayout.getTag();

            if( viewHolder == null ) {
                // find a widget
                viewHolder = new AdapterCustom.ViewHolder();
                viewHolder.mIcon   = (ImageView)itemLayout.findViewById(R.id.iconItem  );
                viewHolder.mText01 = (TextView )itemLayout.findViewById(R.id.dataItem01);
                viewHolder.mText02 = (TextView )itemLayout.findViewById(R.id.dataItem02);
                viewHolder.mText03 = (TextView )itemLayout.findViewById(R.id.dataItem03);

                itemLayout.setTag(viewHolder);
            }

            viewHolder.mIcon  .setImageBitmap(this.getItem(position).getIconItem());
            viewHolder.mText01.setText(this.getItem(position).getDataItem01() );
            viewHolder.mText02.setText(this.getItem(position).getDataItem02() );
            viewHolder.mText03.setText(this.getItem(position).getDataItem03() );

            return itemLayout;
        }

        /**
         *
         * @return
         */
        public void setInitData(int start, int end){

            List<ModelItem> list = makeData(start, end);
            this.addAll(list);
        }

        public List<ModelItem> makeData(int start, int end) {

            List<ModelItem> list = new ArrayList<>();
            for(int i =start ; i<=end; i++){

                ModelItem item = new ModelItem();
                Bitmap icon = BitmapFactory.decodeResource(context.getResources(), R.drawable.icon05);
                String image  = ImageHelper.convertFromBitmapToString(icon);
                //item.setIconItem(image);
                item.setDataItem01("추억의 테트리스 " + String.format("%3d", i ) );
                item.setDataItem02(getRandString());
                item.setDataItem03("900 원");

                list.add(item);
            }

            return list;
        }

        private String getRandString() {
            String str = "";

            for (int i = 1; i <= (int) (Math.random()*10000); i++) {
                //char ch = (char) ((Math.random() * 11172) + 0xAC00);
                str += String.valueOf( (char) ((Math.random() * 26) + 97) );
            }

            return str;
        }


        public void add(int index, ModelItem data){

            this.add(data);
            notifyDataSetChanged();
        }


        public void delete(int index){

            this.delete(index);
            notifyDataSetChanged();

        }

        public void clear(){

            this.clear();
            notifyDataSetChanged();

        }
    }

    public class HttpLogin extends AsyncTask<Integer, Integer, List<ModelItem>> {
        private ProgressDialog waitDlg = null;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            //서버에 요청 동안 Wating dialog를 보여주도록 한다.
            waitDlg = new ProgressDialog( ListviewPagingActivity.this );
            waitDlg.setMessage(" 버전 확인 중");
            waitDlg.show();
        }

        @Override
        protected List<ModelItem> doInBackground(Integer... params) {

            List<ModelItem> list = new HttpItem().itemlist(params[0], params[1]);
            return list;
        }

        @Override
        protected void onPostExecute(List<ModelItem> result) {
            super.onPostExecute(result);

            //서버 요청 완료 후 Waiting dialog를 제거한다.
            if( waitDlg != null ) {
                waitDlg.dismiss();
                waitDlg = null;
            }

            calling = false;

            adapter.addAll(result);
        }
    }

}
