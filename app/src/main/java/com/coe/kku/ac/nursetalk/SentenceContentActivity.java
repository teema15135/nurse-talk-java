package com.coe.kku.ac.nursetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.TextView;

public class SentenceContentActivity extends AppCompatActivity {

    ImageButton back, home;
    TextView titleText, contentText;

    private int content;

    public final static int GREETING = 1;
    public final static int PATIENT = 2;
    public final static int MEASURE = 3;
    public final static int INTRAVENOUSE = 4;
    public final static int BLOOD = 5;
    public final static int URINE = 6;
    public final static int PAIN = 7;
    public final static int DRESSING = 8;
    public final static int HEALTH = 9;
    public final static int MEDICINE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_content);

        this.content = getIntent().getIntExtra("content", 0);

        back = (ImageButton) findViewById(R.id.backSentenceContentButton);
        home = (ImageButton) findViewById(R.id.homeSentencecontentButton);
        titleText = (TextView) findViewById(R.id.sentence_title);
        contentText = (TextView) findViewById(R.id.sentence_content);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SentenceContentActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        setContent();
    }

    private void setContent() {
        switch (content) {
            default:
            case GREETING:
                titleText.setText(getString(R.string.sentence_greeting));
                contentText.setText(Html.fromHtml(Sentence.greetingContent));
                break;
            case PATIENT:
                titleText.setText(getString(R.string.sentence_patient_interview));
                contentText.setText(Html.fromHtml(Sentence.patientInterviewContent));
                break;
            case MEASURE:
                titleText.setText(getString(R.string.sentence_measuring));
                contentText.setText(Html.fromHtml(Sentence.measureContent));
                break;
            case INTRAVENOUSE:
                titleText.setText(getString(R.string.sentence_intravenous));
                contentText.setText(Html.fromHtml(Sentence.intravenousContent));
                break;
            case BLOOD:
                titleText.setText(getString(R.string.sentence_blood_test));
                contentText.setText(Html.fromHtml(Sentence.bloodTestContent));
                break;
            case URINE:
                titleText.setText(getString(R.string.sentence_urine));
                contentText.setText(Html.fromHtml(Sentence.urineContent));
                break;
            case PAIN:
                titleText.setText(getString(R.string.sentence_pain));
                contentText.setText(Html.fromHtml(Sentence.painContent));
                break;
            case DRESSING:
                titleText.setText(getString(R.string.sentence_dressing_would));
                contentText.setText(Html.fromHtml(Sentence.dressingContent));
                break;
            case HEALTH:
                titleText.setText(getString(R.string.sentence_health_education));
                contentText.setText(Html.fromHtml(Sentence.healthContent));
                break;
            case MEDICINE:
                titleText.setText(getString(R.string.sentence_take_a_medicine));
                contentText.setText(Html.fromHtml(Sentence.medicineContent));
                break;
        }
    }
}
