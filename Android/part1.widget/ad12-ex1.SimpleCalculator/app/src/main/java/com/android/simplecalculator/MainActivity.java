package com.android.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edit1 = null;
    private EditText edit2 = null;
    private Button   btnAdd = null;
    private Button   btnSub = null;
    private Button   btnMul = null;
    private Button   btnDiv = null;
    private Button   btnRem = null;
    private TextView textResult = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.BtnAdd);
        btnSub = findViewById(R.id.BtnSub);
        btnMul = findViewById(R.id.BtnMul);
        btnDiv = findViewById(R.id.BtnDiv);
        btnRem = findViewById(R.id.BtnRem);

        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);
        textResult = findViewById(R.id.textView);

        HandlerClass handler = new HandlerClass();

        btnAdd.setOnClickListener(handler);
        btnSub.setOnClickListener(handler);
        btnMul.setOnClickListener(handler);
        btnDiv.setOnClickListener(handler);
        btnRem.setOnClickListener(handler);
}

    private class HandlerClass implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            if ( edit1.getText().toString().trim().equals("") || edit2.getText().toString().trim().equals("") ) {
                Toast.makeText(getApplicationContext(), "값을 입력해주십시오.", Toast.LENGTH_SHORT).show();
                return;
            }

            Double num1 = Double.parseDouble(edit1.getText().toString().trim());
            Double num2 = Double.parseDouble(edit2.getText().toString().trim());
            Double result = null;

            switch (view.getId()) {
                case R.id.BtnAdd:
                    result = num1 + num2;
                    textResult.setText("계산 결과 : "+result.toString());
                    break;
                case R.id.BtnSub:
                    result = num1 - num2;
                    textResult.setText("계산 결과 : "+result.toString());
                    break;
                case R.id.BtnMul:
                    result = num1 * num2;
                    textResult.setText("계산 결과 : "+result.toString());
                    break;
                case R.id.BtnDiv:
                    if (  num2.equals(0.0) ) {
                        Toast.makeText(getApplicationContext(), "값을 다시 입력해주세요.", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        result = num1 / num2;
                        textResult.setText("계산 결과 : "+result.toString());
                        break;
                    }
                case R.id.BtnRem:
                    result = num1 % num2;
                    textResult.setText("계산 결과 : "+ result.toString());
            }
        }
    }
}
