package com.example.countup;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private TextView textview1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        textview1 = findViewById(R.id.textview1 );

        new CounterTask().execute( 20 );
    }

    private class CounterTask extends AsyncTask<Integer, Integer, Boolean> {

        ProgressDialog pdlg = null;
        @Override
        protected void onPreExecute() {

            pdlg = new ProgressDialog(MainActivity.this);
            pdlg.setMessage("처리중");
            pdlg.getWindow().setGravity(Gravity.TOP);
            pdlg.show();
        }

        @Override
        protected Boolean doInBackground(Integer... integers) {

            int count = 0;
            for (int i = 0; i < integers[0]; i++) {
                publishProgress(count++, i);

                // 1초 delay
                android.os.SystemClock.sleep(1000);
            }

            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {

            // 텍스트뷰에 현재까지 카운트된 수를 출력한다.
            textview1.setText(values[0] + "");
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            if( pdlg != null ){
                pdlg.dismiss();
                pdlg = null;
            }
        }
    }

}
