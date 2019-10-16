package com.coe.kku.ac.nursetalk.game.vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.coe.kku.ac.nursetalk.R;

public class VocabGameCompleteActivity extends AppCompatActivity {

    private TextView vocabScoreTextView;
    private ImageView scoreMessageImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_game_complete);

        int score = getIntent().getIntExtra("score", -1);

        vocabScoreTextView = (TextView) findViewById(R.id.vocab_score_complete_text_view);
        scoreMessageImage = (ImageView) findViewById(R.id.score_message_image_view);

        vocabScoreTextView.setText(Integer.toString(score));

        if (score < 4) {  // Score 0 - 3
            scoreMessageImage.setImageResource(R.drawable.score_zero_to_three_message);
        } else if (score < 6) {  // Score 4 - 5
            scoreMessageImage.setImageResource(R.drawable.score_four_to_five_message);
        } else if (score < 9) {  // Score 6 - 8
            scoreMessageImage.setImageResource(R.drawable.score_six_to_eight_message);
        } else {  // Score 9 - 10
            scoreMessageImage.setImageResource(R.drawable.score_nine_to_ten_message);
        }
    }
}
