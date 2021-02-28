package com.example.tp3_exo5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class PlanningActivity extends AppCompatActivity {

    TextView tv_p1 ,tv_p2 ,tv_p3 ,tv_p4 ;
    String planning = " 08h-10h : Rencontre avec MR  \n"+"10h-12h : Travailler le dossier recrutement \n"+"14h-16h : Réunion équipe \n"+"16h-18h : Préparation dossier vente.\n" ;
    Date currentTime = Calendar.getInstance().getTime();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);
        writeInFile(planning,getApplicationContext());

        tv_p1=(TextView)findViewById(R.id.tv_p1);
        tv_p2=(TextView)findViewById(R.id.tv_p2);
        tv_p3=(TextView)findViewById(R.id.tv_p3);
        tv_p4=(TextView)findViewById(R.id.tv_p4);

        PlanningModel model = new ViewModelProvider(this).get(PlanningModel.class);
        Observer<ArrayList<String>> planning_observer= new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                tv_p1.setText(strings.get(0));
                tv_p1.setText(strings.get(0));
                tv_p2.setText(strings.get(1));
                tv_p3.setText(strings.get(2));
                tv_p4.setText(strings.get(3));
            }
        };
        model.getPlanning(getApplicationContext(),currentTime.toString()).observe(this,planning_observer);

    }

    private void writeInFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(currentTime.toString()+".txt", Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();

        } catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }

    }


}