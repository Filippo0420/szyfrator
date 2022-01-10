package com.fpp.szyfrator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button podstawieniowe, mors, cezar, plotkowy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        podstawieniowe = findViewById(R.id.podstawieniowe);
        mors = findViewById(R.id.mors);
        cezar = findViewById(R.id.cezar);
        plotkowy = findViewById(R.id.plotkowy);

        podstawieniowe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent pod = new Intent(MainActivity.this, PodstawienioweActivity.class);
                startActivity(pod);
            }
        });

        mors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent mor = new Intent(MainActivity.this, MorsActivity.class);
                //startActivity(mor);
            }
        });

        cezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent cez = new Intent(MainActivity.this, CezarActivity.class);
                //startActivity(cez);
            }
        });

        plotkowy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent plot = new Intent(MainActivity.this, PlotkowyActivity.class);
                startActivity(plot);
            }
        });
    }
}

