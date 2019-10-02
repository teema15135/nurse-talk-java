package com.coe.kku.ac.nursetalk;

public class Word {

    private String word;
    private String pronunciation;
    private String translated;

    public Word(String word, String pronunciation, String translated) {
        super();
        this.word = word;
        this.pronunciation = pronunciation;
        this.translated = translated;
    }

    public String getWord() {
        return word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public String getTranslated() {
        return translated;
    }
}
