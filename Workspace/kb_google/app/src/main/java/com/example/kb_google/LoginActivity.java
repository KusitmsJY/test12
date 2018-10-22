package com.example.kb_google;

import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.common.SignInButton;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        googleLoginHandler = new googleLoginHandler();

        googleLoginHandler.initSnsInfo(this,this);

        SignInButton button = (SignInButton)findViewById(R.id.login_btn);
        SignInButton.

    }//end onCreate

}//end LoginActivity
