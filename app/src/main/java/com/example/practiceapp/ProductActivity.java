package com.example.practiceapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import gameAdapter.GameAdapter;
import model.Game;

public class ProductActivity extends AppCompatActivity implements IActivity {
    private RecyclerView gameRecyclerView;
    private RecyclerView.Adapter recyclerViewAdapter;
    private Game game;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_activity);
        setupUI();
        setupActions();
    }

    @Override
    public void setupUI() {
        gameRecyclerView = findViewById(R.id.gameRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                getApplicationContext(),RecyclerView.VERTICAL,false);
        gameRecyclerView.setLayoutManager(layoutManager);
        GameAdapter gameAdapter = new GameAdapter(this,game.generateFakeData());
        gameRecyclerView.setAdapter(gameAdapter);
    }

    @Override
    public void setupActions() {

    }
}
