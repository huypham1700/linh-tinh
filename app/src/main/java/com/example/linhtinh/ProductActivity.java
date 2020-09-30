package com.example.linhtinh;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProductActivity extends AppCompatActivity implements IActivity {
    private TextView txtName;
    private Intent intent;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setupUI();
        setupActions();
    }

    @Override
    public void setupUI() {
        txtName = findViewById(R.id.name);

        txtName.setText(intent.getStringExtra("username"));
    }

    @Override
    public void setupActions() {

    }
}
