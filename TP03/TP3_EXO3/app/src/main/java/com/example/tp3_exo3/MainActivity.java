package com.example.tp3_exo3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText et_nom, et_prenom,et_age , et_num ;
    String USER_CODE ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // adding an lifecycle observer
        getLifecycle().addObserver(new Utilisation());
        if ((savedInstanceState != null) &&(savedInstanceState.containsKey("USER_CODE"))) {
            String val = savedInstanceState.getString("USER_CODE");
            Toast.makeText(this, "reprise de l'application  :" + val,
                    Toast.LENGTH_SHORT).show();
        }
        et_nom =(EditText)findViewById(R.id.et_nom);
        et_prenom =(EditText)findViewById(R.id.et_prenom);
        et_age =(EditText)findViewById(R.id.et_age);
        et_num  =(EditText)findViewById(R.id.et_num);





    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("USER_CODE", USER_CODE);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Toast.makeText(getApplicationContext(),"text",Toast.LENGTH_SHORT).show();
    }

    public  String generateUserCode(){
        Random rand = new Random(); //instance of random class
        int upperbound = 2000;
        //generate random values from 0-24
        int int_random = rand.nextInt(upperbound);

        return et_nom.getText().toString()+"_"+int_random ;
    }

    private void writeInFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(USER_CODE+".sav", Context.MODE_APPEND));
            outputStreamWriter.write(data);
            outputStreamWriter.close();

        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }


    public void showInfo(View view) {
        USER_CODE = generateUserCode() ;
        String text_to_writ = et_nom.getText().toString()+"\n"+et_prenom.getText().toString()+"\n"+et_age.getText().toString()+"\n"+et_num.getText().toString();
        writeInFile(text_to_writ,getApplicationContext());

        Intent intent = new Intent(MainActivity.this, ShowInformationActivity.class);
        int NB_UTIL = Utilisation.nbr ;
        intent.putExtra("NB_UTIL",NB_UTIL);
        intent.putExtra("USER_CODE",USER_CODE);
        startActivity(intent);
    }
}