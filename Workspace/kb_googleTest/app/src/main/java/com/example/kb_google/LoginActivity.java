package com.example.kb_google;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.common.SignInButton;

public class LoginActivity extends AppCompatActivity {

    GoogleLoginHandler   googleLoginHanlder = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       googleLoginHanlder =new GoogleLoginHandler();
        googleLoginHanlder.initSnsinfo(this,this);

        SignInButton signInButton = (SignInButton)findViewById(R.id.login_btn);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = googleLoginHanlder.getGoogleApiIntent();
                startActivityForResult(signInIntent,9001);
            }
        });


    }//end onCreate

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data){

        if(requestCode==9001) {
            googleLoginHanlder.receisdfasfadf(data);
        }

        else if (){
            return;
        }
        else if(){

        }

        super.onActivityResult(requestCode,resultCode,data);

    }//end onActivityResult


}//end LoginActivity
