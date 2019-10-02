package com.coe.kku.ac.nursetalk;

import android.content.Context;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;

import org.w3c.dom.Text;

import java.util.Locale;

public class VocabTTS extends UtteranceProgressListener implements TextToSpeech.OnInitListener, TextToSpeech.OnUtteranceCompletedListener {

    public static VocabTTS vocabTTS;

    public static VocabTTS getInstance(Context context) {
        if (vocabTTS == null) {
            vocabTTS = new VocabTTS(context);
        }
        return vocabTTS;
    }

    private Context context;
    private TextToSpeech tts;
    private Locale locale = Locale.getDefault();
    private String enginePackageName;
    private String message;
    private boolean isRunning;
    private int speakCount;

    public VocabTTS(Context context) {
        this.context = context;
    }

    public void speak(String message) {
        this.message = message;

        if (tts == null || !isRunning) {
            speakCount = 0;

            if (enginePackageName != null && !enginePackageName.isEmpty())
                tts = new TextToSpeech(context, this, enginePackageName);
            else
                tts = new TextToSpeech(context, this);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1)
                tts.setOnUtteranceProgressListener(this);
            else
                tts.setOnUtteranceCompletedListener(this);

            isRunning = true;
        }
        else startSpeak();
    }

    public VocabTTS setEngine(String packageName) {
        enginePackageName = packageName;
        return this;
    }

    public VocabTTS setLocale(Locale locale) {
        this.locale = locale;
        return this;
    }

    private void startSpeak() {
        speakCount++;

        if (locale != null)
            tts.setLanguage(locale);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            tts.speak(message, TextToSpeech.QUEUE_FLUSH, null, "");
        else
            tts.speak(message, TextToSpeech.QUEUE_FLUSH, null);
    }

    private void clear() {
        speakCount--;

        if (speakCount != 0) return;
        tts.shutdown();
        isRunning = false;
    }

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS)
            startSpeak();
    }

    @Override
    public void onStart(String s) {}

    @Override
    public void onDone(String s) {
        clear();
    }

    @Override
    public void onError(String s) {
        clear();
    }

    @Override
    public void onUtteranceCompleted(String s) {
        clear();
    }
}
