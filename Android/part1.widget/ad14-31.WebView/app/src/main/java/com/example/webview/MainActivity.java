package com.example.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언 4개
    private WebView webview;
    private Button   btnGo  ;
    private Button   btnBack;
    private EditText edtUrl ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기 4개
        webview = findViewById(R.id.webview);
        btnGo   = findViewById(R.id.btnGo  );
        btnBack = findViewById(R.id.btnBack);
        edtUrl  = findViewById(R.id.edtUrl );

        // 위젯 설정
        // 버튼 설정.
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = edtUrl.getText().toString();
                webview.loadUrl( url );
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webview.goBack();
            }
        });

        // webview 설정
        // WebViewClient 구현 클래스를 이용한 줌인 기능 추가.
        // WebView.loadUrl() : 사이트 열기.
        // WebView.goBack()  : 뒤로 가기.
        webview.setWebViewClient( new MyWebClient());
        WebSettings settings = webview.getSettings();
        settings.setBuiltInZoomControls( true );

    }

    private class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }
}
