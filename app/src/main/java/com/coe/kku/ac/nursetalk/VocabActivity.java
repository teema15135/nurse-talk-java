package com.coe.kku.ac.nursetalk;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageButton;

public class VocabActivity extends AppCompatActivity implements View.OnClickListener {

    public final static int DISEASE = 0;
    public final static int SYMPTOM = 1;

    private ImageButton diseaseBtn, symptomBtn, backBtn;
    private Vocabulary vocabInstance;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);


        diseaseBtn = (ImageButton) findViewById(R.id.diseaseImgButton);
        symptomBtn = (ImageButton) findViewById(R.id.symptomImgButton);

        backBtn = (ImageButton) findViewById(R.id.backVocabMenuImgButton);

        diseaseBtn.setOnClickListener(this);
        symptomBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == diseaseBtn) {
            Intent i = new Intent(VocabActivity.this, VocabListActivity.class);
            i.putExtra("type", VocabListActivity.DISEASE);
            startActivity(i);
        } else if (view == symptomBtn) {
            Intent i = new Intent(VocabActivity.this, VocabListActivity.class);
            i.putExtra("type", VocabListActivity.SYMPTOM);
            startActivity(i);
        } else if (view == backBtn) {
            finish();
        }
    }
}
