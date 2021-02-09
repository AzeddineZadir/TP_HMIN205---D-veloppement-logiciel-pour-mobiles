package com.example.tp02_exo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    protected SensorManager sensormanager;
    protected List<Sensor> sensors;
    protected static HashMap<Integer, String> mySensors = new HashMap<Integer, String>();
    protected boolean[] existingSensors = new boolean [37];
    protected ArrayList<String> sensorsNames= new ArrayList<String>();
    protected ArrayList<String> messingSensorsName= new ArrayList<String>();
    ListView lv_undetectedSensors ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        add_sensors();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sensormanager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensors = sensormanager.getSensorList(Sensor.TYPE_ALL);

        lv_undetectedSensors = (ListView)findViewById(R.id.lv_undetectedSensors);

        for (Sensor s : sensors) {
            if (s != null) {
                sensorsNames.add(s.getStringType());
                Log.v("sensors type " , s.getType()+"------");
                existingSensors[s.getType()] = true;
            }
        }
    missingSensor();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                MainActivity.this,
                android.R.layout.simple_spinner_dropdown_item, messingSensorsName);

        lv_undetectedSensors.setAdapter(adapter);

    }
    public void add_sensors(){
        mySensors.put(-1, "INVALID");
        mySensors.put(1, "ACCELEROMETER");
        mySensors.put(2, "MAGNETIC_FIELD");
        mySensors.put(4, "GYROSCOPE");
        mySensors.put(5, "LIGHT");
        mySensors.put(6, "PRESSURE");
        mySensors.put(8, "PROXIMITY");
        mySensors.put(9, "GRAVITY");
        mySensors.put(10, "LINEAR_ACCELERATION");
        mySensors.put(11, "ROTATION_VECTOR");
        mySensors.put(12, "RELATIVE_HUMIDITY");
        mySensors.put(13, "AMBIENT_TEMPERATURE");
        mySensors.put(14, "MAGNETIC_FIELD_UNCALIBRATED");
        mySensors.put(15, "GAME_ROTATION_VECTOR");
        mySensors.put(16, "GYROSCOPE_UNCALIBRATED");
        mySensors.put(17, "SIGNIFICANT_MOTION");
        mySensors.put(18, "STEP_DETECTOR");
        mySensors.put(19, "STEP_COUNTER");
        mySensors.put(20, "GEOMAGNETIC_ROTATION_VECTOR");
        mySensors.put(21, "HEART_RATE");
        mySensors.put(28, "POSE_6DOF");
        mySensors.put(29, "STATIONARY_DETECT");
        mySensors.put(30, "MOTION_DETECT");
        mySensors.put(31, "HEART_BEAT");
        mySensors.put(33, "ADDITIONAL_INFO");
        mySensors.put(34, "LOW_LATENCY_OFFBODY_DETECT");
        mySensors.put(35, "ACCELEROMETER_UNCALIBRATED");
    }

    public void missingSensor(){
        for (int i = 0; i < existingSensors.length; i++ ){
            if ( !existingSensors[i]) {
                if (mySensors.get(i) != null) {
                    messingSensorsName.add(mySensors.get(i));

                }
            }
        }
    }
}