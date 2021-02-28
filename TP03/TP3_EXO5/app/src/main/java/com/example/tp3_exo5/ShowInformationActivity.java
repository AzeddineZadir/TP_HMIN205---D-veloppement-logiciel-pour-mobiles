package com.example.tp3_exo5;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShowInformationActivity extends AppCompatActivity {
    String USER_CODE ;
    int NB_UTIL ;
    TextView tv_nom_info ,tv_nbr_utilisation,tv_prenom_info , tv_age_info,tv_num_info;

    ArrayList<String> informations  = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information);
        tv_nom_info = (TextView)findViewById(R.id.tv_nom_info);
        tv_prenom_info = (TextView)findViewById(R.id.tv_prenom_info);
        tv_age_info = (TextView)findViewById(R.id.tv_age_info);
        tv_num_info = (TextView)findViewById(R.id.tv_num_info);
        tv_nbr_utilisation = (TextView)findViewById(R.id.tv_nbr_utilisation);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                USER_CODE= null;
            } else {
                USER_CODE= extras.getString("USER_CODE");
                NB_UTIL = extras.getInt("NB_UTIL");
            }
        }
        readFromFile(getApplicationContext());
        tv_nom_info.setText(informations.get(0));
        tv_prenom_info.setText(informations.get(1));
        tv_age_info.setText(informations.get(2));
        tv_num_info.setText(informations.get(3));



        tv_nbr_utilisation.setText("nombre d'utilisation  :"+NB_UTIL);
    }

    private void readFromFile(Context context) {

        String text = "file not found ";
        String temp = " ";
        try {
            InputStream inputStream = context.openFileInput(USER_CODE+".sav");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                while ( (receiveString = bufferedReader.readLine()) != null ) {

                    informations.add(receiveString);

                }

                inputStream.close();
            }


        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }



    }
}