package com.example.nog_namebattler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BattleEndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_end);
    }

    // シーン移動・戦闘（相手チームそのまま）
    public void moveBattle()
    {
    	Intent intent = (new Intent(this, BattleActivity.class));
    	startActivity(intent);
    }

    // シーン移動・戦闘開始（相手チームを変える）
    public void moveBattleStart()
    {
    	Intent intent = (new Intent(this, BattleStartActivity.class));
    	startActivity(intent);
    }

    // シーン移動・タイトル
    public void moveMain()
    {
    	Intent intent = (new Intent(this, MainActivity.class));
    	startActivity(intent);
    }

}