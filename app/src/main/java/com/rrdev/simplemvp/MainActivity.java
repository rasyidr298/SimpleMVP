package com.rrdev.simplemvp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginView {


    EditText etUsername, etPassword;
    ProgressBar progressbar;

    LoginPresenter loginPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        loginPresenter = new LoginPresenter(this, new LoginInteractor());
    }

    void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        progressbar = findViewById(R.id.progressbar);
    }

    public void loginMe(View view) {
        showProgressbar();

        loginPresenter.validateCredentials(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
    }

    @Override
    public void setUsernameError() {
        hideProgressbar();
        etUsername.setError("Username can't be empty!");

    }

    @Override
    public void setPasswordError() {

        hideProgressbar();
        etPassword.setError("password can't be empty!");
    }

    @Override
    public void onLoginSuccess(String username) {


        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);

    }

    @Override
    public void onLoginError() {
        hideProgressbar();

        Toast.makeText(this, "username or password doesn't match", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showProgressbar() {

        progressbar.setVisibility(View.VISIBLE);

    }

    @Override
    public void hideProgressbar() {

        progressbar.setVisibility(View.GONE);

    }
}