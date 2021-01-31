package com.example.tp1_exo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner sp_domain_competance ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp_domain_competance=(Spinner)findViewById(R.id.sp_domainCompetance);
        Resources res = getResources();
        
        String[] com = res.getStringArray(R.array.com);
        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,com);
        sp_domain_competance.setAdapter(adapter);
    }
}