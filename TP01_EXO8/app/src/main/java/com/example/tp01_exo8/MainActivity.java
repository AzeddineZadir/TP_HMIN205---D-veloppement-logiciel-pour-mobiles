package com.example.tp01_exo8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements go_to.SendMessages {
    ListView lv_horaires ;
    ArrayAdapter<String>adapter;
    ListAdapter list_adapter;
    List<HashMap<String, String>> liste = new ArrayList<HashMap<String, String>>();
    HashMap<String, String> element ;
    private static final String[] VILLES = new String[]{"Paris","Montpellier","Lyon","Nime","Lille","Strasbourg",
            "Grenoble","Tours","Perpignan","Toulouse","Marseille",
            "Nantes","Nice","Bordeaux","Rennes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_horaires= (ListView)findViewById(R.id.lv_horaires);



    }

    // receive data form fragments
    @Override
    public void iAmMSG(String msg) {
        String d = msg.split(":")[0];
        String a = msg.split(":")[1];
        final String[][] hors = new String[][]{
                {"Lundi","8:00"},{"Lundi","9:00"},{"Lundi","10:00"},{"Lundi","11:00"},{"Lundi","12:00"},{"Lundi","13:00"},
                {"Mardi","8:00"},{"Mardi","9:00"},{"Mardi","10:00"},{"Mardi","11:00"},{"Mardi","12:00"},{"Mardi","13:00"},
                {"Mercredi","8:00"},{"Mercredi","9:00"},{"Mercredi","10:00"},{"Mercredi","11:00"},{"Mercredi","12:00"},{"Mercredi","13:00"},
                {"Jeudi","8:00"},{"Jeudi","9:00"},{"Jeudi","10:00"},{"Jeudi","11:00"},{"Jeudi","12:00"},{"Jeudi","13:00"},
                {"Vendredi","8:00"},{"Vendredi","9:00"},{"Vendredi","10:00"},{"Vendredi","11:00"},{"Vendredi","12:00"},{"Vendredi","13:00"},
                {"Samedi","8:00"},{"Samedi","9:00"},{"Samedi","10:00"},{"Samedi","11:00"},{"Samedi","12:00"},{"Samedi","13:00"},
                {"Dimanche","11:00"}
        };
        for (int i=0; i<hors.length;i++){
            element = new HashMap<String, String>();
            element.put("v1",hors[i][0]);
            element.put("v2",hors[i][1]);
            liste.add(element);
            list_adapter = new SimpleAdapter(this,liste,android.R.layout.simple_list_item_2,
                    new String[]{"v1","v2"},new int[] {android.R.id.text1,android.R.id.text2});
        }
        adapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,VILLES);
        lv_horaires.setAdapter(list_adapter);
    }
}