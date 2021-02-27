package com.example.tp3_exo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText et_nom, et_prenom,et_age , et_num ;
      ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if ((savedInstanceState != null) &&(savedInstanceState.containsKey("USER_CODE"))) {
            String val = savedInstanceState.getString("USER_CODE");
            Toast.makeText(this, "reprise de l'application  :" + val,
                    Toast.LENGTH_SHORT).show();
        }
        setContentView(R.layout.activity_main);
        et_nom =(EditText)findViewById(R.id.et_nom);
        et_prenom =(EditText)findViewById(R.id.et_prenom);
        et_age =(EditText)findViewById(R.id.et_age);
        et_num  =(EditText)findViewById(R.id.et_num);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("USER_CODE", generateUserCode());

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(),"text",Toast.LENGTH_SHORT);
    }

    public  String generateUserCode(){
        Random rand = new Random(); //instance of random class
        int upperbound = 2000;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);
        String user_code = et_nom.getText().toString()+et_prenom.getText().toString()+"/"+int_random+"/" ;
        return user_code ;
    }
}