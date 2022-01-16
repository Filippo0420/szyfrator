package com.fpp.szyfrator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;


public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    private Button podstawieniowe, mors, cezar, plotkowy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = new AdView(this);

        mAdView.setAdSize(AdSize.BANNER);

        mAdView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        });

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

                Intent mor = new Intent(MainActivity.this, MorsActivity.class);
                startActivity(mor);
            }
        });

        cezar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent cez = new Intent(MainActivity.this, CezarActivity.class);
                startActivity(cez);
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

