package com.coe.kku.ac.nursetalk;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class VocabActivity extends AppCompatActivity implements View.OnClickListener {

    public final static int DISEASE = 0;
    public final static int SYMPTOM = 1;

    private Button thaiBtn, engBtn;
    private Vocabulary vocabInstance;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab);



    }

    private void fetchVocabList() {

    }

    private void speakThai(String message) {
        VocabTTS.getInstance(VocabActivity.this)
                .setLocale(new Locale("th"))
                .speak(message);
    }

    private void speakEnglish(String message) {
        VocabTTS.getInstance(VocabActivity.this)
                .setLocale(new Locale("en"))
                .speak(message);
    }

    @Override
    public void onClick(View view) {
        if (view == thaiBtn) {
            speakThai("ฉันกำลังพูดภาษาไทย");
        } else if (view == engBtn) {
            speakEnglish("I'm speaking English");
        }
    }
}
