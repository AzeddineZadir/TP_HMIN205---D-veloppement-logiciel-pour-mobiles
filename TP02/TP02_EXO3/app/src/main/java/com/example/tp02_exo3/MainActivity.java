package com.example.tp02_exo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity  implements SensorEventListener2 {
    protected SensorManager sensorManager ;
    private Sensor accelerometerSensor;
    private TextView tv_sensor ;
    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        tv_sensor = (TextView) findViewById(R.id.tv_sensor);

        v = this.getWindow().getDecorView();
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
    public void onFlushCompleted(Sensor sensor) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int sensorType = event.sensor.getType();
        switch(sensorType){
            case Sensor.TYPE_ACCELEROMETER:
                onAccelerometerChanger(event);
                break;
        }
    }

    private void onAccelerometerChanger(SensorEvent event) {
        float x,y,z;
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];

        tv_sensor.setText("x = "+x+"y = "+y+ "z ="+z);
        if(Math.abs(x) < 2 || Math.abs(y) < 2 || Math.abs(z) < 2){
            v.setBackgroundColor(getResources().getColor(R.color.c1));
            tv_sensor.setText("x ="+ x);
        }else {
            if(Math.abs(x) < 4 || Math.abs(y) < 4 || Math.abs(z) < 4){
                v.setBackgroundColor(getResources().getColor(R.color.c2));
            }else{
                v.setBackgroundColor(getResources().getColor(R.color.c3));
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}