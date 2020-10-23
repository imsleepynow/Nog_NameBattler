package com.example.nog_namebattler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BattleStartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_start);
    }

    // ランダムに相手を設定

    // シーン移動・戦闘
    public void moveBattle()
    {
    	Intent intent = (new Intent(this, BattleActivity.class));
    	startActivity(intent);
    }

    // シーン移動・戦闘開始
    public void moveBattleStart()
    {
    	Intent intent = (new Intent(this, BattleStartActivity.class));
    	startActivity(intent);
    }

    // シーン移動・パーティ編成
    public void movePartyMake()
    {
    	Intent intent = (new Intent(this, PartyMakeActivity.class));
    	startActivity(intent);
    }


}