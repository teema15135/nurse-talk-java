package com.coe.kku.ac.nursetalk.game.sentence;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class SentencePool {

    private static final String TAG = "SentencePool";

    private static ArrayList<HashMap> sentence;
    private static boolean sentenceLoaded = false;

    public static void loadSentencePool() {
        sentence = new ArrayList<>();

        // Symptom vocab
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a dog ");
            put("choice", "1");
            put("hint", "ฉันเป็นหมา");
        }});
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a cat ");
            put("choice", "2");
            put("hint", "ฉันเป็นแมว");
        }});
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a chompu ");
            put("choice", "3");
            put("hint", "ฉันคือชมพู่");
        }});
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a teema ");
            put("choice", "4");
            put("hint", "ฉันคือธีมา");
        }});
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a tua poo ");
            put("choice", "5");
            put("hint", "ฉันคือถั่วพู");
        }});
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a tua ngok ");
            put("choice", "6");
            put("hint", "ฉันคือถั่วงอก");
        }});
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a tua tom ");
            put("choice", "7");
            put("hint", "ฉันคือถั่วต้ม");
        }});
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a yhang yhang ");
            put("choice", "8");
            put("hint", "ฉันคือหยางหยาง");
        }});
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a bird ");
            put("choice", "9");
            put("hint", "ฉันเป็นนก");
        }});
        sentence.add(new HashMap<String, String>() {{
            put("answer", "I am a lion ");
            put("choice", "10");
            put("hint", "ฉันเป็นสิงโต");
        }});

        sentenceLoaded = true;
    }

    public static HashMap<String, String> getRandomSentence() {
        if (!sentenceLoaded) {
            Log.d(TAG, "getRandomWord: Please loadVocabPool() first!");
            return null;
        }
        return sentence.get((new Random()).nextInt(sentence.size()));
    }
}
