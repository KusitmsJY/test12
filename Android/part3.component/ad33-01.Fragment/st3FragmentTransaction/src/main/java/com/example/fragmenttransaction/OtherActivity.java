package com.example.fragmenttransaction;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OtherActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);

        editText =  findViewById(R.id.editText);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = editText.getText().toString();

                android.content.Intent i = new android.content.Intent();
                i.putExtra(Common.OTHER_RESULT, result);

                setResult(RESULT_OK,  i );

                finish();
            }
        });
    }
}
