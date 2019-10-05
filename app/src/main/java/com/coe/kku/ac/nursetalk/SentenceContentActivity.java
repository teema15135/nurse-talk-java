package com.coe.kku.ac.nursetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class SentenceContentActivity extends AppCompatActivity {

    ImageButton back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_content);

        back = (ImageButton) findViewById(R.id.backSentenceContentButton);
        home = (ImageButton) findViewById(R.id.homeSentencecontentButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SentenceContentActivity.this, SentenceActivity.class));
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SentenceContentActivity.this, MainActivity.class));
            }
        });
    }
}
