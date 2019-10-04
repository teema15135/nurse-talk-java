package com.coe.kku.ac.nursetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    Button vocabBtn, sentenceBtn, conversationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vocabBtn = (Button)findViewById(R.id.vocab_btn);
        sentenceBtn = (Button) findViewById(R.id.sentence_btn);
        conversationBtn = (Button) findViewById(R.id.conver_btn);

        vocabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VocabActivity.class));
            }
        });
        sentenceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SentenceActivity.class));
            }
        });
        conversationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ConversationActivity.class));
            }
        });

    }
}
