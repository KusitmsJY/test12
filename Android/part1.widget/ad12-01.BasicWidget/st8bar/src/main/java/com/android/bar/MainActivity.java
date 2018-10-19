package com.android.bar;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private AsyncTask<Integer, String, Integer> mProgressDlg;

    private Button btnProgressBar = null;
    private Button btnProgressWheel = null;
    private Button btnProgressLoading = null;
    private Button btnProgressDialogCustom = null;
    private Button btnProgressDialogActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        btnProgressBar = (Button)findViewById(R.id.btnProgressBar );
        btnProgressBar.setOnClickListener(new ButtonClick());

        btnProgressWheel = (Button)findViewById(R.id.btnProgressWheel);
        btnProgressWheel.setOnClickListener(new ButtonClick());

        btnProgressLoading = (Button)findViewById(R.id.btnProgressLoading);
        btnProgressLoading.setOnClickListener(new ButtonClick());

        btnProgressDialogActivity = (Button) findViewById(R.id.btnProgressDialogActivity);
        btnProgressDialogActivity.setOnClickListener(new ButtonClick());

        btnProgressDialogCustom = (Button) findViewById(R.id.btnProgressDialogCustom);
        btnProgressDialogCustom.setOnClickListener(new ButtonClick());
    }


    class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch(v.getId() ) {
            case R.id.btnProgressBar:
                intent = new Intent(getApplicationContext(), BarActivity.class);
                startActivity(intent);
                break;
            case R.id.btnProgressWheel:

                break;
            case R.id.btnProgressLoading:
                intent = new Intent(getApplicationContext(), LoadingActivity.class);
                startActivity(intent);
                break;
            case R.id.btnProgressDialogActivity:
                intent = new Intent(getApplicationContext(), ProgressDialogActivity.class);
                startActivity(intent);
                break;
            case R.id.btnProgressDialogCustom:
                mProgressDlg = new ProgressDialogCustom(MainActivity.this);
                mProgressDlg.execute(100);
                break;
            default:
                break;           
            } 
        }
    }
}
