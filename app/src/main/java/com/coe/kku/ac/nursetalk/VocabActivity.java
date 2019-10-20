package com.coe.kku.ac.nursetalk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;

public class VocabActivity extends AppCompatActivity implements View.OnClickListener {

    public final static int DISEASE = 0;
    public final static int SYMPTOM = 1;

    private ImageButton diseaseBtn, symptomBtn, backBtn;
    private Button headBtn, skinBtn, boneBtn, thoraxBtn, abdomenBtn, otherBtn;
    private LinearLayout subSymptomPanel;
    private Vocabulary vocabInstance;
    private int type;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.short_click);     // play short click sound

        diseaseBtn = (ImageButton) findViewById(R.id.diseaseImgButton);
        symptomBtn = (ImageButton) findViewById(R.id.symptomImgButton);

        headBtn = (Button) findViewById(R.id.head_and_neck_btn);
        skinBtn = (Button) findViewById(R.id.skin_btn);
        boneBtn = (Button) findViewById(R.id.bone_btn);
        thoraxBtn = (Button) findViewById(R.id.thorax_btn);
        abdomenBtn = (Button) findViewById(R.id.abdomen_btn);
        otherBtn = (Button) findViewById(R.id.other_btn);

        backBtn = (ImageButton) findViewById(R.id.backVocabMenuImgButton);

        subSymptomPanel = (LinearLayout) findViewById(R.id.sub_symptom_panel);

        diseaseBtn.setOnClickListener(this);
        symptomBtn.setOnClickListener(this);
        headBtn.setOnClickListener(this);
        skinBtn.setOnClickListener(this);
        boneBtn.setOnClickListener(this);
        thoraxBtn.setOnClickListener(this);
        abdomenBtn.setOnClickListener(this);
        otherBtn.setOnClickListener(this);
        backBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == diseaseBtn) {
            Intent i = new Intent(VocabActivity.this, VocabListActivity.class);
            i.putExtra("type", VocabListActivity.DISEASE);
            startActivity(i);
            subSymptomPanel.setVisibility(View.GONE);
        } else if (view == symptomBtn) {
            toggleSubSymptom();
        } else if (view == headBtn) {
            Intent i = new Intent(VocabActivity.this, VocabListActivity.class);
            i.putExtra("type", VocabListActivity.HEAD);
            startActivity(i);
        } else if (view == skinBtn) {
            Intent i = new Intent(VocabActivity.this, VocabListActivity.class);
            i.putExtra("type", VocabListActivity.SKIN);
            startActivity(i);
        } else if (view == boneBtn) {
            Intent i = new Intent(VocabActivity.this, VocabListActivity.class);
            i.putExtra("type", VocabListActivity.BONE);
            startActivity(i);
        } else if (view == thoraxBtn) {
            Intent i = new Intent(VocabActivity.this, VocabListActivity.class);
            i.putExtra("type", VocabListActivity.THORAX);
            startActivity(i);
        } else if (view == abdomenBtn) {
            Intent i = new Intent(VocabActivity.this, VocabListActivity.class);
            i.putExtra("type", VocabListActivity.ABDOMEN);
            startActivity(i);
        } else if (view == otherBtn) {
            Intent i = new Intent(VocabActivity.this, VocabListActivity.class);
            i.putExtra("type", VocabListActivity.OTHER);
            startActivity(i);
        } else if (view == backBtn) {
            subSymptomPanel.setVisibility(View.GONE);
            finish();
        }

        mp.start();
    }

    public void toggleSubSymptom() {
        if(subSymptomPanel.getVisibility()==View.GONE) {
            subSymptomPanel.setVisibility(View.VISIBLE);
        }
        else if(subSymptomPanel.getVisibility()==View.VISIBLE) {
            subSymptomPanel.setVisibility(View.GONE);
        }
    }
}
