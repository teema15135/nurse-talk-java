package com.coe.kku.ac.nursetalk.game.vocab;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.coe.kku.ac.nursetalk.MainActivity;
import com.coe.kku.ac.nursetalk.R;
import com.coe.kku.ac.nursetalk.game.sentence.SentenceGameActivity;

public class VocabGameActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnDismissListener {

    private static final String TAG = "VocabGameActivity";

    private int stageCounter = 1;
    private int scoreCounter = 0;
    private int incorrectCounter = 0;
//    int dimensionInDp = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 30, getResources().getDisplayMetrics());

    private Button q, w, e, r, t, y, u, i, o, p;
    private Button a, s, d, f, g, h, j, k, l;
    private Button z, x, c, v, b, n, m;

    private TextView displayText, translateText, stageDisplay;

    private ImageButton backButton, homeButton;

    private LinearLayout incorrectLinLay;

    private VocabGame game;

    private AlertDialog.Builder builder;

    private MediaPlayer mp;


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

        mp = MediaPlayer.create(getApplicationContext(), R.raw.short_click);     // play short click sound

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                finish();
            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
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
                100, 100);
        int margin = (int) getResources().getDimension(R.dimen.vocab_game_X_counter_margin);
        layoutParams.setMargins(margin, 0, margin, 0);

        for(int i = 1; i <= 3; i++) {
//            TextView textView = new TextView(VocabGameActivity.this);
//            textView.setText("X");
//            textView.setTextSize(getResources().getDimension(R.dimen.vocab_game_X_counter_font_size));
            ImageView heart = new ImageView(VocabGameActivity.this);
            heart.setImageResource(R.drawable.like_red);

//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//                textView.setTypeface(getResources().getFont(R.font.nunito_bold));
//            }

            heart.setLayoutParams(layoutParams);

            if (i <= incorrectCounter) heart.setImageResource(R.drawable.like_black);
            else heart.setImageResource(R.drawable.like_red);
            incorrectLinLay.addView(heart);

//            if (i <= incorrectCounter) textView.setTextColor(getResources().getColor(R.color.colorAccent));
//            else textView.setTextColor(getResources().getColor(R.color.dark));
//            incorrectLinLay.addView(textView);
        }
    }

    private void updateDisplay() {
        displayText.setText(game.getCurrentDisplay());
    }

    private void setupNewStage() {

        stageCounter++;

        if (isGameComplete()) {
            gameComplete();
            return;
        }

        game.nextStage();
        stageDisplay.setText("Stage " + stageCounter + " / 10");
        displayText.setText(game.getCurrentDisplay());
        translateText.setText(game.getCurrentTranslated());

        incorrectCounter = 0;
        incorrectViewUpdate();
    }

    private void stageFail() {
        scoreCounter += 0;

        Log.d(TAG, "stageFail!! :(");

        String completeWord = game.getCurrentAnswer();

        StageWrongDialogFragment fragment = StageWrongDialogFragment.newInstance(completeWord);
        fragment.show(getSupportFragmentManager(), TAG);

        // Delay for a half-second to re-enable all button
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                enableAllButton();
                restoreColorAlphaButton();
            }
        }, 500);
    }

    private void stageComplete() {
        scoreCounter += 1;

        Log.d(TAG, "stageComplete!!");

        String completeWord = game.getCurrentAnswer();

        StageCompleteDialogFragment fragment = StageCompleteDialogFragment.newInstance(completeWord);
        fragment.show(getSupportFragmentManager(), TAG);

        // Delay for a half-second to re-enable all button
        (new Handler()).postDelayed(new Runnable() {
            @Override
            public void run() {
                enableAllButton();
                restoreColorAlphaButton();
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

        mp.start();

        view.setEnabled(false); // disable pressed button

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.shape_grey_round));
        }
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
        setupNewStage();
    }

    private void restoreColorAlphaButton() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            a.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            b.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            c.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            d.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            e.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            f.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            g.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            h.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            i.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            j.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            l.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            m.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            n.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            o.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            p.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            q.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            r.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            s.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            t.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            u.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            v.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            w.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            x.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            y.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            z.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
            k.setBackground(ContextCompat.getDrawable(VocabGameActivity.this, R.drawable.selector_light_blue_round));
        }

    }
}
