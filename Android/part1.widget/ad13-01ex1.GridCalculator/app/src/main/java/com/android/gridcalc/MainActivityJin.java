package com.android.gridcalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivityJin extends AppCompatActivity {

    //각각 위젯에 변수 선언

    EditText Edit1;
    Button[] buttons = new Button[19];
    Integer[] math = {R.id.BtnAdd, R.id.BtnSub, R.id.BtnMul, R.id.BtnDiv,
            R.id.BtnNum0, R.id.BtnNum1, R.id.BtnNum2, R.id.BtnNum3, R.id.BtnNum4,
            R.id.BtnNum5, R.id.BtnNum6, R.id.BtnNum7, R.id.BtnNum8, R.id.BtnNum9,
            R.id.BtnNumAC, R.id.btnNumC, R.id.결과값
    };
    Integer result;
    String num1 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Edit1 = findViewById(R.id.Edit1);
        Edit1.setInputType(0);

        Edit1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                // 자리수 검증
                Calc c = new Calc();
                String[] operators = {"+", "-", "*", "/"};
                int cnt = c.getLastIndex(num1, operators);
                if (num1.length() - cnt >= 17) {
                    int aaa = num1.length();
                    num1 = num1.substring(0, aaa - 1);
                    Edit1.setText(num1);
                    Toast.makeText(getApplicationContext(), "더 이상 입력 안됩니다.", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        //math관련 변수에 activity_main.xml 파일의 위젯 id를 대입
        //number관련 변수에 activity_main.xml 파일의 위젯 id 대입
        ButtonHandler hander = new ButtonHandler();
        for (int i = 0; i < math.length; i++) {
            buttons[i] = findViewById(math[i]);
            buttons[i].setOnClickListener(  hander  );
        }

    }



    private class ButtonHandler implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String exp =  Edit1.getText().toString();
            int leng = exp.length();
            String aaaa = exp.substring(leng - 1, leng);

            Button btn = (Button)v;

            String [] operators = {"+", "-", "\u00D7", "\u00F7"};
            Calc c = new Calc();

            if ( aaaa.equals("+") || aaaa.equals("-") || aaaa.equals("*") || aaaa.equals("/") ) {

                int cnt = c.getLastIndex(exp, operators);
                if( cnt == exp.length()-1){
                    //
                }
                else {
                    exp = Edit1.getText().toString() + aaaa;
                    Edit1.setText(exp);
                }
            }
            else if(aaaa.equals("C")){
                num1 = num1.substring(0, num1.length() - 1);
            } else if( aaaa.contains("AC")){
                num1 = "";
                Edit1.setText(num1);
            } else if( aaaa.equals("=")){
                if (num1 == null) {
                    Toast.makeText(getApplicationContext(), "숫자를 입력하시오", Toast.LENGTH_SHORT).show();
                } else {
                    String infixExp = num1;
                    System.out.println("중위 표기법 " + infixExp);

                    // 수식 검증
                    if (!c.bracketsBalance(infixExp)) {

                        // 오류 토스트로 출력.
                        return;
                    }

                    // 중위 표기법을 후위 표기법으로 바꾸기
                    String postfixExp = c.postfix(infixExp);

                    // 후위 표기법을 이용하여 수식 계산
                    Double result = c.result(postfixExp);

                    // 결과 출력
                    Edit1.setText(result.toString());
                }
            } else {

                // 숫자 버튼 클릭..
                if (Edit1.isFocused() == true) {
                    num1 = Edit1.getText().toString() + btn.getText().toString();
                    Edit1.setText(num1);
                } else {
                    Toast.makeText(getApplicationContext(), "먼저 선택하시오", Toast.LENGTH_SHORT).show();
                }
            }


        }
    }
}





