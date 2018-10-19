package com.example.st1coloroptionview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    ColorOptionsView view1, view2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);

        ClickHandler handler = new ClickHandler();
        view1.setOnClickListener( handler );
        view2.setOnClickListener( handler );
    }

    private class ClickHandler implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ColorOptionsView txt = (ColorOptionsView) v;
            String text = txt.getText();
            Toast.makeText( MainActivity.this, text , Toast.LENGTH_LONG).show();
        }
    }

}