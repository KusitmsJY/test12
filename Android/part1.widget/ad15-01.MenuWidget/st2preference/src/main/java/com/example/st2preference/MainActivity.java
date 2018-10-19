package com.example.st2preference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // 위젯 선언
    private Button btnSave;
    private EditText edtNumber;
    private EditText edtText;
    private CheckBox chkSound;
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯 찾기
        btnSave = findViewById(R.id.btnSave);
        edtNumber = findViewById(R.id.edtNumber);
        edtText   = findViewById(R.id.edtText);
        chkSound  = findViewById(R.id.chkSound);

        // 위젯 설정
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = pref.edit();

                editor.putBoolean( "SOUND_SET" , chkSound.isChecked()  );
                editor.putInt( "TEXT_NUMBER"   , Integer.parseInt( edtNumber.getText().toString()));
                editor.putString( "TEXT_STRING", edtText.getText().toString() );
                editor.apply(); // 저장.
            }
        });

        // Preference 객체 얻기. 파일이름은 Settings.xml
        pref = getSharedPreferences("Settings", MODE_PRIVATE);
        Boolean chk = pref.getBoolean("SOUND_SET", false);
        Integer number = pref.getInt("TEXT_NUMBER", -1);
        String txt = pref.getString("TEXT_STRING", "");

        chkSound.setChecked( chk  );
        edtNumber.setText( number.toString() );
        edtText.setText( txt );
    }
}
