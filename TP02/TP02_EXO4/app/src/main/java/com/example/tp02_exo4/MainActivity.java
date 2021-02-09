package com.example.tp02_exo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements SensorEventListener {
    protected SensorManager sensorManager ;
    private Sensor accelerometerSensor;
    private TextView tv_sensor ;
    ImageView iv_up,iv_down , iv_r ,iv_l ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        tv_sensor = (TextView) findViewById(R.id.tv_sensor);

        iv_up =(ImageView)findViewById(R.id.iv_up);
        iv_up.setVisibility(View.INVISIBLE);
        iv_down =(ImageView)findViewById(R.id.iv_down);
        iv_down.setVisibility(View.INVISIBLE);
        iv_r =(ImageView)findViewById(R.id.iv_r);
        iv_r.setVisibility(View.INVISIBLE);
        iv_l =(ImageView)findViewById(R.id.iv_l);
        iv_l.setVisibility(View.INVISIBLE);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (accelerometerSensor == null) { tv_sensor.setText("sensor_error"); }
        if (accelerometerSensor != null) {
            sensorManager.registerListener(this, accelerometerSensor,
                    SensorManager.SENSOR_DELAY_NORMAL);
        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        sensorManager.unregisterListener(this);
    }



    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        switch(sensorType){
            case Sensor.TYPE_LINEAR_ACCELERATION:
                onLinearAccelerometerChanger(event);
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void onLinearAccelerometerChanger(SensorEvent event) {
        float x,y,z;
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];

        if(z > 5 ){
            iv_down.setVisibility(View.VISIBLE);
            iv_up.setVisibility(View.INVISIBLE);
        }else {
            if (z < -5) {
                iv_up.setVisibility(View.VISIBLE);
                iv_down.setVisibility(View.INVISIBLE);
            }

            if (x > 5) {
                iv_l.setVisibility(View.VISIBLE);
                iv_r.setVisibility(View.INVISIBLE);
            } else {
                if (x < -5) {
                    iv_r.setVisibility(View.VISIBLE);
                    iv_l.setVisibility(View.INVISIBLE);
                }
            }

        }
    }
}