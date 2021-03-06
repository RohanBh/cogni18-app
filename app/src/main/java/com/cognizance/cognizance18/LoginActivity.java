package com.cognizance.cognizance18;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.cognizance.cognizance18.activities.IntroActivity;
import com.cognizance.cognizance18.activities.SignUpActivity;
import com.cognizance.cognizance18.interfaces.ApiInterface;
import com.cognizance.cognizance18.models.LoginResponse;
import com.cognizance.cognizance18.models.OauthUser;
import com.cognizance.cognizance18.utilities.ApiUtils;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Do not change this Activity's name
public class LoginActivity extends AppCompatActivity {

    private static final String LOG_TAG = "LoginActivity";

    private static final int RC_SIGN_IN = 219;
    private static final String TYPE_GOOGLE = "google";
    private static final String TYPE_FB = "facebook";
    private static final String ROLE = "spp";

    private AppCompatButton signUpWithEmailBtn;
    private TextView signInTextView;
    private SessionManager session;
    private GoogleSignInClient mGoogleSignInClient;
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private Button fbSignInButton;
    private ProfileTracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_layout);

        SharedPreferences sp = LoginActivity.this.getPreferences(Context.MODE_PRIVATE);
        Boolean isUserFirstTime = sp.getBoolean(getString(R.string.first), true);

        if (isUserFirstTime){
            startActivity(new Intent(LoginActivity.this, IntroActivity.class));

            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean(getString(R.string.first), false);
            editor.apply();
        }

        session = new SessionManager(getApplicationContext());
        initViews();
        initVariables();
        setClickListeners();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        //GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        //boolean fbIsLoggedIn = AccessToken.getCurrentAccessToken() != null;
        //boolean googleIsLoggedIn = account != null;
        if (session.isLoggedIn()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            mGoogleSignInClient.signOut();
            LoginManager.getInstance().logOut();
            AccessToken.setCurrentAccessToken(null);
        }
    }




    private void initVariables() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.server_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        callbackManager = CallbackManager.Factory.create();
    }



    private void initViews() {
        signInTextView = findViewById(R.id.sign_in_text);
        loginButton = findViewById(R.id.fb_login_button);
        loginButton.setReadPermissions("email");
        fbSignInButton = findViewById(R.id.fb_sign_btn);
        signUpWithEmailBtn = findViewById(R.id.sign_up_email_btn);
    }

    private void setClickListeners() {



        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                onFbSignIn();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {
                Log.e(LOG_TAG, "fbSignInResult:failed " + exception.getMessage());
            }
        });

        fbSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.performClick();
            }
        });

        signInTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LoginActivity.this, SignUpActivity.class);
                in.putExtra("mode", "SIGN_IN");
                startActivity(in);
            }
        });

        signUpWithEmailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class).putExtra("mode", "SIGN_UP"));
            }
        });
    }

    private void onFbSignIn() {
        GraphRequest request = GraphRequest.newMeRequest(
                AccessToken.getCurrentAccessToken(),
                (object, response) -> {
                    Profile profile = Profile.getCurrentProfile();
                    if (profile == null) {
                        mTracker = new ProfileTracker() {
                            @Override
                            protected void onCurrentProfileChanged(
                                    Profile oldProfile, Profile currentProfile) {
                                sendLoginParamsForFb(currentProfile, object);
                                mTracker.stopTracking();
                            }
                        };
                    } else {
                        sendLoginParamsForFb(profile, object);
                    }
                });
        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,name,email");
        request.setParameters(parameters);
        request.executeAsync();
    }

    private void sendLoginParamsForFb(Profile profile, JSONObject object) {
        String userEmail = null;
        try {
            userEmail = object.getString("email");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        sendOauthRequest(
                TYPE_FB,
                ROLE,
                profile.getName(),
                userEmail,
                AccessToken.getCurrentAccessToken().getToken(),
                "test",
                profile.getId(),
                profile.getProfilePictureUri(100, 100).toString()
        );
    }



    private void sendOauthRequest(String type, String role, String name,
                                  String email, String accessToken,
                                  String dateTime, String id, String imageUrl
    ) {
        OauthUser user = new OauthUser(type, role, name, email, accessToken,
                dateTime, id, imageUrl);
        ApiInterface apiInterface = ApiUtils.getInterfaceService();
        Call<LoginResponse> service = apiInterface.oauthLogin(role, user);
        service.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(@NonNull Call<LoginResponse> call,
                                   @NonNull Response<LoginResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    session.createLoginSession(response.body());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
//                    Log.e("ABC", response.body().getMessage());
                   // Toast.makeText(LoginActivity.this, "Error : " + response.body()
                          //          + " " + response.raw(),
                          //  Toast.LENGTH_SHORT).show();
                    }
            }

            @Override
            public void onFailure(@NonNull Call<LoginResponse> call, @NonNull Throwable t) {
             //   Toast.makeText(LoginActivity.this, "Request Failed" + t.getMessage(),
                    //    Toast.LENGTH_SHORT).show();
            }
        });
    }
}
