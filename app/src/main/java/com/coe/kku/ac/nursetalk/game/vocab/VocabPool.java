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

        // Symptom vocab
        words.add(new HashMap<String, String>() {{
            put("answer", "C o n s t i p a t i o n");
            put("word",   "C _ n _ t _ p _ t _ _ _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "D y s p e p s i a");
            put("word",   "D _ s _ e _ s _ _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "D e h y d r a t i o n");
            put("word",   "D _ _ _ d _ _ t _ _ _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "S p r a i n");
            put("word",   "S _ _ _ _ n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "H e a r t b u r n");
            put("word",   "H _ _ _ t b _ _ n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "T o o t h a c h e");
            put("word",   "_ o o _ _ _ c _ _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "S t o m a c h a c h e");
            put("word",   "_ _ _ m a _ _ _ _ h e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "E y e s t r a i n");
            put("word",   "E _ _ _ t r _ _ _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "I n s o m n i a");
            put("word",   "I _ _ _ _ n i _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "C r i c k");
            put("word",   "C r _ _ _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "S o r e   t h r o a t");
            put("word",   "S _ _ e   t _ _ _ a t");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "N o s e   b l e e d");
            put("word",   "N _ _ _   b l _ _ d");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "C o n v u l s i o n");
            put("word",   "C _ _ v u _ _ _ _ n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "F r a c t u r e");
            put("word",   "F _ _ _ t _ _ e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "B r o k e n   b o n e");
            put("word",   "_ _ _ k e n   b _ _ e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "B u r n");
            put("word",   "_ _ _ n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "B l i s t e r");
            put("word",   "_ l _ _ t e r");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "C o n j u n c t i v i t i s");
            put("word",   "_ _ n _ _ _ c t _ _ i t _ s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "N a u s e o u s");
            put("word",   "_ a _ s _ o _ s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "V o m i t");
            put("word",   "V _ _ i t");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "B l e e d i n g");
            put("word",   "_ l _ _ d i _ _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "M i s s h a p e n");
            put("word",   "M _ _ _ h _ p _ n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "B r u i s e");
            put("word",   "_ r u _ _ e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "C o u g h");
            put("word",   "_ _ _ g h");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "I n f l a m e");
            put("word",   "_ _ f _ _ m e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "R u n n y   n o s e");
            put("word",   "_ _ _ n y   n _ _ e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "P h l e g m");
            put("word",   "P _ _ _ g m");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "S w o l l e n");
            put("word",   "S w _ _ _ _ n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "P u s");
            put("word",   "P _ s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "P u r u l e n t");
            put("word",   "_ u _ _ l _ n t");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "C h r o n i c");
            put("word",   "C h r _ _ i _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "H i c c u p");
            put("word",   "H _ _ c _ p");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "P e r s p i r e");
            put("word",   "_ e _ _ p i r _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "R a s h");
            put("word",   "R a _ _");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "S h o r t   o f   b r e a t h");
            put("word",   "_ h _ r t   o _   _ r _ a _ h");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "I t c h y");
            put("word",   "_ t _ c y");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "D i z z y");
            put("word",   "_ _ z _ y");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "F e v e r");
            put("word",   "_ e _ e r");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "B a c k a c h e");
            put("word",   "_ a _ k _ c _ e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "E a r a c h e");
            put("word",   "_ _ r a c _ e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "A c h e");
            put("word",   "A _ _ e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "A c u t e");
            put("word",   "A _ _ _ e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "F a i n t");
            put("word",   "_ _ _ n t");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "F a t i g u e");
            put("word",   "_ a _ i _ u _");
        }});

        // Disease vocab


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
