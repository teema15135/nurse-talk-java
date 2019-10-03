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

    private static boolean isLoaded = false;

    private static ArrayList<Word> symptomList;
    private static ArrayList<Word> diseaseList;

    public Vocabulary() {

    }

    public static void loadVocab() {
        if (isLoaded) return;
        symptomList = new ArrayList<>();
        diseaseList = new ArrayList<>();

        addSymptomList();
        addDiseaseList();
        isLoaded = true;
    }

    private static void addSymptomList() {
        symptomList.add(new Word("ache", "เอค", "อาการปวด"));
        symptomList.add(new Word("acute", "อะ-คิ้วท์", "อาการป่วยที่เกิดขึ้นอย่างฉับพลัน"));
        symptomList.add(new Word("backache", "แบ็คเอค", "ปวดหลัง"));
        symptomList.add(new Word("bleeding", "บลีดดิ้ง", "ที่มีเลือดไหล"));
    }

    private static void addDiseaseList() {
        diseaseList.add(new Word("allergy", "อัลเลอรฺจี", "ภูมิแพ้"));
        diseaseList.add(new Word("appendicitis", "แอพเพนดิไซทิส", "โรคไส้ติ่งอักเสบ"));
        diseaseList.add(new Word("asthmatic", "แอสแมทิคฺ", "โรคหอบหืด"));
        diseaseList.add(new Word("cancer", "แคนเซอร์", "โรคมะเร็ง"));
    }

    public static ArrayList<Word> getSymptomWords() {
        return symptomList;
    }

    public static ArrayList<Word> getDiseaseWords() {
        return diseaseList;
    }
}
