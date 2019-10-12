package com.coe.kku.ac.nursetalk.game.vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.coe.kku.ac.nursetalk.R;

public class VocabGameCompleteActivity extends AppCompatActivity {

    private TextView vocabScoreTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_game_complete);

        int score = getIntent().getIntExtra("score", -1);

        vocabScoreTextView = (TextView) findViewById(R.id.vocab_score_complete_text_view);

        vocabScoreTextView.setText(Integer.toString(score));
    }
}
