package com.coe.kku.ac.nursetalk.game.vocab;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class VocabPool {

    private static final String TAG = "VocabPool";

    private static ArrayList<HashMap> words;
    private static boolean wordLoaded = false;

    public static void loadVocabPool() {
        words = new ArrayList<>();

        words.add(new HashMap<String, String>() {{
            put("word",   "C _ n _ t _ p _ t _ _ _");
            put("answer", "C o n s t i p a t i o n");
        }});
        words.add(new HashMap<String, String>() {{
            put("word",   "D _ s _ e _ s _ _");
            put("answer", "D y s p e p s i a");
        }});
        words.add(new HashMap<String, String>() {{
            put("word",   "D _ _ _ d _ _ t _ _ _");
            put("answer", "D e h y d r a t i o n");
        }});
        words.add(new HashMap<String, String>() {{
            put("word",   "S _ _ _ _ n");
            put("answer", "S p r a i n");
        }});
        words.add(new HashMap<String, String>() {{
            put("word",   "H _ _ _ t b _ _ n");
            put("answer", "H e a r t b u r n");
        }});

        wordLoaded = true;
    }

    public static HashMap<String, String> getRandomWord() {
        if (!wordLoaded) {
            Log.d(TAG, "getRandomWord: Please loadVocabPool() first!");
            return null;
        }
        return words.get((new Random()).nextInt(words.size()));
    }

}
