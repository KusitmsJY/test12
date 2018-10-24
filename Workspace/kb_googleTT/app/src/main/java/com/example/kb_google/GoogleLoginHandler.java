package com.example.kb_google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

  import com.paxnet.paxnetapp.util.Plog;




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

        // [END initialize_auth]
    }

    @Override
    public void checkLoginStatus() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            Plog.i("google onStart user.getUid() : " + currentUser.getUid());
        } else {
            Plog.i("google onStart user.getUid() is null ");
        }
    }

    @Override
    public void logoutSns() {
        //구글 로그아웃
        FirebaseAuth.getInstance().signOut();
    }

    @Override
    public void receiveLoginData(Intent intent) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(intent);
        if (result != null) {
            Log.d("GoogleLogin", "google  result : " + result);
            if (result.isSuccess()) {
                // 로그인 성공 했을때
                GoogleSignInAccount acct = result.getSignInAccount();

                String personName = acct.getDisplayName();
                String personEmail = acct.getEmail();
                String personId = acct.getId();
                String tokenKey = acct.getServerAuthCode();

                Log.e("GoogleLogin", "google  personName=" + personName);
                Log.e("GoogleLogin", "google  personEmail=" + personEmail);
                Log.e("GoogleLogin", "google  personId=" + personId);
                Log.e("GoogleLogin", "google  tokenKey=" + tokenKey);
                Log.e("GoogleLogin", "google  acct.getIdToken()=" + acct.getIdToken());


//                firebaseAuthWithGoogle(acct);

                mGoogleApiClient.disconnect();
            } else {
                // 로그인 실패 했을때
                Log.e("GoogleLogin", "google  login fail cause=" + result.getStatus().getStatusMessage());

                loginSnsResultListener.failSnsLogin();
            }
        }
    }

    /**
     * 구글 로그인 완료 후 유저정보
     *
     * @param acct
     */
    public void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(activity, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Plog.d("google signInWithCredential:onComplete: " + task.isSuccessful());
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                            Plog.d("google signInWithCredential:success user : " + user);
                            Plog.d("google signInWithCredential:success getUid : " + user.getUid());
                            Plog.d("google signInWithCredential:success getProviderId : " + user.getProviderId());
                            Plog.d("google signInWithCredential:success getToken : " + user.getToken(true));
                        } else {
                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            Plog.w("google signInWithCredential" + task.getException());
                        }
                    }
                });
    }

    public Intent getGoogleApiIntent() {
        return Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
    }
}




