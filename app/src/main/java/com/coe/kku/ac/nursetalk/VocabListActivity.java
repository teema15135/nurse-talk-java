package com.coe.kku.ac.nursetalk;

import android.content.Intent;
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

    private int type;

    private TextView headerTextView;
    private ListView listView;
    private ImageButton backImgButton, homeImgButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_list);

        this.type = getIntent().getIntExtra("type", 0);

//        listView = (ListView) findViewById(R.id.vocabListView);
        headerTextView = (TextView) findViewById(R.id.headerVocabListTextView);

        backImgButton = (ImageButton) findViewById(R.id.backVocabListImgButton);
        homeImgButton = (ImageButton) findViewById(R.id.homeVocabListImgButton);

        backImgButton.setOnClickListener(this);
        homeImgButton.setOnClickListener(this);

        Vocabulary.loadVocab();
        fetchVocabList();
    }

    private void fetchVocabList() {
        ArrayList<Word> words;

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
        }

//        VocabListView adapter = new VocabListView(getApplicationContext(), words);
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String positionClick = String.valueOf(i);
//            }
//        });
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
    }
}
