package com.example.actionbarmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // MenuInflater로 메뉴를 생성하여 menu객체에 설정
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // MenuItem이 설정되면 호출
        switch ( item.getItemId() ) {
            case R.id.action_settings : return true;
            case R.id.item1 : return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
