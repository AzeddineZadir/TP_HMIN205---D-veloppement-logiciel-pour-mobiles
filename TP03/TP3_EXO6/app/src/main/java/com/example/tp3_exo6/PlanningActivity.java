package com.example.tp3_exo6;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tp3_exo6.Entitys.Jour;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
        /*Observer<ArrayList<String>> planning_observer= new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                tv_p1.setText(strings.get(0));
                tv_p1.setText(strings.get(0));
                tv_p2.setText(strings.get(1));
                tv_p3.setText(strings.get(2));
                tv_p4.setText(strings.get(3));
            }
        };
        model.getPlanning(getApplicationContext(),currentTime.toString()).observe(this,planning_observer);*/
        Observer <List<Jour>> jourObserver = new Observer<List<Jour>>() {
            @Override
            public void onChanged(List<Jour> jours) {
                tv_p1.setText(jours.get(0).getP1());
                tv_p2.setText(jours.get(0).getP2());
                tv_p3.setText(jours.get(0).getP3());
                tv_p4.setText(jours.get(0).getP4());
            }
        };

        model.getJours(getApplicationContext(),currentTime.toString()).observe(this,jourObserver);
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