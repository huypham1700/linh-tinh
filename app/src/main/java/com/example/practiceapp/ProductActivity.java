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

    }

    @Override
    public void setupActions() {

    }
}
