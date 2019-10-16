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
            put("answer", "Constipation");
            put("word",   "C_n_t_p_t___");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Dyspepsia");
            put("word",   "D_s_e_s__");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Dehydration");
            put("word",   "D___d__t___");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Sprain");
            put("word",   "S____n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Heartburn");
            put("word",   "H___tb__n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Toothache");
            put("word",   "_oo___c__");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Stomachache");
            put("word",   "___ma____he");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Eyestrain");
            put("word",   "E___tr___");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Insomnia");
            put("word",   "I____ni_");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Crick");
            put("word",   "Cr___");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Sore throat");
            put("word",   "S__e t___at");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Nose bleed");
            put("word",   "N___ bl__d");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Convulsion");
            put("word",   "C__vu____n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Fracture");
            put("word",   "F___t__e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Broken bone");
            put("word",   "___ken b__e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Burn");
            put("word",   "___n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Blister");
            put("word",   "_l__ter");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Conjunctivitis");
            put("word",   "__n___ct__it_s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Nauseous");
            put("word",   "_a_s_o_s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Vomit");
            put("word",   "V__it");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Bleeding");
            put("word",   "_l__di__");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Misshapen");
            put("word",   "M___h_p_n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Bruise");
            put("word",   "_ru__e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Cough");
            put("word",   "___gh");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Inflame");
            put("word",   "__f__me");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Runny nose");
            put("word",   "___ny n__e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Phlegm");
            put("word",   "P___gm");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Swollen");
            put("word",   "Sw____n");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Pus");
            put("word",   "P_s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Purulent");
            put("word",   "_u__l_nt");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Chronic");
            put("word",   "Chr__i_");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Hiccup");
            put("word",   "H__c_p");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Perspire");
            put("word",   "_e__pir_");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Rash");
            put("word",   "Ra__");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Short of breath");
            put("word",   "_h_rt o_ _r_a_h");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Itchy");
            put("word",   "_t_cy");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Dizzy");
            put("word",   "__z_y");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Fever");
            put("word",   "_e_er");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Backache");
            put("word",   "_a_k_c_e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Earache");
            put("word",   "__rac_e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Ache");
            put("word",   "A__e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Acute");
            put("word",   "A___e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Faint");
            put("word",   "___nt");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Fatigue");
            put("word",   "_a_i_u_");
        }});

        // Disease vocab
        words.add(new HashMap<String, String>() {{
            put("answer", "Gout");
            put("word",   "G___");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Hemorrhoids");
            put("word",   "__m___ho__s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Pneumonia");
            put("word",   "P__umo__a");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Gastritis");
            put("word",   "_a_t_i_is");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Enteritis");
            put("word",   "E__e_i__s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Food poisoning");
            put("word",   "F__d p__so___g");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Diarrhea");
            put("word",   "_i_r_h_a");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Jaundice");
            put("word",   "_a_n_i_e");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Cirrhosis");
            put("word",   "__r_h_s_s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Gallstones");
            put("word",   "_a__s__nes");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Diabetes");
            put("word",   "D__be__s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Tonsillitis");
            put("word",   "_o__i__i_is");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Measles");
            put("word",   "_e_s_es");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "German measles");
            put("word",   "_e_m_n _e_s_es");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Rubella");
            put("word",   "_u_e_la");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Cancer");
            put("word",   "C_n_er");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Chicken pox");
            put("word",   "C_i_k_n _ox");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Dengue fever");
            put("word",   "_e_g_e f_v_r");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Heart disease");
            put("word",   "_e_rt _i_e_se");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Whooping cough");
            put("word",   "_h_op_ng c_u_h");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Pertussis");
            put("word",   "_e_t___is");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Diphtheria");
            put("word",   "_i_h__e_ia");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Tetanus");
            put("word",   "T_t_n_s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Asthmatic");
            put("word",   "A__hm_t_c");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Sinusitis");
            put("word",   "S_n_s___s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Laryngitis");
            put("word",   "_a_y_g_t_s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Allergy");
            put("word",   "___er_y");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Depression");
            put("word",   "_e_r_s__on");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Cold");
            put("word",   "C__d");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Chronic");
            put("word",   "__ron_c");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Tuberculosis");
            put("word",   "__b_r_u_os_s");
        }});
        words.add(new HashMap<String, String>() {{
            put("answer", "Appendicitis");
            put("word",   "A__e_d_c_t_s");
        }});

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
