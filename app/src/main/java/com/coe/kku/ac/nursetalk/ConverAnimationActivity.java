package com.coe.kku.ac.nursetalk;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ConverAnimationActivity extends AppCompatActivity {

    private ListView listView;
    private View touchView;
    private ImageButton back, home;
    private ImageView bg;
    private TextView title;
    private RelativeLayout topbarLayout;
    boolean myMessage = true;
    private List<ChatBubble> ChatBubbles;
    private ArrayAdapter<ChatBubble> adapter;
    private int mCounter = 0;
    private int maxBubble, content;
    private String msg;
    private String msgArr[];
    Conversation objConversation;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conver_animation);

        ChatBubbles = new ArrayList<>();

        listView = (ListView) findViewById(R.id.conver_list);
        touchView = (View) findViewById(R.id.conver_touch);
        back = (ImageButton) findViewById(R.id.backConverAnimationButton);
        home = (ImageButton) findViewById(R.id.homeConverAnimationImgButton);
        topbarLayout = (RelativeLayout) findViewById(R.id.conver_topbar);
        title = (TextView) findViewById(R.id.conver_title);
        bg = (ImageView) findViewById(R.id.conver_bg);


        //set ListView adapter first
        adapter = new MessageAdapter(this, R.layout.left_chat_bubble, ChatBubbles);
        listView.setAdapter(adapter);

        objConversation = new Conversation();   // create obj of class conversation


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConverAnimationActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });


        //filter intent
        Intent intent = getIntent();
        content = (int) intent.getIntExtra("content", 0);
        if (content == 1) {
            bg.setBackgroundResource(R.drawable.bg_urine_exam_darker);
            topbarLayout.setBackgroundResource(R.color.urine_bar);
            title.setText("Urine Examination");
            maxBubble = 7;
            msgArr = objConversation.urineArr;
        }
        else if (content == 2) {
            bg.setBackgroundResource(R.drawable.bg_blood_test_darker);
            topbarLayout.setBackgroundResource(R.color.dark_blood_bar);
            title.setText("Blood Test");
            maxBubble = 14;
            msgArr = objConversation.bloodArr;

        }
        else if (content == 3) {
            bg.setBackgroundResource(R.drawable.bg_patient_interview_darker);
            topbarLayout.setBackgroundResource(R.color.dark_patient_bar);
            title.setText("Patient Interview");
            maxBubble = 15;
            msgArr = objConversation.patientArr;
        }
        else if (content == 4) {
            bg.setBackgroundResource(R.drawable.bg_take_a_vital_darker);
            topbarLayout.setBackgroundResource(R.color.dark_sign_bar);
            title.setText("Take a Vital Sign");
            maxBubble = 12;
            msgArr = objConversation.vitalSignArr;
        }
        else if (content == 5) {
            bg.setBackgroundResource(R.drawable.bg_pain_darker);
            topbarLayout.setBackgroundResource(R.color.dark_pain_bar);
            title.setText("Pain Management");
            maxBubble = 11;
            msgArr = objConversation.painArr;
        }
        else if (content == 6) {
            bg.setBackgroundResource(R.drawable.bg_how_to_med_darker);
            topbarLayout.setBackgroundResource(R.color.dark_medicine_bar);
            title.setText("How to Take a Medicine");
            maxBubble = 10;
            msgArr = objConversation.medicineArr;
        }


        // touch screen for add msg to list
        touchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCounter < maxBubble) {
//                    msg = objConversation.urineArr[mCounter];
                    msg = msgArr[mCounter];

                    ChatBubble ChatBubble = new ChatBubble(msg, myMessage);
                    ChatBubbles.add(ChatBubble);

                    adapter.notifyDataSetChanged();
                    if (myMessage) {
                        myMessage = false;
                    } else {
                        myMessage = true;
                    }
                    mCounter++;
                }
                else {
                    //nothing to do~~~~~~
                }

            }
        });
    }
}
