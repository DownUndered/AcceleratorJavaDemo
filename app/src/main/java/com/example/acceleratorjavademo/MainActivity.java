package com.example.acceleratorjavademo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView xText, yText, zText;
    private Sensor positionSensor;
    private SensorManager SM;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create sensor manager
        SM = (SensorManager)getSystemService(SENSOR_SERVICE);

        //Accelerometer sensor
        positionSensor = SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        //Register sensor listener
        SM.registerListener(this, positionSensor, SensorManager.SENSOR_DELAY_NORMAL);

        //Assign text views
        xText = (TextView)findViewById(R.id.xText);
        yText = (TextView)findViewById(R.id.yText);
        zText = (TextView)findViewById(R.id.zText);







    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);
        //Playing with changing text colours depending on values
        float x = event.values[0];
        float y = event.values[1];
        float z = event.values[1];



        if ( x >= 0 )   {
            xText.setTextColor(Color.GREEN);

        } else {
            xText.setTextColor(Color.RED);

        }

        if ( y >= 0 ) {
            yText.setTextColor(Color.GREEN);
        } else {
            yText.setTextColor(Color.RED);
        }

        if ( z >= 0 ) {
            zText.setTextColor(Color.GREEN);
        } else {
            zText.setTextColor(Color.RED);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //Not in use
    }
}
