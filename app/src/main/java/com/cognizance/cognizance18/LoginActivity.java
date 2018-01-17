package com.cognizance.cognizance18;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;

import android.widget.Toast;

import android.widget.TextView;


import com.cognizance.cognizance18.models.LoginResponse;
import com.cognizance.cognizance18.models.OauthUser;
import com.cognizance.cognizance18.models.User;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.Profile;
import com.facebook.ProfileTracker;
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
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Do not change this Activity's name
public class LoginActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 219;
    private static final String TYPE_GOOGLE = "google";
    private static final String TYPE_FB = "facebook";
    private static final String ROLE = "spp";

    private TextInputEditText emailEditText;
    private TextInputEditText phoneEditText;
    private AppCompatButton getStartedButton;
    private TextView signTextView;
    private final String BASE_URL = "https://api.cognizance.org.in/";
    private final String LOG_TAG = "LoginActivity";
    private SessionManager session;
    private GoogleSignInClient mGoogleSignInClient;
    private CallbackManager callbackManager;
    private LoginButton loginButton;
    private ProfileTracker mTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        session = new SessionManager(getApplicationContext());

        setContentView(R.layout.activity_login_layout);

        //initialising login views
        initViews();

        initVariables();

        // set click listeners
        setClickListeners();
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Check for existing Google Sign In account, if the user is already signed in
        // the GoogleSignInAccount will be non-null.
        GoogleSignInAccount account = GoogleSignIn.getLastSignedInAccount(this);
        boolean fbIsLoggedIn = AccessToken.getCurrentAccessToken() != null;
        boolean googleIsLoggedIn = account != null;
        if (session.isLoggedIn() || fbIsLoggedIn || googleIsLoggedIn) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void initVariables() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        callbackManager = CallbackManager.Factory.create();
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            // Signed in successfully, show authenticated UI.
            onGoogleSignIn(account);
        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(LOG_TAG, "googleSignInResult:failed code=" + e.getStatusCode());
            onGoogleSignIn(null);
        }
    }

    private void initViews() {
        emailEditText = findViewById(R.id.email_edit_text);
        phoneEditText = findViewById(R.id.mobile_number_edit_text);
        getStartedButton = findViewById(R.id.get_started_btn);
        signTextView = findViewById(R.id.sign_up_text);
        loginButton = findViewById(R.id.fb_login_button);
        loginButton.setReadPermissions("email");
    }

    private void setClickListeners() {
        getStartedButton.setOnClickListener(
                view -> {
                    String email = emailEditText.getText().toString();
                    String password = phoneEditText.getText().toString();
                    verifyFromAPI(email, password);
                });
        findViewById(R.id.google_login_button).setOnClickListener(
                (View v) -> {
                    switch (v.getId()) {
                        case R.id.google_login_button: {
                            Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                            startActivityForResult(signInIntent, RC_SIGN_IN);
                            break;
                        }
                    }
                }
        );
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

        signTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUpActivity1.class));
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
                profile.getProfilePictureUri(400, 500).toString()
        );
    }

    private void onGoogleSignIn(GoogleSignInAccount account) {
        if (account == null) {
            // No account exists or error
            Toast.makeText(this, "Google Login Error", Toast.LENGTH_SHORT).show();
        } else {
            // user is signed in
            String personName = account.getDisplayName();
            String personEmail = account.getEmail();
            String personId = account.getId();
            String personOauthToken = account.getIdToken();
            Uri personPhoto = account.getPhotoUrl();
            sendOauthRequest(
                    TYPE_GOOGLE,
                    ROLE,
                    personName,
                    personEmail,
                    personOauthToken,
                    "test",
                    personId,
                    personPhoto == null ? null : personPhoto.toString()
            );
        }
    }

    private void verifyFromAPI(String email, String password) {
        User user = new User(email, password);
        ApiInterface apiInterface = this.getInterfaceService();
        Call<LoginResponse> service = apiInterface.authenticate(user);
        service.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == 200) {
                    session.createLoginSession(response.body());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } else
                    Toast.makeText(LoginActivity.this, "Error : " + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });

    }

    private void sendOauthRequest(String type, String role, String name, String email, String accessToken, String dateTime, String id, String imageUrl) {
        OauthUser user = new OauthUser(type, role, name, email, accessToken,
                dateTime, id, imageUrl);
        ApiInterface apiInterface = this.getInterfaceService();
        Call<LoginResponse> service = apiInterface.oauthLogin(role, user);
        service.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == 200) {
                    session.createLoginSession(response.body());
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else
                    Toast.makeText(LoginActivity.this, "Error : " + response.code(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });


    }

    private ApiInterface getInterfaceService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }
}
