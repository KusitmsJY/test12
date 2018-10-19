package com.example.lifecycle;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String LIFE_CYCLE = "csrpsd";

    // activity 실행시 사용되는 메서드. : C.S.R

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.util.Log.d( LIFE_CYCLE, "Create" );
    }

    @Override
    protected void onStart() {
        super.onStart();
        android.util.Log.d(LIFE_CYCLE, "Start");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        android.util.Log.d(LIFE_CYCLE, "RestoreInstance");
    }

    @Override
    protected void onResume() {
        super.onResume();
        android.util.Log.d(LIFE_CYCLE, "Resume");
    }

    // activity 종료시 사용되는 메서드. : P.S.D
    @Override
    protected void onPause() {
        super.onPause();
        android.util.Log.d(LIFE_CYCLE, "Pause");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        android.util.Log.d(LIFE_CYCLE, "SaveInstance");
    }

    @Override
    protected void onStop() {
        super.onStop();
        android.util.Log.d(LIFE_CYCLE, "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        android.util.Log.d(LIFE_CYCLE, "Destroy");
    }
}
