package com.example.linhtinh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements IActivity{
    private static String TAG_MAIN_ACTIVITY ="MY_ACTIVITY";
    private Button buttonLogin;
    private Button buttonRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        setupActions();
    }

    @Override
    public void setupUI() {
        buttonLogin =findViewById(R.id.buttonLogin);
        buttonRegister = findViewById(R.id.buttonRegister);
    }

    @Override
    public void setupActions() {
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(intent);
                Log.d(TAG_MAIN_ACTIVITY,"Button Login is Pressed");
            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                MainActivity.this.startActivity(intent);
                Log.d(TAG_MAIN_ACTIVITY,"Button Register is Pressed");
            }
        });
    }
}