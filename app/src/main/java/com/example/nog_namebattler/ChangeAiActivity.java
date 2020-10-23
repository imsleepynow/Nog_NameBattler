package com.example.nog_namebattler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ChangeAiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_ai);
    }

    // シーン移動・戦闘
    public void moveBattle()
    {
    	Intent intent = (new Intent(this, BattleActivity.class));
    	startActivity(intent);
    }


}