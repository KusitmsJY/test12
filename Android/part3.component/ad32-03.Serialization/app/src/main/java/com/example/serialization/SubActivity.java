package com.example.serialization;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        TextView text = findViewById(R.id.text);

        // 이전 activity에서 intent 받기
        Intent i = getIntent();

        String d1 = i.getStringExtra("data");
        if( d1 != null && !d1.isEmpty() ) {
            text.setText(text.getText() + " : " + d1);
        }

        int [] array = i.getIntArrayExtra("data" );
        if( array != null ) {
            for( int val : array )
                text.setText( text.getText() + " : " + val + " " );
        }

        ModelSerial s1 = (ModelSerial) i.getSerializableExtra("serial");
        if( s1 != null ) {
            text.setText(text.getText() + " : " + s1.toString());
        }

        ModelParcel p1 = i.getParcelableExtra("parcel" );
        if( p1 != null ) {
            text.setText( text.getText() + " : " + p1.toString() );
        }

        Bundle bundle = i.getBundleExtra("bundle");
        if( bundle != null ){
            int    idata = bundle.getInt("idata", 0 );
            String sdata = bundle.getString("sdata", "");

            text.setText( text.getText() + " : " + idata + " : " + sdata );
        }


    }
}
