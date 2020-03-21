package com.rrdev.simplemvp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rrdev.simplemvp.Presenter.LoginPresenter;
import com.rrdev.simplemvp.Presenter.LoginPresenterImp;
import com.rrdev.simplemvp.Presenter.LoginView;
import com.rrdev.simplemvp.R;

public class MainActivity extends AppCompatActivity implements LoginView {

    private EditText etUsername, etPassword;
    private ProgressBar progressbar;
    private LoginPresenterImp loginPresenterImp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        hideProgressbar();
        loginPresenterImp = new LoginPresenterImp(this, new LoginPresenter());
    }

    void initViews() {
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        progressbar = findViewById(R.id.progressbar);
    }

    public void loginMe(View view) {
        showProgressbar();
        loginPresenterImp.validateCredentials(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
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
    public void onLoginSuccess(final String username) {
        Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
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