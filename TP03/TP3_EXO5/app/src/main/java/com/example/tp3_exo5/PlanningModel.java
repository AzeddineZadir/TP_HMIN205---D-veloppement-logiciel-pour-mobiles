package com.example.tp3_exo5;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class PlanningModel extends ViewModel {
    MutableLiveData<ArrayList<String>> planning;
    ArrayList<String> list_planning = new ArrayList<String>();


    private String p1;
    private String p2;
    private String p3;
    private String p4;


    public String getP1() {
        return this.p1;
    }

    public String getP2() {
        return this.p2;
    }

    public String getP3() {
        return this.p3;
    }

    public String getP4() {
        return this.p4;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }


    public LiveData<ArrayList<String>> getPlanning(Context context ,String date) {
        if (planning == null) {
            planning = new MutableLiveData<ArrayList<String>>();
            loadFromFile(context,date);
        }
        return planning;
    }


    private void loadFromFile(Context context,String date) {

        String text = "file not found ";
        String temp = " ";
        try {
            InputStream inputStream = context.openFileInput(date+".txt");

            if (inputStream != null) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                while ((receiveString = bufferedReader.readLine()) != null) {

                    list_planning.add(receiveString);

                }
                planning.postValue(list_planning);
                inputStream.close();
            }


        } catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }
    }
}
