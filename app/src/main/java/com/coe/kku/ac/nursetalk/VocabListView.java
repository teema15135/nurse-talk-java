package com.coe.kku.ac.nursetalk;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class VocabListView extends BaseAdapter {

    private static final String TAG = "VocabListView";

    ArrayList<Word> words;
    Context mContext;

    public VocabListView(Context context, ArrayList<Word> words) {
        this.mContext = context;
        this.words = words;
    }

    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        LayoutInflater mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (view != null) {
            holder = (ViewHolder) view.getTag();
        } else {
            view = mInflater.inflate(R.layout.listview_vocab, viewGroup, false);
            holder = new ViewHolder();
            view.setTag(holder);
        }

        final int the_index = i;

        holder.eng_word = (TextView) view.findViewById(R.id.engWordVocab);
        holder.pronunciation = (TextView) view.findViewById(R.id.pronunciation);
        holder.translated = (TextView) view.findViewById(R.id.translatedWordVocab);
        holder.readWordButton = (ImageButton) view.findViewById(R.id.readWordImgButton);

        holder.eng_word.setText(words.get(i).getWord());
        holder.pronunciation.setText("(" + words.get(i).getPronunciation() + ")");
        holder.translated.setText(words.get(i).getTranslated());

        holder.readWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                VocabTTS.getInstance(mContext)
                        .setLocale(new Locale("en"))
                        .speak(words.get(the_index).getWord());
                Log.d(TAG, "onClick: " + words.get(the_index).getWord());
            }
        });

        Log.d(TAG, "getView: " + words.get(i).getWord());
        return view;
    }
}

class ViewHolder {
    TextView eng_word;
    TextView pronunciation;
    TextView translated;
    ImageButton readWordButton;
}
