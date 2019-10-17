package com.coe.kku.ac.nursetalk.game.sentence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.coe.kku.ac.nursetalk.MainActivity;
import com.coe.kku.ac.nursetalk.R;
import com.coe.kku.ac.nursetalk.SentenceActivity;
import com.coe.kku.ac.nursetalk.game.vocab.VocabGame;

import java.util.Random;

public class SentenceGameActivity extends AppCompatActivity {

    private String[] keys;
    private String textAnswer;
    TextView textQuestion;
    Button submitBtn;
    Animation smallbigforth;
    private String choice;
    private SentenceGame sentenceGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_game);

        submitBtn = (Button) findViewById(R.id.sentence_game_sumbit_btn);

        smallbigforth = AnimationUtils.loadAnimation(this, R.anim.smallbigforth);

        sentenceGame = SentenceGame.getInstance();

        choice = sentenceGame.getcurrentChoice();
        textAnswer = sentenceGame.getCurrentAnswer();

        initKey(choice);

        keys = shuffleArray(keys);

        for (String key : keys) {
            addView(((LinearLayout) findViewById(R.id.layoutParent)), key, ((EditText) findViewById(R.id.editText)));
        }

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doValidate();
            }
        });
    }


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
        textQuestion.setText(sentenceGame.getcurrentHint());

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


    private void doValidate() {

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

    }

    private void initKey(String choice) {
        if (choice.equals("1")) {
            keys = new String[]{"I", "am", "a", "dog"};
        }
        else if (choice.equals("2")) {
            keys = new String[]{"I", "am", "a", "cat"};
        }
        else if (choice.equals("3")) {
            keys = new String[]{"I", "am", "a", "chompu"};
        }
        else if (choice.equals("4")) {
            keys = new String[]{"I", "am", "a", "teema"};
        }
        else if (choice.equals("5")) {
            keys = new String[]{"I", "am", "a", "tua poo"};
        }
        else if (choice.equals("6")) {
            keys = new String[]{"I", "am", "a", "tua ngok"};
        }
        else if (choice.equals("7")) {
            keys = new String[]{"I", "am", "a", "tua tom"};
        }
        else if (choice.equals("8")) {
            keys = new String[]{"I", "am", "a", "yhang yhang"};
        }
        else if (choice.equals("9")) {
            keys = new String[]{"I", "am", "a", "bird"};
        }
        else if (choice.equals("10")) {
            keys = new String[]{"I", "am", "a", "lion"};
        }
    }
}
