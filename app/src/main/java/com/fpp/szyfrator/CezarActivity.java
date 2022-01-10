package com.fpp.szyfrator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class CezarActivity extends AppCompatActivity {

    private Button szyfruj, deszyfruj;
    private EditText wprowadz;
    private TextView wyswietl, klucztxt;
    private SeekBar klucz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cezar);

        szyfruj = findViewById(R.id.szyfruj);
        deszyfruj = findViewById(R.id.deszyfruj);
        wprowadz = findViewById(R.id.wprowadz);
        wyswietl = findViewById(R.id.wyswietl);
        klucz = findViewById(R.id.klucz);
        klucztxt = findViewById(R.id.klucztxt);

        klucztxt.setText("Przesunięcie: " + klucz.getProgress());

        klucz.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                klucztxt.setText("Przesunięcie: " + i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        szyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wyswietl.setText(encrypt(wprowadz.getText().toString(), klucz.getProgress()));
            }
        });

        deszyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wyswietl.setText(decrypt(wprowadz.getText().toString(), klucz.getProgress()));
            }
        });
    }


    private static String encrypt(String txt, int key ) {
        String encrypted = "";

        for (int i = 0; i < txt.length(); i++)
        {
            if (Character.isUpperCase(txt.charAt(i)))
            {
                int characterIndex = (txt.charAt(i)) - ('A');
                int characterShifted = (characterIndex + key) % 26 +  ('A');
                encrypted += (char)(characterShifted);
            }
            else if (Character.isLowerCase(txt.charAt(i)))
            {
                int characterIndex = (txt.charAt(i)) - ('a');
                int characterShifted = (characterIndex + key) % 26 +  ('a');
                encrypted += (char)(characterShifted);
            }
            else if (Character.isDigit(txt.charAt(i)))
            {
                int  characterNew = ((int)(txt.charAt(i)) + key) % 10;
                encrypted += (char)(characterNew);
            }
            else
            {
                encrypted += txt.charAt(i);
            }
        }
        return encrypted;
    }

    private static String decrypt(String txt, int key ) {
        String decrypted = "";
        key = key % 26;

        for (int i = 0; i < txt.length(); i++)
        {
            if (Character.isUpperCase(txt.charAt(i)))
            {
                int characterIndex = (txt.charAt(i)) - ('A');
                int characterOrgPos = (characterIndex - key) % 26 +  ('A');
                decrypted += (char)(characterOrgPos);
            }
            else if (Character.isLowerCase(txt.charAt(i)))
            {
                int characterIndex = (txt.charAt(i)) - ('a');
                int characterOrgPos = (characterIndex - key) % 26 +  ('a');
                decrypted += (char)(characterOrgPos);
            }
            else if (Character.isDigit(txt.charAt(i)))
            {
                int  characterOrgPos = ((int)(txt.charAt(i)) - key) % 10;
                decrypted += (char)(characterOrgPos);
            }
            else
            {
                decrypted += txt.charAt(i);
            }
        }
        return decrypted;
    }

}