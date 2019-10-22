package com.coe.kku.ac.nursetalk.game.sentence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coe.kku.ac.nursetalk.MainActivity;
import com.coe.kku.ac.nursetalk.R;
import com.coe.kku.ac.nursetalk.VocabTTS;
import com.coe.kku.ac.nursetalk.game.vocab.StageWrongDialogFragment;

import com.coe.kku.ac.nursetalk.game.vocab.StageCompleteDialogFragment;
import com.coe.kku.ac.nursetalk.game.vocab.VocabGameCompleteActivity;
import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class SentenceGameActivity extends AppCompatActivity implements DialogInterface.OnDismissListener {

    private static final String TAG = "SentenceGameActivity";

    private int stageCounter = 0;
    private int scoreCounter = 0;

    private TextView currentHintTextView;
    private TextView stageDisplay;
    private Button submitBtn;
    private ImageView backBtn, homeBtn, playBtn;

    private FlexboxLayout displayFL;
    private FlexboxLayout choiceFL;

    private Animation smallbigforth;

    private String choice;
    private SentenceGame sentenceGame;

    private int answerSize = 0;

    private ArrayList<String> currentAnswer;
    private ArrayList<String> currentDisplay;
    private ArrayList<String> currentChoice;

    private final String SPACE = "      ";

    private MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_game);

        backBtn = (ImageView) findViewById(R.id.sentence_game_back);
        homeBtn = (ImageView) findViewById(R.id.sentence_game_home);
        playBtn = (ImageView) findViewById(R.id.sentence_game_play_sound);

        submitBtn = (Button) findViewById(R.id.sentence_game_sumbit_btn);
        currentHintTextView = (TextView) findViewById(R.id.sentence_game_hint_text_view);
        stageDisplay = (TextView) findViewById(R.id.sentence_game_stage_text_view);

        displayFL = (FlexboxLayout) findViewById(R.id.sentence_game_display_linear_layout);
        choiceFL = (FlexboxLayout) findViewById(R.id.sentence_game_choices_linear_layout);

        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        sentenceGame = SentenceGame.getInstance();

        mp = MediaPlayer.create(getApplicationContext(), R.raw.short_click);     // play short click sound

        setupNewStage();
        updateDisplayAndChoice();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                if (isChoiceEmpty())
                    doValidate();
                else
                    Toast.makeText(SentenceGameActivity.this, "Please complete the sentence first.", Toast.LENGTH_SHORT).show();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                finish();
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();

                Intent intent = new Intent(SentenceGameActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                speak();
            }
        });
    }

    private void setupNewStage() {

        stageCounter++;

        if (isGameComplete()) {
            gameComplete();
            return;
        }

        stageDisplay.setText("Stage " + stageCounter + " / 10");

        sentenceGame.nextStage();

        currentHintTextView.setText(sentenceGame.getCurrentHint());

        currentAnswer = sentenceGame.getCurrentAnswerArray();
        currentChoice = (ArrayList<String>) currentAnswer.clone();
        Collections.shuffle(currentChoice);

        currentDisplay = new ArrayList<>();
        answerSize = currentAnswer.size();
        for (int i = 0; i < answerSize; i++) {
            currentDisplay.add(SPACE);
        }

        updateDisplayAndChoice();

        speak();

    }

    private void updateDisplayAndChoice() {
        displayFL.removeAllViewsInLayout();
        choiceFL.removeAllViewsInLayout();

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 100);
        int margin = (int) getResources().getDimension(R.dimen.vocab_game_X_counter_margin);
        margin -= margin / 2;
        layoutParams.setMargins(margin, 0, margin, margin);

        Typeface typeface = ResourcesCompat.getFont(SentenceGameActivity.this, R.font.nunito_semibold);

        for (int i = 0; i < answerSize; i++) {
            final int currentI = i;
            String wordDisplay = currentDisplay.get(i);

            TextView displayTextView = new TextView(SentenceGameActivity.this);
            displayTextView.setLayoutParams(layoutParams);
            displayTextView.setPadding(20, 0, 20, 0);
            displayTextView.setTypeface(typeface);
            displayTextView.setTextSize(getResources().getDimension(R.dimen.sentence_game_font_size));
            displayTextView.setTextColor(this.getResources().getColor(R.color.dark));

            if (!wordDisplay.equalsIgnoreCase(SPACE)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    displayTextView.setBackground(ContextCompat.getDrawable(SentenceGameActivity.this, R.drawable.selector_light_blue_round));
                } else {
                    displayTextView.setBackgroundColor(getResources().getColor(R.color.dark));
                }
                displayTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mp.start();
                        removeWord(currentI);
                    }
                });
            }

            displayTextView.setText(wordDisplay);

            displayFL.addView(displayTextView);
        }

        int choiceSize = currentChoice.size();

        for (int i = 0; i < choiceSize; i++) {
            final int currentI = i;
            String wordChoice = currentChoice.get(i);

            TextView choiceTextView = new TextView(SentenceGameActivity.this);
            choiceTextView.setLayoutParams(layoutParams);

            choiceTextView.setPadding(20, 0, 20, 0);
            choiceTextView.setTextSize(getResources().getDimension(R.dimen.sentence_game_font_size));
            choiceTextView.setTextColor(this.getResources().getColor(R.color.dark));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                choiceTextView.setBackground(ContextCompat.getDrawable(SentenceGameActivity.this, R.drawable.shape_grey_round));
            } else {
                choiceTextView.setBackgroundColor(getResources().getColor(R.color.grey));
            }
            choiceTextView.setTypeface(typeface);

            if (!wordChoice.equalsIgnoreCase(SPACE)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    choiceTextView.setBackground(ContextCompat.getDrawable(SentenceGameActivity.this, R.drawable.selector_light_blue_round));
                } else {
                    choiceTextView.setBackgroundColor(getResources().getColor(R.color.dark_blue));
                }
                choiceTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mp.start();
                        selectWord(currentI);
                    }
                });
            }

            choiceTextView.setText(wordChoice);
            choiceFL.addView(choiceTextView);
        }
    }

    // Change the first "space" of displayArray to "word"
    // Change the "select" on choicesArray to "space"
    // and update view
    // the index is belong to currentChoice
    private void selectWord(int index) {
        for (int i = 0; i < answerSize; i++) {
            if (currentDisplay.get(i).equalsIgnoreCase(SPACE)) {  // the first space will be replace to chosen word
                currentDisplay.set(i, currentChoice.get(index));
                break;
            }
        }
        currentChoice.set(index, SPACE);

        Log.d(TAG, "selectWord: " + index + "\nDisplay: " + currentDisplay + "\nChoices: " + currentChoice);

        updateDisplayAndChoice();
    }

    // Change the "word" of displayArray to "space"
    // Change the first "space" of choicesArray to "word"
    // and update view
    // the index is belong to currentDisplay
    private void removeWord(int index) {
        for (int i = 0; i < answerSize; i++) {
            if (currentChoice.get(i).equalsIgnoreCase(SPACE)) {
                currentChoice.set(i, currentDisplay.get(index));
                break;
            }
        }
        currentDisplay.set(index, SPACE);

        Log.d(TAG, "selectWord: " + index + "\nDisplay: " + currentDisplay + "\nChoices: " + currentChoice);

        updateDisplayAndChoice();
    }

    private void stageComplete() {
        scoreCounter += 1;

        String completeAnswer = sentenceGame.getCurrentAnswer();
        StageCompleteDialogFragment fragment = StageCompleteDialogFragment.newInstance(completeAnswer);
        fragment.show(getSupportFragmentManager(), TAG);
    }

    private void stageFail() {
        scoreCounter += 0;

        String completeAnswer = sentenceGame.getCurrentAnswer();
        StageWrongDialogFragment fragment = StageWrongDialogFragment.newInstance(completeAnswer);
        fragment.show(getSupportFragmentManager(), TAG);
    }

    private boolean isGameComplete() {
        return stageCounter > 10;
    }

    private void gameComplete() {
        Intent intent = new Intent(SentenceGameActivity.this, VocabGameCompleteActivity.class);
        intent.putExtra("score", scoreCounter);
        startActivity(intent);
        finish();
    }

    private boolean isChoiceEmpty() {
        for (String str : currentChoice) {
            if (!str.equalsIgnoreCase(SPACE))
                return false;
        }
        return true;
    }

    private void doValidate() {

        boolean isComplete = true;

        for (int i = 0; i < answerSize; i++) {
            if (!currentDisplay.get(i).equalsIgnoreCase(currentAnswer.get(i)))
                isComplete = false;
        }

        if (isComplete) {
            stageComplete();
        } else
            stageFail();
    }

    private void speak() {
        String sentence = "";
        for( String word : currentAnswer)
            sentence += word + " ";

        VocabTTS.getInstance(SentenceGameActivity.this)
                .setLocale(new Locale("en"))
                .speak(sentence);
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        Log.d(TAG, "onDismiss: ");
        setupNewStage();
    }
}
