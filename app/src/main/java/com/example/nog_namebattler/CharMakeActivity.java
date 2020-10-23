package com.example.nog_namebattler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CharMakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_make);
    }

    // シーン移動・キャラ詳細
    public void moveCharData()
    {
    	Intent intent = (new Intent(this, CharDataActivity.class));
    	startActivity(intent);
    }

    // シーン移動・作成完了
    public void moveCharMade()
    {
    	Intent intent = (new Intent(this, CharMadeActivity.class));
    	startActivity(intent);
    }

    // キャラ作成



}