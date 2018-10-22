package com.example.kb_google;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.view.animation.AccelerateInterpolator;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

public class GoogleLoginHandler {



    private Activity activity;
    private Context context;

    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;


    @Override
    public void initSnsInfo(Context context, Activity activity) {
        this.activity = activity;
        this.context = context;

        //FirebaseAuth 개체의 공유 인스턴스를 가져옵니다.
        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder
                (GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(LoginConst.GOOGLE_TOKEN)
                .requestEmail()
                .build();


        mGoogleApiClient = new GoogleApiClient.Builder(activity)
                .enableAutoManage((FragmentActivity) activity /* FragmentActivity */,
                        new GoogleApiClient.OnConnectionFailedListener() {
                            @Override
                            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                            }
                        } /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        // [END config_signin]

        // [START initialize_auth]
        mAuth = FirebaseAuth.getInstance();

        //
    }






}
