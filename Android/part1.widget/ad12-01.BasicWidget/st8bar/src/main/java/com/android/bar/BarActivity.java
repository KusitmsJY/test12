package com.android.bar;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BarActivity extends Activity {

    private Button btnShow  = null;
    private Button btnClose = null;

    /**
     * 프로그레스바를 보여줄 때 사용할 상수
     */
    public static final int PROGRESS_DIALOG = 1001;

    /**
     * 프로그레스 대화상자 객체
     */
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        
        btnShow  = (Button)findViewById(R.id.btnShow );
        btnClose = (Button)findViewById(R.id.btnClose);
        
        btnShow .setOnClickListener(new ButtonClick());
        btnClose.setOnClickListener(new ButtonClick());  
        
        //
        ProgressBar pbar = (ProgressBar)findViewById(R.id.progressBar01);
        pbar.setIndeterminate(false);
        pbar.setMax(100);
        pbar.setProgress(80);


        // 아이콘 이미지 설정
        ImageView icon = (ImageView) findViewById(R.id.iconItem);
        Resources res = getResources();
        Drawable drawable = (Drawable) res.getDrawable(R.drawable.apple);
        icon.setImageDrawable(drawable);

        // 텍스트 설정
        TextView nameText = (TextView) findViewById(R.id.dataItem01);
        nameText.setText("사과");

        // 텍스트 설정
        TextView progressText = (TextView) findViewById(R.id.dataItem02);
        progressText.setText("80%");
        
        //
    }


    /**
     * 대화상자를 만들 수 있도록 자동으로 호출되는 메소드
     */
    public Dialog onCreateDialog(int id) {
        switch (id) {
            case (PROGRESS_DIALOG):
                progressDialog = new ProgressDialog(this);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.setMessage("데이터를 확인하는 중입니다.");

                return progressDialog;
        }

        return null;
    }

    class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch(v.getId() ) {
            case R.id.btnShow:

                showDialog(PROGRESS_DIALOG);

                break;
            case R.id.btnClose:

                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                break;
            default:
                break;           
            } 
        }
    }
}
