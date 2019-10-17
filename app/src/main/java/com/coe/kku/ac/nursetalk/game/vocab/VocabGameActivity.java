package com.coe.kku.ac.nursetalk.game.vocab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coe.kku.ac.nursetalk.MainActivity;
import com.coe.kku.ac.nursetalk.R;

public class VocabGameActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "VocabGameActivity";

    private int stageCounter = 1;
    private int scoreCounter = 0;
    private int incorrectCounter = 0;

    private Button q, w, e, r, t, y, u, i, o, p;
    private Button a, s, d, f, g, h, j, k, l;
    private Button z, x, c, v, b, n, m;

    private TextView displayText, translateText, stageDisplay;

    private ImageButton backButton, homeButton;

    private LinearLayout incorrectLinLay;

    private VocabGame game;

    private AlertDialog.Builder builder;


    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_game);

        handler = new Handler();
        builder = new AlertDialog.Builder(VocabGameActivity.this);


        backButton = (ImageButton) findViewById(R.id.backVocabGameImgButton);
        homeButton = (ImageButton) findViewById(R.id.homeVocabGameImgButton);

        incorrectLinLay = (LinearLayout) findViewById(R.id.linearLayoutIncorrectVocabGame);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VocabGameActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });

        displayText = (TextView) findViewById(R.id.vocab_game_display_text_view);
        translateText = (TextView) findViewById(R.id.vocab_game_translated_text_view);
        stageDisplay = (TextView) findViewById(R.id.vocab_game_stage_text_view);

        initializeAtoZButton();
        addListenerAtoZButton();

        game = VocabGame.getInstance();

        displayText.setText(game.getCurrentDisplay());
        translateText.setText(game.getCurrentTranslated());

        incorrectViewUpdate();
    }

    private void initializeAtoZButton() {
        a = (Button) findViewById(R.id.a_button);
        b = (Button) findViewById(R.id.b_button);
        c = (Button) findViewById(R.id.c_button);
        d = (Button) findViewById(R.id.d_button);
        e = (Button) findViewById(R.id.e_button);
        f = (Button) findViewById(R.id.f_button);
        g = (Button) findViewById(R.id.g_button);
        h = (Button) findViewById(R.id.h_button);
        i = (Button) findViewById(R.id.i_button);
        j = (Button) findViewById(R.id.j_button);
        k = (Button) findViewById(R.id.k_button);
        l = (Button) findViewById(R.id.l_button);
        m = (Button) findViewById(R.id.m_button);
        n = (Button) findViewById(R.id.n_button);
        o = (Button) findViewById(R.id.o_button);
        p = (Button) findViewById(R.id.p_button);
        q = (Button) findViewById(R.id.q_button);
        r = (Button) findViewById(R.id.r_button);
        s = (Button) findViewById(R.id.s_button);
        t = (Button) findViewById(R.id.t_button);
        u = (Button) findViewById(R.id.u_button);
        v = (Button) findViewById(R.id.v_button);
        w = (Button) findViewById(R.id.w_button);
        x = (Button) findViewById(R.id.x_button);
        y = (Button) findViewById(R.id.y_button);
        z = (Button) findViewById(R.id.z_button);
    }

    private void addListenerAtoZButton() {
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
        m.setOnClickListener(this);
        n.setOnClickListener(this);
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        q.setOnClickListener(this);
        r.setOnClickListener(this);
        s.setOnClickListener(this);
        t.setOnClickListener(this);
        u.setOnClickListener(this);
        v.setOnClickListener(this);
        w.setOnClickListener(this);
        x.setOnClickListener(this);
        y.setOnClickListener(this);
        z.setOnClickListener(this);
    }

    private void alphabetPress(char c) {
        Log.d(TAG, "alphabetPress: " + c);
        boolean correct = game.alphabetInput(c);

        updateDisplay();

        if (!correct) {
            incorrectCounter++;
            incorrectViewUpdate();
            if (incorrectCounter >= 3) {
                stageFail();
            }
        }

        if (game.isStageComplete()) {
            stageComplete();
        }


        if (isGameComplete()) {
            gameComplete();
        }
    }

    private void incorrectViewUpdate() {
        incorrectLinLay.removeAllViewsInLayout();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        int margin = (int) getResources().getDimension(R.dimen.vocab_game_X_counter_margin);
        layoutParams.setMargins(margin, 0, margin, 0);

        for(int i = 1; i <= 3; i++) {
            TextView textView = new TextView(VocabGameActivity.this);
            textView.setText("X");
            textView.setTextSize(getResources().getDimension(R.dimen.vocab_game_X_counter_font_size));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                textView.setTypeface(getResources().getFont(R.font.nunito_bold));
            }

            textView.setLayoutParams(layoutParams);

            if (i <= incorrectCounter) textView.setTextColor(getResources().getColor(R.color.colorAccent));
            else textView.setTextColor(getResources().getColor(R.color.dark));
            incorrectLinLay.addView(textView);
        }
    }

    private void updateDisplay() {
        displayText.setText(game.getCurrentDisplay());
    }

    private void setupNewStage() {
        String completeWord = game.getCurrentAnswer();

        StageCompleteDialogFragment fragment = StageCompleteDialogFragment.newInstance(completeWord);
        fragment.show(getSupportFragmentManager(), TAG);

        stageCounter++;
        game.nextStage();
        stageDisplay.setText("Stage " + stageCounter + " / 10");
        displayText.setText(game.getCurrentDisplay());
        translateText.setText(game.getCurrentTranslated());

        incorrectCounter = 0;
        incorrectViewUpdate();
    }

    private void stageFail() {
        scoreCounter += 0;
        setupNewStage();

        Log.d(TAG, "stageFail!! :(");

        // Delay for a half-second to re-enable all button
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                enableAllButton();
            }
        }, 500);
    }

    private void stageComplete() {
        scoreCounter += 1;
        setupNewStage();

        Log.d(TAG, "stageComplete!!");

        // Delay for a half-second to re-enable all button
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                enableAllButton();
            }
        }, 500);
    }

    private void gameComplete() {
        Log.d(TAG, "gameComplete: with score " + scoreCounter);
        // Do more things when game pass all stages

        Intent intent = new Intent(VocabGameActivity.this, VocabGameCompleteActivity.class);
        intent.putExtra("score", scoreCounter);
        startActivity(intent);
        finish();
    }

    private boolean isGameComplete() {
        return stageCounter > 10;
    }

    private void enableAllButton() {
        a.setEnabled(true);
        b.setEnabled(true);
        c.setEnabled(true);
        d.setEnabled(true);
        e.setEnabled(true);
        f.setEnabled(true);
        g.setEnabled(true);
        h.setEnabled(true);
        i.setEnabled(true);
        j.setEnabled(true);
        k.setEnabled(true);
        l.setEnabled(true);
        m.setEnabled(true);
        n.setEnabled(true);
        o.setEnabled(true);
        p.setEnabled(true);
        q.setEnabled(true);
        r.setEnabled(true);
        s.setEnabled(true);
        t.setEnabled(true);
        u.setEnabled(true);
        v.setEnabled(true);
        w.setEnabled(true);
        x.setEnabled(true);
        y.setEnabled(true);
        z.setEnabled(true);
    }

    @Override
    public void onClick(View view) {
        if (view == a) {
            alphabetPress('a');
        } else if (view == b) {
            alphabetPress('b');
        } else if (view == c) {
            alphabetPress('c');
        } else if (view == d) {
            alphabetPress('d');
        } else if (view == e) {
            alphabetPress('e');
        } else if (view == f) {
            alphabetPress('f');
        } else if (view == g) {
            alphabetPress('g');
        } else if (view == h) {
            alphabetPress('h');
        } else if (view == i) {
            alphabetPress('i');
        } else if (view == j) {
            alphabetPress('j');
        } else if (view == k) {
            alphabetPress('k');
        } else if (view == l) {
            alphabetPress('l');
        } else if (view == m) {
            alphabetPress('m');
        } else if (view == n) {
            alphabetPress('n');
        } else if (view == o) {
            alphabetPress('o');
        } else if (view == p) {
            alphabetPress('p');
        } else if (view == q) {
            alphabetPress('q');
        } else if (view == r) {
            alphabetPress('r');
        } else if (view == s) {
            alphabetPress('s');
        } else if (view == t) {
            alphabetPress('t');
        } else if (view == u) {
            alphabetPress('u');
        } else if (view == v) {
            alphabetPress('v');
        } else if (view == w) {
            alphabetPress('w');
        } else if (view == x) {
            alphabetPress('x');
        } else if (view == y) {
            alphabetPress('y');
        } else if (view == z) {
            alphabetPress('z');
        }
        view.setEnabled(false); // disable pressed button
    }
}
