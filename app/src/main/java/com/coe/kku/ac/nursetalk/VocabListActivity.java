package com.coe.kku.ac.nursetalk;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class VocabListActivity extends AppCompatActivity implements View.OnClickListener {

    public final static String TAG = "VocabListActivity";

    public final static int DISEASE = 0;
    public final static int SYMPTOM = 1;
    public final static int HEAD = 2;
    public final static int SKIN = 3;
    public final static int BONE = 4;
    public final static int THORAX = 5;
    public final static int ABDOMEN = 6;
    public final static int OTHER = 7;

    private int type;

    private ArrayList<Word> words;

    private TextView headerTextView;
    private ListView listView;
    private ImageButton backImgButton, homeImgButton;

    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_list);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.short_click);     // play short click sound

        this.type = getIntent().getIntExtra("type", 0);

        listView = (ListView) findViewById(R.id.vocabListView);
        headerTextView = (TextView) findViewById(R.id.headerVocabListTextView);

        backImgButton = (ImageButton) findViewById(R.id.backVocabListImgButton);
        homeImgButton = (ImageButton) findViewById(R.id.homeVocabListImgButton);

        backImgButton.setOnClickListener(this);
        homeImgButton.setOnClickListener(this);

        Vocabulary.loadVocab();
        fetchVocabList();
    }

    private void fetchVocabList() {
        switch (type) {
            default:
            case DISEASE:
                words = Vocabulary.getDiseaseWords();
                headerTextView.setText(getString(R.string.disease));
                Log.d(TAG, "fetchVocabList: disease selected");
                Log.d(TAG, "example " + words.get(0).getWord());
                break;
            case SYMPTOM:
                words = Vocabulary.getSymptomWords();
                headerTextView.setText(getString(R.string.symptom));
                Log.d(TAG, "fetchVocabList: symptom selected");
                Log.d(TAG, "example " + words.get(0).getWord());
            case HEAD:
                words = Vocabulary.getHeadNeckWords();
                headerTextView.setText(getString(R.string.head));
                Log.d(TAG, "fetchVocabList: head selected");
                Log.d(TAG, "example " + words.get(0).getWord());
                break;
            case SKIN:
                words = Vocabulary.getSkinWords();
                headerTextView.setText(getString(R.string.skin));
                Log.d(TAG, "fetchVocabList: skin selected");
                Log.d(TAG, "example " + words.get(0).getWord());
                break;
            case BONE:
                words = Vocabulary.getBoneWords();
                headerTextView.setText(getString(R.string.bone));
                Log.d(TAG, "fetchVocabList: bone selected");
                Log.d(TAG, "example " + words.get(0).getWord());
                break;
            case THORAX:
                words = Vocabulary.getThoraxLungsWords();
                headerTextView.setText(getString(R.string.thorax));
                Log.d(TAG, "fetchVocabList: thorax selected");
                Log.d(TAG, "example " + words.get(0).getWord());
                break;
            case ABDOMEN:
                words = Vocabulary.getAbdomenWords();
                headerTextView.setText(getString(R.string.abdomen));
                Log.d(TAG, "fetchVocabList: abdomen selected");
                Log.d(TAG, "example " + words.get(0).getWord());
                break;
            case OTHER:
                words = Vocabulary.getOtherWords();
                headerTextView.setText(getString(R.string.other));
                Log.d(TAG, "fetchVocabList: other selected");
                Log.d(TAG, "example " + words.get(0).getWord());
                break;
        }

        VocabListView adapter = new VocabListView(getApplicationContext(), words);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String positionClick = String.valueOf(i);
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == backImgButton) {
            finish();
        } else if (view == homeImgButton) {
            Intent intent = new Intent(VocabListActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        }
        mp.start();
    }
}
