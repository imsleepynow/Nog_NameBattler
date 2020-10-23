package com.example.nog_namebattler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PartyMakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party_make);
    }

    // シーン移動・タイトル
    public void moveMain()
    {
    	Intent intent = (new Intent(this, MainActivity.class));
    	startActivity(intent);
    }

    // シーン移動・バトル開始
    public void moveBattleStart()
    {
    	Intent intent = (new Intent(this, BattleStartActivity.class));
    	startActivity(intent);
    }

}