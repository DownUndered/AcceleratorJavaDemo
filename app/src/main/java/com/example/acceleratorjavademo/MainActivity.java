package com.example.acceleratorjavademo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;

import android.view.View;




public class MainActivity extends AppCompatActivity implements SensorEventListener{

    private TextView xText, yText, zText;
    private Sensor positionSensor;
    private SensorManager SM;

    View view;



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

        //Assign layout to view
        view = findViewById(R.id.myLayout);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        xText.setText("X: " + event.values[0]);
        yText.setText("Y: " + event.values[1]);
        zText.setText("Z: " + event.values[2]);
        //Playing with changing text colours depending on values
        float x = event.values[0], y = event.values[1], z = event.values[2];


        //Changing background colors on event values change
        if(event.values[1] > 0.5f) { // anticlockwise
            view.setBackgroundColor(Color.parseColor("#616161"));
        } else if(event.values[1] < -0.5f) { // clockwise
            view.setBackgroundColor(Color.parseColor("#006064"));
        }

        if(event.values[0] > 0.5f) { // anticlockwise
            view.setBackgroundColor(Color.parseColor("#D84315"));
        } else if(event.values[0] < -0.5f) { // clockwise
            view.setBackgroundColor(Color.parseColor("#D1C4E9"));
        }


        //Changing text and backgrounds colors
        if ( x >= 0 )   {
            xText.setTextColor(Color.GREEN);
            //view.setBackgroundColor(Color.parseColor("#616161"));

        } else {
            xText.setTextColor(Color.RED);
            //view.setBackgroundColor(Color.parseColor("#006064"));
        }

        if ( y >= 0 ) {
            yText.setTextColor(Color.GREEN);

        } else {
            yText.setTextColor(Color.RED);

        }

        if ( z >= 0 ) {
            zText.setTextColor(Color.GREEN);
            //view.setBackgroundColor(Color.parseColor("#006064"));
        } else {
            zText.setTextColor(Color.RED);
            //view.setBackgroundColor(Color.parseColor("#616161"));

        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
        //Not in use
    }
}
