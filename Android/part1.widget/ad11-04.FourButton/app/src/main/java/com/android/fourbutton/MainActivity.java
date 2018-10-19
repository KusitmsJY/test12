package com.android.fourbutton;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn1_onclick(View view) {

        // http://stackoverflow.com/questions/2201917/how-can-i-open-a-url-in-androids-web-browser-from-my-application
        // Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        // startActivity(browserIntent);
        String url = "http://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url) );
        startActivity(i);
    }

    public void btn2_onclick(View view) {
        // https://developer.android.com/reference/android/Manifest.permission.html#CALL_PRIVILEGED
        String url = "tel://119";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url) );
        startActivity(i);
    }

    public void btn3_onclick(View view) {
        // http://stackoverflow.com/questions/6016000/how-to-open-phones-gallery-through-code
        String url = "content://media/internal/images/media";
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(i);
    }

    public void btn4_onclick(View view) {
        // http://stackoverflow.com/questions/15393899/how-to-close-activity-and-go-back-to-previous-activity-in-android
        // finish();  or  onBackPressed();
        finish();
    }
}
