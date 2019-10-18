package com.coe.kku.ac.nursetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ConversationActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "ConversationActivity";
    private ImageView bloodTest, painManagement, patientInterview, takeAVital, urineExam, howToTakeAMedicine;


    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        bloodTest = (ImageView) findViewById(R.id.bloodTestImageView);
        painManagement = (ImageView) findViewById(R.id.painManagementImageView);
        patientInterview = (ImageView) findViewById(R.id.patientInterviewImageView);
        takeAVital = (ImageView) findViewById(R.id.takeAVitalImageView);
        urineExam = (ImageView) findViewById(R.id.urineExamImageView);
        howToTakeAMedicine = (ImageView) findViewById(R.id.howToTakeAMedicineImageView);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            bloodTest.setClipToOutline(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            painManagement.setClipToOutline(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            patientInterview.setClipToOutline(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            takeAVital.setClipToOutline(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            urineExam.setClipToOutline(true);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            howToTakeAMedicine.setClipToOutline(true);
        }

        bloodTest.setOnClickListener(this);
        painManagement.setOnClickListener(this);
        patientInterview.setOnClickListener(this);
        takeAVital.setOnClickListener(this);
        urineExam.setOnClickListener(this);
        howToTakeAMedicine.setOnClickListener(this);

        back = (ImageButton) findViewById(R.id.backConversationMenuImgButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.short_click);     // play short click sound
                mp.start();

                startActivity(new Intent(ConversationActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == urineExam) {
            Intent i = new Intent(ConversationActivity.this, ConverAnimationActivity.class);
            i.putExtra("content", 1);
            startActivity(i);
        }
        else if (view == bloodTest) {
            Intent i = new Intent(ConversationActivity.this, ConverAnimationActivity.class);
            i.putExtra("content", 2);
            startActivity(i);
        }
        else if (view == patientInterview) {
            Intent i = new Intent(ConversationActivity.this, ConverAnimationActivity.class);
            i.putExtra("content", 3);
            startActivity(i);
        }
        else if (view == takeAVital) {
            Intent i = new Intent(ConversationActivity.this, ConverAnimationActivity.class);
            i.putExtra("content", 4);
            startActivity(i);
        }
        else if (view == painManagement) {
            Intent i = new Intent(ConversationActivity.this, ConverAnimationActivity.class);
            i.putExtra("content", 5);
            startActivity(i);
        }
        else if (view == howToTakeAMedicine) {
            Intent i = new Intent(ConversationActivity.this, ConverAnimationActivity.class);
            i.putExtra("content", 6);
            startActivity(i);
        }

        MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.short_click);     // play short click sound
        mp.start();
    }
}
