package com.rrdev.simplemvp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.rrdev.simplemvp.R;

public class WelcomeActivity extends AppCompatActivity {
    private TextView tvUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
        getText();
    }

    private void initView() {
        tvUsername = findViewById(R.id.tvUsername);
    }

    private void getText() {
        Intent intent = getIntent();
        String username = intent.getExtras().getString("username");
        tvUsername.setText(username);
    }
}
