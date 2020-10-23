package com.example.nog_namebattler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CharDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_char_data);
    }

    // キャラ削除
    // シーン移動・キャラ一覧
    public void moveCharBox()
    {
    	Intent intent = (new Intent(this, CharBoxActivity.class));
    	startActivity(intent);
    }


}