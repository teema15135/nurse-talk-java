package com.coe.kku.ac.nursetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

        bloodTest.setClipToOutline(true);

        painManagement.setClipToOutline(true);
        patientInterview.setClipToOutline(true);
        takeAVital.setClipToOutline(true);
        urineExam.setClipToOutline(true);
        howToTakeAMedicine.setClipToOutline(true);

        bloodTest.setOnClickListener(this);
        painManagement.setOnClickListener(this);
        patientInterview.setOnClickListener(this);
        takeAVital.setOnClickListener(this);
        urineExam.setOnClickListener(this);
        howToTakeAMedicine.setOnClickListener(this);

        back = (ImageButton) findViewById(R.id.backConversaImgButton);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConversationActivity.this, MainActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == bloodTest) {
            Log.d(TAG, "onClick: Blood Test");
        } else if (view == painManagement) {
            Log.d(TAG, "onClick: Pain Manager");
        } else if (view == patientInterview) {
            Log.d(TAG, "onClick: Patient Interview");
        } else if (view == takeAVital) {
            Log.d(TAG, "onClick: Take a Vital sign");
        } else if (view == urineExam) {
            Log.d(TAG, "onClick: Urine Examination");
        } else if (view == howToTakeAMedicine) {
            Log.d(TAG, "onClick: How to take a medicine");
        }
    }
}
