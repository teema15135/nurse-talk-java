package com.coe.kku.ac.nursetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button vocabBtn, sentenceBtn, conversationBtn,gameBtn;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.short_click);     // play short click sound

        vocabBtn = (Button)findViewById(R.id.vocab_btn);
        sentenceBtn = (Button) findViewById(R.id.sentence_btn);
        conversationBtn = (Button) findViewById(R.id.conver_btn);
        gameBtn = (Button) findViewById(R.id.games_btn);

        vocabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                startActivity(new Intent(MainActivity.this, VocabActivity.class));
            }
        });
        sentenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                startActivity(new Intent(MainActivity.this, SentenceActivity.class));
            }
        });
        conversationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                startActivity(new Intent(MainActivity.this, ConversationActivity.class));
            }
        });
        gameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                startActivity(new Intent(MainActivity.this, GameMenuActivity.class));
            }
        });

    }
}
