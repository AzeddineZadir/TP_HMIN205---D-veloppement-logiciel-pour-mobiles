package com.example.tp3_exo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ShowInformationActivity extends AppCompatActivity {
    String USER_CODE ;
    TextView tv_info ;
    ArrayList<String> informations  = new ArrayList<String>();
    ListView lv_informations ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_information);
        tv_info = (TextView)findViewById(R.id.tv_info);
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                USER_CODE= null;
            } else {
                USER_CODE= extras.getString("USER_CODE");
            }
        }
        readFromFile(getApplicationContext());
        tv_info.setText(informations.get(0));

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