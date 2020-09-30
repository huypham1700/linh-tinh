package com.example.linhtinh;

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

import validation.Validation;

public class LoginActivity extends AppCompatActivity implements IActivity {
    private static final String TAG_LOGIN_ACTIVITY = "MY_LOGIN_ACTIVITY";
    private EditText txtUsername;
    private EditText txtPassword;
    private Button buttonLogin;
    private Button buttonBack;
    private TextView txtNotify;
    private Validation validation;
    private Intent intent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        setupUI();
        setupActions();
    }

    @Override
    public void setupUI() {
        txtUsername=findViewById(R.id.loginUsername);
        txtPassword=findViewById(R.id.loginPassword);
        buttonLogin=findViewById(R.id.buttonLogin2);
        buttonBack=findViewById(R.id.buttonBack);
        txtNotify=findViewById(R.id.notify);
        txtUsername.setText(intent.getStringExtra("username"));
        System.out.println(intent.getStringExtra("username") + "abcdxyz123");
        txtPassword.setText(intent.getStringExtra("password"));
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
                if (validation.existedUser(txtUsername.getText().toString(),txtPassword.getText().toString())) {
                    Intent intent = new Intent(LoginActivity.this, ProductActivity.class);
                    intent.putExtra("username", txtUsername.getText().toString());

                    LoginActivity.this.startActivity(intent);
                }
            }
        });

    }
}
