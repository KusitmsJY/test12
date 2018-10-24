package com.example.kb_google;

import android.content.Intent;
import android.content.pm.SigningInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.common.SignInButton;

public class LoginActivity extends AppCompatActivity {
    GoogleLoginHandler googleLoginHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        googleLoginHandler = new GoogleLoginHandler();

        googleLoginHandler.initSnsInfo(this, this);
.
        SignInButton signInButton = (SignInButton) findViewById(R.id.btn_login_google);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signInIntent = googleLoginHandler.getGoogleApiIntent();
                startActivityForResult(signInIntent, 9001);
            }
        });


    }//end onCreate

}//end LoginActivity
