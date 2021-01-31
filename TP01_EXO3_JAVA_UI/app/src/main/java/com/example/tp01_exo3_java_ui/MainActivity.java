package com.example.tp01_exo3_java_ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout llp, ll1, ll2, ll3, ll4, ll5, ll6,ll7;
    TextView tv_titre, tv_nom, tv_prenom, tv_age, tv_num,tv_domain;
    EditText et_nom, et_prenom, et_age ,et_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        llp = new LinearLayout(this);
        llp.setOrientation(LinearLayout.VERTICAL);

        tv_titre = new TextView(this);
        tv_titre.setText("TP01_EXO3_JAVA_UI");
        ll1 = new LinearLayout((this));
        ll1.setOrientation(LinearLayout.HORIZONTAL);
        ll1.addView(tv_titre);
        llp.addView(ll1);

        ll2 = new LinearLayout((this));
        ll2.setOrientation(LinearLayout.HORIZONTAL);
        tv_nom = new TextView(this);
        String name = getString(R.string.name);
        tv_nom.setText(name);
        et_nom = new EditText(this);
        ll2.addView(tv_nom);
        ll2.addView(et_nom);
        llp.addView(ll2);

        ll3 = new LinearLayout((this));
        ll3.setOrientation(LinearLayout.HORIZONTAL);
        tv_prenom = new TextView(this);
        String last_name = getString(R.string.last_name);
        
        tv_prenom.setText(last_name);
        et_prenom = new EditText(this);
        ll3.addView(tv_prenom);
        ll3.addView(et_prenom);
        llp.addView(ll3);

        ll4 = new LinearLayout(this);
        ll4.setOrientation(LinearLayout.HORIZONTAL);
        tv_age = new TextView(this);
        String age = getString(R.string.age);
        tv_age.setText(age);
        et_age = new EditText(this);
        ll4.addView(tv_age);
        ll4.addView(et_age);
        llp.addView(ll4);


        ll5 = new LinearLayout((this));
        ll5.setOrientation(LinearLayout.HORIZONTAL);
        tv_num = new TextView(this);
        String num = getString(R.string.mobile);
        tv_num.setText(num);
        et_num = new EditText(this);
        ll5.addView(tv_num);
        ll5.addView(et_num);
        llp.addView(ll5);


        ll6 = new LinearLayout((this));
        ll6.setOrientation(LinearLayout.HORIZONTAL);
        tv_domain= new TextView(this);
        String domaine = getString(R.string.competance_feild);
        tv_domain.setText(domaine);
        Spinner sp_dom = new Spinner(this);
        Resources res = getResources();
        String[] com = res.getStringArray(R.array.com);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,com);
        sp_dom.setAdapter(adapter);
        ll6.addView(tv_domain);
        ll6.addView(sp_dom);
        llp.addView(ll6);

        ll7 = new LinearLayout((this));
        ll7.setOrientation(LinearLayout.HORIZONTAL);
        Button b_valider = new Button(this);
       String valider = getString(R.string.validate);
        b_valider.setText(valider);
        ll7.addView(b_valider);
        llp.addView(ll7);

        setContentView(llp);
    }
}