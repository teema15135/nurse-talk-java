package com.coe.kku.ac.nursetalk.game.sentence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coe.kku.ac.nursetalk.MainActivity;
import com.coe.kku.ac.nursetalk.R;
import com.coe.kku.ac.nursetalk.SentenceActivity;
import com.coe.kku.ac.nursetalk.game.vocab.VocabGame;

import com.coe.kku.ac.nursetalk.game.vocab.StageCompleteDialogFragment;
import com.coe.kku.ac.nursetalk.game.vocab.VocabGameActivity;
import com.coe.kku.ac.nursetalk.game.vocab.VocabGameCompleteActivity;
import com.google.android.flexbox.FlexboxLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SentenceGameActivity extends AppCompatActivity implements DialogInterface.OnDismissListener {

    private static final String TAG = "SentenceGameActivity";

    private int stageCounter = 0;
    private int scoreCounter = 0;

    private String[] keys;
    private String textAnswer;

    private TextView textQuestion;
    private TextView currentHintTextView;
    private TextView stageDisplay;
    private Button submitBtn;
    private ImageView backBtn, homeBtn;
//    private LinearLayout displayLN;
//    private LinearLayout choiceLN;

    private FlexboxLayout displayFL;
    private FlexboxLayout choiceFL;

    private Animation smallbigforth;

    private String choice;
    private SentenceGame sentenceGame;

    private int answerSize = 0;

    private ArrayList<String> currentAnswer;
    private ArrayList<String> currentDisplay;
    private ArrayList<String> currentChoice;

    private boolean firstStage = true;

    private final String SPACE = "      ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_game);

        backBtn = (ImageView) findViewById(R.id.sentence_game_back);
        homeBtn = (ImageView) findViewById(R.id.sentence_game_home);

        submitBtn = (Button) findViewById(R.id.sentence_game_sumbit_btn);
        currentHintTextView = (TextView) findViewById(R.id.sentence_game_hint_text_view);
        stageDisplay = (TextView) findViewById(R.id.sentence_game_stage_text_view);

//        displayLN = (LinearLayout) findViewById(R.id.sentence_game_display_linear_layout);
//        choiceLN = (LinearLayout) findViewById(R.id.sentence_game_choices_linear_layout);

        displayFL = (FlexboxLayout) findViewById(R.id.sentence_game_display_linear_layout);
        choiceFL = (FlexboxLayout) findViewById(R.id.sentence_game_choices_linear_layout);

        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        sentenceGame = SentenceGame.getInstance();

        setupNewStage();
        updateDisplayAndChoice();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChoiceEmpty())
                    doValidate();
                else
                    Toast.makeText(SentenceGameActivity.this, "Please complete the sentence first.", Toast.LENGTH_SHORT).show();
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SentenceGameActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
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

//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
//                displayTextView.setBackground(ContextCompat.getDrawable(SentenceGameActivity.this, R.drawable.selector_light_blue_round));
//            }
//            else {
//                displayTextView.setBackgroundColor(getResources().getColor(R.color.dark));
//            }

            if (!wordDisplay.equalsIgnoreCase(SPACE)) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    displayTextView.setBackground(ContextCompat.getDrawable(SentenceGameActivity.this, R.drawable.selector_light_blue_round));
                } else {
                    displayTextView.setBackgroundColor(getResources().getColor(R.color.dark));
                }
                displayTextView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
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
        StageCompleteDialogFragment fragment = StageCompleteDialogFragment.newInstance(completeAnswer);
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

        /*
        EditText editText = findViewById(R.id.editText);
        LinearLayout linearLayout = findViewById(R.id.layoutParent);

        if(editText.getText().toString().equals(textAnswer)) {
            Toast.makeText(SentenceGameActivity.this, "Correct", Toast.LENGTH_SHORT).show();
            editText.setText("");
        } else {
            Toast.makeText(SentenceGameActivity.this, "Wrong", Toast.LENGTH_SHORT).show();
            editText.setText("");
        }

        keys = shuffleArray(keys);
        linearLayout.removeAllViews();
        for (String key : keys) {
            addView(linearLayout, key, editText);
        }
        */
    }




    /*
    private String[] shuffleArray(String[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
        return ar;
    }
    */

    /*
    private void addView(LinearLayout viewParent, final String text, final EditText editText) {
        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );

        linearLayoutParams.rightMargin = 30;

        final TextView textView = new TextView(this);

        textView.setLayoutParams(linearLayoutParams);
        textView.setTextColor(this.getResources().getColor(R.color.dark));
        textView.setGravity(Gravity.CENTER);
        textView.setText(text);
        textView.setClickable(true);
        textView.setFocusable(true);
        textView.setTextSize(32);
        textView.setPadding(30,0,30,0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            textView.setBackground(ContextCompat.getDrawable(SentenceGameActivity.this, R.drawable.selector_light_blue_round));
        }

        Typeface typeface = ResourcesCompat.getFont(SentenceGameActivity.this, R.font.nunito_semibold);

        textQuestion = (TextView) findViewById(R.id.textQuestion);
        textQuestion.setText(sentenceGame.getCurrentHint());

//        textQuestion.setTypeface(typeface);
        editText.setTypeface(typeface);
        textView.setTypeface(typeface);

        textView.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                editText.setText(editText.getText().toString() + text + " ");
                textView.startAnimation(smallbigforth);
                textView.animate().alpha(0).setDuration(300);
            }
        });

        viewParent.addView(textView);

    }
    */


    private void initKey(String choice) {
        if (choice.equals("1")) {
            keys = new String[]{"I", "am", "a", "dog"};
        } else if (choice.equals("2")) {
            keys = new String[]{"I", "am", "a", "cat"};
        } else if (choice.equals("3")) {
            keys = new String[]{"I", "am", "a", "chompu"};
        } else if (choice.equals("4")) {
            keys = new String[]{"I", "am", "a", "teema"};
        } else if (choice.equals("5")) {
            keys = new String[]{"I", "am", "a", "tua poo"};
        } else if (choice.equals("6")) {
            keys = new String[]{"I", "am", "a", "tua ngok"};
        } else if (choice.equals("7")) {
            keys = new String[]{"I", "am", "a", "tua tom"};
        } else if (choice.equals("8")) {
            keys = new String[]{"I", "am", "a", "yhang yhang"};
        } else if (choice.equals("9")) {
            keys = new String[]{"I", "am", "a", "bird"};
        } else if (choice.equals("10")) {
            keys = new String[]{"I", "am", "a", "lion"};
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        Log.d(TAG, "onDismiss: ");
        setupNewStage();
    }
}
