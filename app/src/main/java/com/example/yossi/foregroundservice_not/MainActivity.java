package com.example.yossi.foregroundservice_not;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btnStart,btnStop;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);

        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v==btnStart)
        {
            Intent intent = new Intent(this,PushNotService.class);
            startService(intent);
        }
        else if(v==btnStop)
        {
            Intent intent = new Intent(this,PushNotService.class);
            stopService(intent);
        }

    }
}
