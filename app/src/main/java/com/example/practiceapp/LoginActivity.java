package com.example.practiceapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import sqlite.Database;
import validation.Validation;

public class LoginActivity extends AppCompatActivity implements IActivity {
    private static final String TAG_LOGIN_ACTIVITY = "MY_LOGIN_ACTIVITY";
    private EditText txtUsername;
    private EditText txtPassword;
    private Button buttonLogin;
    private Button buttonBack;
    private TextView txtNotify;
    private Validation validation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        setupUI();
        setupActions();
    }

    @Override
    public void setupUI() {
        Intent intent = getIntent();
        txtUsername=findViewById(R.id.loginUsername);
        txtPassword=findViewById(R.id.loginPassword);
        buttonLogin=findViewById(R.id.buttonLogin2);
        buttonBack=findViewById(R.id.buttonBack);
        txtNotify=findViewById(R.id.notify);
        String username = intent.getStringExtra("username");
        txtUsername.setText(username);
        String password = intent.getStringExtra("password");
        txtPassword.setText(password);
    }

    @Override
    public void setupActions() {
        txtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String username =s.toString();

                txtNotify.setText(
                        validation.isValidUsername(txtUsername.getText().toString())==false ?
                                "Invalid username" : "");
            }

            @Override public void afterTextChanged(Editable s) {}
        });
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation.existedUser(txtUsername.getText().toString(),
                        txtPassword.getText().toString(),LoginActivity.this)) {
                    Intent intent = new Intent(LoginActivity.this, ProductActivity.class);
                    intent.putExtra("user_name", txtUsername.getText().toString());
                    LoginActivity.this.startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this, "Cannot find user", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
