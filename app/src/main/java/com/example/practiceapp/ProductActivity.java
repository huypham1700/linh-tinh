package com.example.practiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity implements IActivity {
    private TextView txtName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);
        setupUI();
        setupActions();
    }

    @Override
    public void setupUI() {
        Intent intent = getIntent();
        txtName = findViewById(R.id.name);
        String userName = intent.getStringExtra("user_name");
        txtName.setText("Hello "+ userName);
    }

    @Override
    public void setupActions() {

    }
}
