package com.coe.kku.ac.nursetalk;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Vocabulary {

    private String TAG = "Vocabulary Class";

    private static Vocabulary instance;

    private ArrayList<Word> symptomList;
    private ArrayList<Word> diseaseList;

    public Vocabulary(Context context) {
        AssetManager mngr = context.getAssets();
        BufferedReader symptom_br, disease_br;
        String line;

        symptomList = new ArrayList<>();
        diseaseList = new ArrayList<>();

        // Read Symptoms words from file in assets
        // and build an ArrayList
        try {
            InputStreamReader isr = new InputStreamReader(mngr.open("symptoms_list"));
            symptom_br = new BufferedReader(isr);
            while ((line = symptom_br.readLine()) != null) {
                String[] splited = line.split("=");
                symptomList.add(new Word(splited[0], splited[1], splited[2]));
            }
            symptom_br.close();
            isr.close();
        } catch (IOException ioException) {
            Log.d(TAG, "Vocabulary: Catch on IOException (Symptom)");
        }

        // Read Disease words from file in assets
        // and build an ArrayList
        try {
            InputStreamReader isr = new InputStreamReader(mngr.open("disease_list"));
            disease_br = new BufferedReader(isr);
            while ((line = disease_br.readLine()) != null) {
                String[] splited = line.split("=");
                diseaseList.add(new Word(splited[0], splited[1], splited[2]));
            }
            disease_br.close();
            isr.close();
        } catch (IOException ioException) {
            Log.d(TAG, "Vocabulary: Catch on IOException (Disease)");
        }
        mngr.close();
    }

    public ArrayList<Word> getSymptomWords() {
        return symptomList;
    }

    public ArrayList<Word> getDiseaseWords() {
        return diseaseList;
    }

    public static Vocabulary getInstance(Context context) {
        if (instance == null) {
            return new Vocabulary(context);
        } else return instance;
    }
}
