package com.example.st3toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Title");                 //타이틀입니다.
        toolbar.setTitleTextColor(Color.WHITE);           //타이틀의 글자 색입니다.
        toolbar.setSubtitle("subtitle");                  //부제목.
        toolbar.setSubtitleTextColor(Color.MAGENTA);      //부제목의 글자 색입니다.
        //toolbar.setNavigationIcon(R.mipmap.ic_launcher);  //좌측 메뉴 아이콘 설정
        setSupportActionBar(toolbar);                     //툴바를 액션바로 사용.

        // Get the ActionBar here to configure the way it behaves.
        // Get a support ActionBar corresponding to this toolbar
        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                //finish();
                Toast.makeText(this, "clicked a home", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings:
                // User chose the "Settings" item, show the app settings UI...
                Toast.makeText(this, "clicked a settings", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.action_favorite:
                // User chose the "Favorite" action, mark the current item
                Toast.makeText(this, "clicked a favorite", Toast.LENGTH_SHORT).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }
}
