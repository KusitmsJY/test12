package com.example.bottomnavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageview;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_dog:
                    imageview.setImageDrawable( getResources().getDrawable(R.drawable.dog, null) );
                    return true;
                case R.id.navigation_cat:
                    imageview.setImageDrawable(  getResources().getDrawable(R.drawable.cat, null) );
                    return true;
                case R.id.navigation_horse:
                    imageview.setImageDrawable(  getResources().getDrawable(R.drawable.horse, null) );
                    return true;
                case R.id.navigation_rabbit:
                    imageview.setImageDrawable(  getResources().getDrawable(R.drawable.rabbit, null) );
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = (ImageView) findViewById(R.id.message);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
