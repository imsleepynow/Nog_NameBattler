package com.example.nog_namebattler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CharBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_box);
    }

    // シーン移動・キャラ作成
    public void moveCharMake()
    {
    	Intent intent = (new Intent(this, CharMakeActivity.class));
    	startActivity(intent);
    }

    // シーン移動・キャラ詳細
    public void moveCharData()
    {
    	Intent intent = (new Intent(this, CharDataActivity.class));
    	startActivity(intent);
    }

    // シーン移動・タイトル
    public void moveMain()
    {
    	Intent intent = (new Intent(this, MainActivity.class));
    	startActivity(intent);
    }


}