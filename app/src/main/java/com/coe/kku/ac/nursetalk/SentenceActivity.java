package com.coe.kku.ac.nursetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SentenceActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton backBtn;
    Button greetingBtn, patientBtn, measureBtn, intravenouseBtn,
            bloodBtn, urineBtn, painBtn, dressingBtn, healthBtn, medicineBtn;

    MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.short_click);     // play short click sound

        backBtn = (ImageButton) findViewById(R.id.backSentenceImgButton);
        greetingBtn = (Button) findViewById(R.id.s_greeting_btn);
        patientBtn = (Button) findViewById(R.id.s_patient_interview_btn);
        measureBtn = (Button) findViewById(R.id.s_measure_btn);
        intravenouseBtn = (Button) findViewById(R.id.s_intravenous_btn);
        bloodBtn = (Button) findViewById(R.id.s_blood_btn);
        urineBtn = (Button) findViewById(R.id.s_urine_btn);
        painBtn = (Button) findViewById(R.id.s_pain_btn);
        dressingBtn = (Button) findViewById(R.id.s_dressing_btn);
        healthBtn = (Button) findViewById(R.id.s_health_btn);
        medicineBtn = (Button) findViewById(R.id.s_medicine_btn);

        greetingBtn.setOnClickListener(this);
        patientBtn.setOnClickListener(this);
        measureBtn.setOnClickListener(this);
        intravenouseBtn.setOnClickListener(this);
        bloodBtn.setOnClickListener(this);
        urineBtn.setOnClickListener(this);
        painBtn.setOnClickListener(this);
        dressingBtn.setOnClickListener(this);
        healthBtn.setOnClickListener(this);
        medicineBtn.setOnClickListener(this);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == greetingBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.GREETING);
            startActivity(i);
        }
        else if (view == patientBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.PATIENT);
            startActivity(i);
        }
        else if (view == measureBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.MEASURE);
            startActivity(i);
        }
        else if (view == intravenouseBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.INTRAVENOUSE);
            startActivity(i);
        }
        else if (view == bloodBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.BLOOD);
            startActivity(i);
        }
        else if (view == urineBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.URINE);
            startActivity(i);
        }
        else if (view == painBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.PAIN);
            startActivity(i);
        }
        else if (view == dressingBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.DRESSING);
            startActivity(i);
        }
        else if (view == healthBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.HEALTH);
            startActivity(i);
        }else if (view == medicineBtn) {
            Intent i = new Intent(SentenceActivity.this, SentenceContentActivity.class);
            i.putExtra("content", SentenceContentActivity.MEDICINE);
            startActivity(i);
        }

        mp.start();
    }
}
