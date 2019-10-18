package com.coe.kku.ac.nursetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.coe.kku.ac.nursetalk.game.sentence.SentenceGameActivity;
import com.coe.kku.ac.nursetalk.game.vocab.VocabGameActivity;

public class GameMenuActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sentenceBtn, vocabBtn;
    private ImageButton backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        sentenceBtn = (Button) findViewById(R.id.sentence_game_btn);
        vocabBtn = (Button) findViewById(R.id.vocab_game_btn);
        backBtn = (ImageButton) findViewById(R.id.back_game_menu);

        sentenceBtn.setOnClickListener(this);
        vocabBtn.setOnClickListener(this);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GameMenuActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == sentenceBtn) {
            startActivity(new Intent(GameMenuActivity.this, SentenceGameActivity.class));
        } else if (view == vocabBtn) {
            startActivity(new Intent(GameMenuActivity.this, VocabGameActivity.class));
        }
    }
}
