package com.example.linhtinh;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import sqlite.Database;
import validation.Validation;

public class RegisterActivity extends AppCompatActivity implements IActivity {
    private static final String TAG_REGISTER_ACTIVITY = "REGISTER";
    private EditText registerUsername;
    private EditText registerPassword;
    private Button buttonBack2;
    private Button buttonRegister2;
    private TextView registerErrorText;
    private Boolean isValidUsername;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_screen);
        setupUI();
        setupActions();
    }

    @Override
    public void setupUI() {
        registerUsername=findViewById(R.id.registerUsername);
        registerPassword=findViewById(R.id.registerPassword);
        registerErrorText=findViewById(R.id.registerNotify);
        buttonBack2=findViewById(R.id.buttonBack2);
        buttonRegister2=findViewById(R.id.buttonRegister2);

    }

    @Override
    public void setupActions() {
        buttonBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                RegisterActivity.this.startActivity(intent);
                Log.d(TAG_REGISTER_ACTIVITY,"Button back is pressed");
            }
        });
        registerUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String username =s.toString();
                isValidUsername= Validation.isValidUsername(registerUsername.getText().toString());
                registerErrorText.setText(isValidUsername==false ? "Invalid username" : "");
            }

            @Override public void afterTextChanged(Editable s) {}
        });
        buttonRegister2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(registerErrorText.equals("")){
                    new Database(RegisterActivity.this).insertUser(
                            registerUsername.getText().toString(),
                            registerPassword.getText().toString(),
                            "asdasjdkasd");
                }
                Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                intent.putExtra("username",registerUsername.getText().toString());
                intent.putExtra("password",registerPassword.getText().toString());
                Log.d(TAG_REGISTER_ACTIVITY,"Button register is pressed");
                RegisterActivity.this.startActivity(intent);
            }
        });
    }
}
