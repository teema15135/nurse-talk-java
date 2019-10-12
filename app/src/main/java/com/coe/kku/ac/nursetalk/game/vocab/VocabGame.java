package com.coe.kku.ac.nursetalk.game.vocab;

import com.coe.kku.ac.nursetalk.Vocabulary;

import java.util.ArrayList;
import java.util.HashMap;

public class VocabGame {


    private ArrayList<String> providedWords;

    private String currentDisplay;  // Current display in app ex. C h _ m p u
    private String currentAnswer; // Current stage correct answer ex. C h o m p u
    private String currentTranslated; // Current stage translated word ex. คนที่สวย ๆ

    public VocabGame() {
        VocabPool.loadVocabPool();  // Must be loaded before use others function of VocabPool class
        Vocabulary.loadVocab();  // Load vocabulary for translate the answer word
        providedWords = new ArrayList<>();
        this.nextStage();
    }

    /**
     * Call this function to go into the next stage of word (
     */
    public void nextStage() {
        HashMap<String, String> stage = VocabPool.getRandomWord();
        currentDisplay = stage.get("word");
        currentAnswer = stage.get("answer");
        currentTranslated = Vocabulary.getTranslated(
                currentAnswer.replaceAll(" ", ""));

        // Prevent to get duplicate word (that make game easier)
        if (providedWords.contains(currentAnswer)) nextStage();
        else providedWords.add(currentAnswer);
    }

    public boolean alphabetInput(char selected) {
        ArrayList<Integer> index = new ArrayList<>();
        int textLength = currentDisplay.length();

        String oldDisplay = currentDisplay;

        for (int i = 0; i < textLength; i++) {
            if (Character.toLowerCase(currentAnswer.charAt(i)) == selected) {
                StringBuilder curr = new StringBuilder(currentDisplay);
                curr.setCharAt(i, (i == 0 ? Character.toUpperCase(selected) : selected));
                currentDisplay = curr.toString();
            }
        }

        if (!oldDisplay.equalsIgnoreCase(currentDisplay)) // no update means incorrect
            return true;
        return false;
    }

    /**
     * Call this every time that player press button to get the result
     * @return true if the answer equal to word
     */
    public boolean isStageComplete() {
        return (currentAnswer.equalsIgnoreCase(currentDisplay));
    }

    public String getCurrentDisplay() {
        return currentDisplay;
    }

    public String getCurrentAnswer() {
        return currentAnswer;
    }

    public String getCurrentTranslated() {
        return currentTranslated;
    }

    public static VocabGame getInstance() {
        return new VocabGame();
    }
}