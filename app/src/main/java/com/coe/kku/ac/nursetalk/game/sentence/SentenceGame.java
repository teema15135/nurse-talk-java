package com.coe.kku.ac.nursetalk.game.sentence;

import com.coe.kku.ac.nursetalk.Vocabulary;
import com.coe.kku.ac.nursetalk.game.vocab.VocabGame;
import com.coe.kku.ac.nursetalk.game.vocab.VocabPool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SentenceGame {
    private ArrayList<String> providedSentence;

    private String currentHint;
    private String currentAnswer;
    private String currentChoice;

    public SentenceGame() {
        SentencePool.loadSentencePool();  // Must be loaded before use others function of VocabPool class
//        Vocabulary.loadVocab();  // Load vocabulary for translate the answer word
        providedSentence = new ArrayList<>();
        this.nextStage();
    }

    /**
     * Call this function to go into the next stage of word (
     */
    public void nextStage() {
        HashMap<String, String> stage = SentencePool.getRandomSentence();
        currentHint = stage.get("hint");
        currentAnswer = stage.get("answer");
        currentChoice = stage.get("choice");

        // Prevent to get duplicate word (that make game easier)
        if (providedSentence.contains(currentAnswer)) nextStage();
        else providedSentence.add(currentAnswer);
    }

//    public boolean alphabetInput(char selected) {
//        ArrayList<Integer> index = new ArrayList<>();
//        int textLength = currentHint.length();
//
//        String oldDisplay = currentHint;
//
//        for (int i = 0; i < textLength; i++) {
//            if (Character.toLowerCase(currentAnswer.charAt(i)) == selected) {
//                StringBuilder curr = new StringBuilder(currentHint);
//                curr.setCharAt(i, (i == 0 ? Character.toUpperCase(selected) : selected));
//                currentHint = curr.toString();
//            }
//        }
//
//        if (!oldDisplay.equalsIgnoreCase(currentHint)) // no update means incorrect
//            return true;
//        return false;
//    }

    /**
     * Call this every time that player press button to get the result
     * @return true if the answer equal to word
     */
//    public boolean isStageComplete() {
//        return (currentAnswer.equalsIgnoreCase(currentHint));
//    }

    public String getCurrentHint() {
        return currentHint;
    }

    public String getCurrentAnswer() {
        return currentAnswer;
    }

    public ArrayList<String> getCurrentAnswerArray() {
        return new ArrayList<>(Arrays.asList(currentAnswer.split(" ")));
    }

    public String getCurrentChoice() {
        return currentChoice;
    }

    public static SentenceGame getInstance() {
        return new SentenceGame();
    }
}
