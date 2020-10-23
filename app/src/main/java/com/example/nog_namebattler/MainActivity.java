package com.example.nog_namebattler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // シーン移動・キャラ一覧
    public void moveCharBox()
    {
    	Intent intent = (new Intent(this, CharBoxActivity.class));
    	startActivity(intent);
    }

    // シーン移動・パーティ編成
    public void movePartyMake()
    {
    	Intent intent = (new Intent(this, PartyMakeActivity.class));
    	startActivity(intent);
    }


}