package com.example.tp01_exo7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    TextView tv_d_nom ,tv_d_prenom,tv_d_age,tv_d_domaine,tv_d_mobile ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        tv_d_nom = (TextView)findViewById(R.id.tv_d_nom);
        tv_d_nom.setText(getIntent().getExtras().getString("nom"));

        tv_d_prenom = (TextView)findViewById(R.id.tv_d_prenom);
        tv_d_prenom.setText(getIntent().getExtras().getString("prenom"));

        tv_d_age = (TextView)findViewById(R.id.tv_d_age);
        tv_d_age.setText(getIntent().getExtras().getString("age"));

        tv_d_domaine = (TextView)findViewById(R.id.tv_d_domaine);
        tv_d_domaine.setText(getIntent().getExtras().getString("domaine"));

        tv_d_mobile = (TextView)findViewById(R.id.tv_d_mobile);
        tv_d_mobile.setText(getIntent().getExtras().getString("mobile"));
    }

    public void b_ok(View view) {
        Intent i = new Intent(this,Activity3.class);
        String mobile =tv_d_mobile.getText().toString() ;
        i.putExtra("mobile",mobile);
        startActivity(i);
        finish();
    }

    public void b_retour(View view) {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }
}