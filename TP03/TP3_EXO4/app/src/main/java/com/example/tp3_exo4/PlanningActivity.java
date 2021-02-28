package com.example.tp3_exo4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

public class PlanningActivity extends AppCompatActivity {

    TextView tv_p1 ,tv_p2 ,tv_p3 ,tv_p4 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        tv_p1=(TextView)findViewById(R.id.tv_p1);
        tv_p2=(TextView)findViewById(R.id.tv_p2);
        tv_p3=(TextView)findViewById(R.id.tv_p3);
        tv_p4=(TextView)findViewById(R.id.tv_p4);

        PlanningModel model = new ViewModelProvider(this).get(PlanningModel.class);
        tv_p1.setText(model.getP1());
        tv_p2.setText(model.getP2());
        tv_p3.setText(model.getP3());
        tv_p4.setText(model.getP4());
    }
}