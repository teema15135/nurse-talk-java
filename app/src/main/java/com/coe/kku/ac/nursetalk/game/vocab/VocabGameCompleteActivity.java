package com.coe.kku.ac.nursetalk.game.vocab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.coe.kku.ac.nursetalk.GameMenuActivity;
import com.coe.kku.ac.nursetalk.MainActivity;
import com.coe.kku.ac.nursetalk.R;

public class VocabGameCompleteActivity extends AppCompatActivity {

    private TextView vocabScoreTextView;
    private ImageView scoreMessageImage;
    private Button okBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_game_complete);

        int score = getIntent().getIntExtra("score", -1);

        vocabScoreTextView = (TextView) findViewById(R.id.vocab_score_complete_text_view);
        scoreMessageImage = (ImageView) findViewById(R.id.score_message_image_view);
        okBtn = (Button) findViewById(R.id.score_ok_btn);

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VocabGameCompleteActivity.this, GameMenuActivity.class));
            }
        });

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
