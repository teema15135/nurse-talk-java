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
        symptomList.add(new Word("Ache", "เอค", "อาการปวด"));
        symptomList.add(new Word("Acute", "อะ-คิ้วท์", "อาการป่วยที่เกิดขึ้นอย่างฉับพลัน"));
        symptomList.add(new Word("Backache", "แบ็คเอค", "ปวดหลัง"));
        symptomList.add(new Word("Bleeding", "บลีดดิ้ง", "ที่มีเลือดไหล"));
        symptomList.add(new Word("Blister", "บลิสเตอ", "แผลพุพอง"));
        symptomList.add(new Word("Bloody", "nose บลัดดี้-โนส", "เลือดกำเดาไหล"));
        symptomList.add(new Word("Broken", "bone โบรกเคน", "กระดูกหัก"));
        symptomList.add(new Word("Bruise", "บรูซฺ", "แผลฟกช้ำ"));
        symptomList.add(new Word("Burn", "เบิรฺน แผลที่เกิดจากไฟไหม้", "น้ำร้อนลวก"));
        symptomList.add(new Word("Chronic", "ครอนิค", "เรื้อรัง"));
        symptomList.add(new Word("Conjunctivitis", "คอนจังทิไวซิส", "เยื่อบุตาอักเสบ/ตาแดง"));
        symptomList.add(new Word("Constipation", "คอนสทิเพเชิน", "อาการท้องผูก"));
        symptomList.add(new Word("Convulsion", "คอนวัลเชิน", "การชักกระตุก"));
        symptomList.add(new Word("Cough", "คอฟ", "ไอ"));
        symptomList.add(new Word("Crick", "คริคฺ", "อาการเจ็บตึงกล้ามเนื้อ"));
        symptomList.add(new Word("Dehydration", "ดีไฮเดรเชิน", "อาการที่ร่างกายขาดน้ำ"));
        symptomList.add(new Word("Dizzy", "ดิซ’ซี", "วิงเวียนศีรษะ"));
        symptomList.add(new Word("Dyspepsia", "ดิสเพพเซีย", "อาการอาหารไม่ย่อย"));
        symptomList.add(new Word("Earache", "เอียเอค", "เจ็บหู"));
        symptomList.add(new Word("Eyestrain", "อายสเตรน", "อาการเพลียตา"));
        symptomList.add(new Word("Faint", "เฟ้นท์", "เป็นลม"));
        symptomList.add(new Word("Fatigue", "ฟะ-ทิ้ก", "ความเหนื่อยล้า"));
        symptomList.add(new Word("Fever", "ฟี’เวอะ", "ไข้"));
        symptomList.add(new Word("Fracture", "แฟรคเจอ", "กระดูกร้าว/หัก"));
        symptomList.add(new Word("Heartburn", "ฮารฺทเบิรฺน", "อาการจุกเสียดแน่นท้อง"));
        symptomList.add(new Word("Hiccup", "ฮิคคัพ", "สะอึก"));
        symptomList.add(new Word("Inflame", "อินเฟลม", "อักเสบแสบ"));
        symptomList.add(new Word("Insomnia", "อินซอมเนีย", "อาการนอนไม่หลับ"));
        symptomList.add(new Word("Itchy", "อิท’ชี", "อาการคัน"));
        symptomList.add(new Word("Misshapen", "มิสเชพเพน", "ที่ผิดรูปผิดร่าง"));
        symptomList.add(new Word("Nauseous", "นอเซียส", "คลื่นไส้"));
        symptomList.add(new Word("Nose bleed", "โนส บลีด", "อาการเลือดกำเดาไหล"));
        symptomList.add(new Word("Perspire", "เพอรฺสไพรฺ", "เหงื่อออก"));
        symptomList.add(new Word("Phlegm", "เฟลม", "เสมหะ"));
        symptomList.add(new Word("Purulent", "พูรูเลนทฺ", "เป็นหนอง"));
        symptomList.add(new Word("Pus", "พัสฺ", "หนอง"));
        symptomList.add(new Word("Rash", "แรช", "ผื่นคัน"));
        symptomList.add(new Word("Runny nose", "รันนี โนส", "น้ำมูกไหล"));
        symptomList.add(new Word("Short of breath", "ชอร์ท ออฟ เบรธ", "หอบฮัก ๆ หายใจไม่ทั่วท้อง"));
        symptomList.add(new Word("Sore throat", "ซอรฺ โธรท", "อาการเจ็บคอ"));
        symptomList.add(new Word("Sprain", "สเปรน", "อาการเคล็ด หรือแพลง"));
        symptomList.add(new Word("Stomachache", "สตอมัคเอค", "อาการปวดท้อง"));
        symptomList.add(new Word("Stuffy nose", "สตัฟฟี โนส", "อาการคัดจมูก"));
        symptomList.add(new Word("Swollen", "สวอลเลิน", "บวม"));
        symptomList.add(new Word("Toothache", "ทูธเอค", "อาการปวดฟัน"));
        symptomList.add(new Word("Vomit", "วอมิทฺ", "อาเจียน"));
    }

    private static void addDiseaseList() {
        diseaseList.add(new Word("Allergy", "อัลเลอรฺจี", "ภูมิแพ้"));
        diseaseList.add(new Word("Appendicitis", "แอพเพนดิไซทิส", "โรคไส้ติ่งอักเสบ"));
        diseaseList.add(new Word("Asthmatic", "แอสแมทิคฺ", "โรคหอบหืด"));
        diseaseList.add(new Word("Cancer", "แคนเซอร์", "โรคมะเร็ง"));
        diseaseList.add(new Word("Chicken pox", "ชิคเคน พ็อกสฺ", "อีสุกอีใส"));
        diseaseList.add(new Word("Chronic", "ครอนิค", "เรื้อรัง"));
        diseaseList.add(new Word("Cirrhosis", "สิโรซิส", "โรคตับแข็ง"));
        diseaseList.add(new Word("Cold", "โคลด์", "โรคหวัด, หนาว"));
        diseaseList.add(new Word("Dengue fever", "เดงกี ฟีเวอร์", "ไข้เลือดออก"));
        diseaseList.add(new Word("Depression", "ดีเพรสเชิน", "โรคซึมเศร้า"));
        diseaseList.add(new Word("Diabetes", "ไดอะบีทสฺ", "โรคเบาหวาน"));
        diseaseList.add(new Word("Diarrhea", "ไดเออะเรีย", "ท้องร่วง"));
        diseaseList.add(new Word("Diphtheria", "ดิพเธอเรีย", "โรคคอตีบ"));
        diseaseList.add(new Word("Enteritis", "เอนเทอไรทิซ", "โรคลำไส้อักเสบ"));
        diseaseList.add(new Word("Food poisoning", "ฟูด พอยเซินนิง", "อาหารเป็นพิษ"));
        diseaseList.add(new Word("Gallstones", "กอลสโตนส์", "โรคนิ่วในถุงน้ำดี"));
        diseaseList.add(new Word("Gastritis", "แกซไทรซิส", "โรคกระเพาะอาหารอักเสบ"));
        diseaseList.add(new Word("German measles", "เจอมัน มีเซิล", "โรคหัดเยอรมัน"));
        diseaseList.add(new Word("Gout", "เกาทฺ", "โรคเกาต์"));
        diseaseList.add(new Word("Heart", "disease ฮาร์ทฺ ดิซีสฺ", "โรคหัวใจ"));
        diseaseList.add(new Word("Hemorrhoids", "เฮมะรอยด์สฺ", "ริดสีดวงทวาร"));
        diseaseList.add(new Word("Hemorrhoids", "เฮมอร์รอยดส์", "ริดสีดวงทวาร"));
        diseaseList.add(new Word("Jaundice", "จอนดิซ", "ดีซ่าน"));
        diseaseList.add(new Word("Laryngitis", "ลาริงไจทิซ", "โรคกล่องเสียงอักเสบ"));
        diseaseList.add(new Word("Measles", "มีเซิล", "โรคหัด"));
        diseaseList.add(new Word("Pertussis", "เพอทัสซิส", "โรคไอกรน"));
        diseaseList.add(new Word("Pneumonia", "นิวโมเนีย", "โรคปอดบวม"));
        diseaseList.add(new Word("Rubella", "รูเบลลา", "โรคหัดเยอรมัน"));
        diseaseList.add(new Word("Sinusitis", "ไซนัสไซทิซ", "โรคไซนัสอักเสบ"));
        diseaseList.add(new Word("Stye", "สตาย", "โรคตากุ้งยิง"));
        diseaseList.add(new Word("Tetanus", "เททานัส", "โรคบาดทะยัก"));
        diseaseList.add(new Word("Tonsillitis", "ทอนซิลลิซิส", "ต่อมทอนซิลอักเสบ"));
        diseaseList.add(new Word("Tuberculosis", "ทูเบอร์คิวโลซิสส์", "วัณโรค"));
        diseaseList.add(new Word("Whooping cough", "วูปปิง คอฟ", "โรคไอกรน"));
    }

    public static ArrayList<Word> getSymptomWords() {
        return symptomList;
    }

    public static ArrayList<Word> getDiseaseWords() {
        return diseaseList;
    }
}
