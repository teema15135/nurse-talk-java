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

        // group 1
        sentence.add(new HashMap<String, String>() {{ //1
            put("answer", "good morning ");
            put("hint", "สวัสดีตอนเช้า");
        }});
        sentence.add(new HashMap<String, String>() {{ //2
            put("answer", "good afternoon ");
            put("hint", "สวัสดีตอนตอนกลางวัน");
        }});
        sentence.add(new HashMap<String, String>() {{ //3
            put("answer", "good evening ");
            put("hint", "สวัสดีตอนเย็น");
        }});
        sentence.add(new HashMap<String, String>() {{ //4
            put("answer", "i'm a nursing student ");
            put("hint", "ฉันเป็นนักศึกษาพยาบาล");
        }});
        sentence.add(new HashMap<String, String>() {{ //5
            put("answer", "please sit down ");
            put("hint", "เชิญนั่งครับ/ค่ะ");
        }});

        // group 2
        sentence.add(new HashMap<String, String>() {{ //6
            put("answer", "how much do you weigh? ");
            put("hint", "คุณน้ำหนักเท่าไหร่");
        }});
        sentence.add(new HashMap<String, String>() {{ //7
            put("answer", "what seems to be the problem? ");
            put("hint", "คุณมีปัญหาอะไรหรือไม่");
        }});
        sentence.add(new HashMap<String, String>() {{ //8
            put("answer", "what seems to be wrong with you? ");
            put("hint", "คุณคิดว่าอาการผิดปกติคืออะไร");
        }});
        sentence.add(new HashMap<String, String>() {{ //9
            put("answer", "what is your symptom? ");
            put("hint", "อาการป่วยของคุณคืออะไร");
        }});
        sentence.add(new HashMap<String, String>() {{ //10
            put("answer", "have you ever been hospitalized before? ");
            put("hint", "คุณเคยรับการรักษาในโรงพยาบาลมาก่อนหรือไม่");
        }});

        // group 3
        sentence.add(new HashMap<String, String>() {{ //1
            put("answer", "may I take your temperature? ");
            put("hint", "ดิฉัน/ผมจะวัดอุณหภูมิคุณนะคะ/ครับ");
        }});
        sentence.add(new HashMap<String, String>() {{ //2
            put("answer", "your temperature is normal ");
            put("hint", "อุณหภูมิคุณปกตินะคะ");
        }});
        sentence.add(new HashMap<String, String>() {{ //3
            put("answer", "you have a slight fever ");
            put("hint", "คุณมีไข้เล็กน้อยนะคะ");
        }});
        sentence.add(new HashMap<String, String>() {{ //4
            put("answer", "your blood pressure is a bit low ");
            put("hint", "ความดันของคุณต่ำเล็กน้อย");
        }});
        sentence.add(new HashMap<String, String>() {{ //5
            put("answer", "I would like to take your blood pressure again in half an hour ");
            put("hint", "อีกครึ่งชั่วโมงดิฉันจะวัดความดันคุณซ้ำ");
        }});

        // group 4
        sentence.add(new HashMap<String, String>() {{ //6
            put("answer", "please do not eat after midnight ");
            put("hint", "โปรดงดอาหารหลังเที่ยงคืน");
        }});
        sentence.add(new HashMap<String, String>() {{ //7
            put("answer", "are you left handed or right handed? ");
            put("hint", "ถนัดมือซ้ายหรือขวา");
        }});
        sentence.add(new HashMap<String, String>() {{ //8
            put("answer", "this mixture of fluid is for your diarrhea ");
            put("hint", "สารน้ำนี้ให้สำหรับอาการท้องเสีย");
        }});
        sentence.add(new HashMap<String, String>() {{ //9
            put("answer", "you can move your arm freely but not to raise your hand higher than this bottle ");
            put("hint", "ขยับแขนได้ปกติ แต่พยายามไม่ยกมือสูงกว่าขวดน้ำเกลือ");
        }});
        sentence.add(new HashMap<String, String>() {{ //10
            put("answer", "it’s an antibiotic for your incision ");
            put("hint", "ยาปฏิชีวนะสำหรับแผลผ่าตัด");
        }});

        // group 5
        sentence.add(new HashMap<String, String>() {{ //1
            put("answer", "whichever you like ");
            put("hint", "ข้างไหนก็ไหนก็ได้ แล้วแต่คุณ");
        }});
        sentence.add(new HashMap<String, String>() {{ //2
            put("answer", "will it hurt? ");
            put("hint", "มันจะเจ็บไหม");
        }});
        sentence.add(new HashMap<String, String>() {{ //3
            put("answer", "which arm would you like me to take blood sample? ");
            put("hint", "คุณอยากจะเจาะแขนข้างไหน");
        }});
        sentence.add(new HashMap<String, String>() {{ //4
            put("answer", "it may hurt a little bit, but I’ll try my best ");
            put("hint", "มันอาจจะเจ็บนิดหน่อย แต่ฉันจะพยายามทำให้ดีที่สุด");
        }});
        sentence.add(new HashMap<String, String>() {{ //5
            put("answer", "keep your arm still, please ");
            put("hint", "กรุณาทำแขนนิ่งๆค่ะ");
        }});

        // group 6
        sentence.add(new HashMap<String, String>() {{ //6
            put("answer", "how to collect a urine sample ");
            put("hint", "วิธีการเก็บปัสสาวะ");
        }});
        sentence.add(new HashMap<String, String>() {{ //7
            put("answer", "do you know how to collect a urine sample ");
            put("hint", "คุณรู้วิธีเก็บตัวอย่างปัสสาวะหรือไม่");
        }});
        sentence.add(new HashMap<String, String>() {{ //8
            put("answer", "wash your hands again and then give it back to me ");
            put("hint", "ล้างมือของคุณและนำมาให้ฉัน");
        }});
        sentence.add(new HashMap<String, String>() {{ //9
            put("answer", "collect the middle part of urine into this container ");
            put("hint", "เก็บปัสสาวะช่วงกลางลงในกระป๋องปัสสาวะนี้นะคะ");
        }});
        sentence.add(new HashMap<String, String>() {{ //10
            put("answer", "I would like to take a sample of urine, please ");
            put("hint", "ฉันขอเก็บตัวอย่างปัสสาวะของคุณได้หรือไหม");
        }});

        // group 7
        sentence.add(new HashMap<String, String>() {{ //1
            put("answer", "Tight and painful? ");
            put("hint", "ปวดแบบตึงๆหรือไม่");
        }});
        sentence.add(new HashMap<String, String>() {{ //2
            put("answer", "I have a moderate pain ");
            put("hint", "ฉันปวดปานกลาง");
        }});
        sentence.add(new HashMap<String, String>() {{ //3
            put("answer", "does it begin slowly or rapidly? ");
            put("hint", "อาการปวดค่อยเป็นค่อยไปหรือปวดทันทีทันใด?");
        }});
        sentence.add(new HashMap<String, String>() {{ //4
            put("answer", "where do you feel the pain? ");
            put("hint", "ปวดบริเวณไหนคะ/ครับ");
        }});
        sentence.add(new HashMap<String, String>() {{ //5
            put("answer", "when does the pain increase? ");
            put("hint", "มีอาการปวดมากขึ้นเมื่อไหร่?");
        }});

        //group 8
        sentence.add(new HashMap<String, String>() {{ //6
            put("answer", "I will dress your wound ");
            put("hint", "ฉันจะล้างแผลให้คุณ");
        }});
        sentence.add(new HashMap<String, String>() {{ //7
            put("answer", "I’m finished dressing your wound ");
            put("hint", "การทำแผลของคุณเสร็จแล้ว");
        }});
        sentence.add(new HashMap<String, String>() {{ //8
            put("answer", "mind your wound, don't let the water get into your wound ");
            put("hint", "ระวังแผลของคุณไม่ให้โดนน้ำ");
        }});
        sentence.add(new HashMap<String, String>() {{ //9
            put("answer", "you must take care to clean the wound. and come by appointment ");
            put("hint", "คุณต้องดูแลทำความสะอาดแผล และมาตามการนัดหมาย");
        }});
        sentence.add(new HashMap<String, String>() {{ //10
            put("answer", "stretch your arm please, then I can dress your wound ");
            put("hint", "กรุณายื่นแขนมาให้ฉันสามารถทำแผลของคุณได้");
        }});

        // group 9
        sentence.add(new HashMap<String, String>() {{ //1
            put("answer", "Please follow the physician’s suggestions ");
            put("hint", "โปรดปฏิบัติตามคำแนะนำของแพทย์");
        }});
        sentence.add(new HashMap<String, String>() {{ //2
            put("answer", "sleep at least 8 hours ");
            put("hint", "ควรนอนหลับพักผ่อนอย่างน้อย 8 ชั่วโมง");
        }});
        sentence.add(new HashMap<String, String>() {{ //3
            put("answer", "you should exercise 3-4 day/week and 30-40 minute/times ");
            put("hint", "คุณควรออกกำลังกาย 3-4 ครั้ง/สัปดาห์ และครั้งละ 30-40 นาที");
        }});
        sentence.add(new HashMap<String, String>() {{ //4
            put("answer", "rest today, you can resume your normal activities later ");
            put("hint", "วันนี้ให้คุณพักผ่อน หลังจากนั้นให้เริ่มกิจกรรมตามปกติ");
        }});
        sentence.add(new HashMap<String, String>() {{ //5
            put("answer", "you should not drink an alcohol and stop smoking ");
            put("hint", "คุณควรหยุดดื่มเครื่องดื่มแอลกอฮอล์ และหยุดสูบบุหรี่");
        }});

        // group 10
        sentence.add(new HashMap<String, String>() {{ //6
            put("answer", "take four times a day ");
            put("hint", "รับประทานสี่ครั้งต่อวัน");
        }});
        sentence.add(new HashMap<String, String>() {{ //7
            put("answer", "take the medicine with orange juice ");
            put("hint", "รับประทานยาพร้อมกับน้ำส้ม");
        }});
        sentence.add(new HashMap<String, String>() {{ //8
            put("answer", "do not drink alcohol with this medicine ");
            put("hint", "ห้ามรับประทานยาพร้อมกับแอลกอฮอล์");
        }});
        sentence.add(new HashMap<String, String>() {{ //9
            put("answer", "take on an empty stomach ");
            put("hint", "ต้องรับประทานยาขณะท้องว่าง");
        }});
        sentence.add(new HashMap<String, String>() {{ //10
            put("answer", "take the medicine with food ");
            put("hint", "รับประทานยาพร้อมอาหาร");
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
