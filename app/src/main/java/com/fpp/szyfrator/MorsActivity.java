package com.fpp.szyfrator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MorsActivity extends AppCompatActivity {

    private Button szyfruj, wroc;
    private EditText wprowadz;
    private TextView wyswietl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mors);

        szyfruj = findViewById(R.id.szyfruj);
        wroc = findViewById(R.id.wroc);
        wprowadz = findViewById(R.id.wprowadz);
        wyswietl = findViewById(R.id.wyswietl);

        szyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wyswietl.setText(szyfruj(wprowadz.getText().toString()));
            }
        });

        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wracaj = new Intent(MorsActivity.this, MainActivity.class);
                startActivity(wracaj);
            }
        });
    }

    public String szyfruj(String tekst){
        String zaszyfrowane = "";
        for(int i = 0; i<tekst.length(); i++){
            switch (tekst.substring(i, i+1).toLowerCase()){
                case "a":
                    zaszyfrowane += ".-/";
                    break;
                case "b":
                    zaszyfrowane += "-.../";
                    break;
                case "c":
                    zaszyfrowane += "-.-./";
                    break;
                case "d":
                    zaszyfrowane += "-../";
                    break;
                case "e":
                    zaszyfrowane += "./";
                    break;
                case "f":
                    zaszyfrowane += "..-./";
                    break;
                case "g":
                    zaszyfrowane += "--./";
                    break;
                case "h":
                    zaszyfrowane += "..../";
                    break;
                case "i":
                    zaszyfrowane += "../";
                    break;
                case "j":
                    zaszyfrowane += ".---/";
                    break;
                case "k":
                    zaszyfrowane += "-.-/";
                    break;
                case "l":
                    zaszyfrowane += ".-../";
                    break;
                case "m":
                    zaszyfrowane += "--/";
                    break;
                case "n":
                    zaszyfrowane += "-./";
                    break;
                case "o":
                    zaszyfrowane += "---/";
                    break;
                case "p":
                    zaszyfrowane += ".--./";
                    break;
                case "r":
                    zaszyfrowane += ".-./";
                    break;
                case "s":
                    zaszyfrowane += ".../";
                    break;
                case "t":
                    zaszyfrowane += "-/";
                    break;
                case "u":
                    zaszyfrowane += "..-/";
                    break;
                case "w":
                    zaszyfrowane += ".--/";
                    break;
                case "x":
                    zaszyfrowane += "-..-/";
                    break;
                case "y":
                    zaszyfrowane += "-.--/";
                    break;
                case "z":
                    zaszyfrowane += "--../";
                    break;
                case " ":
                    zaszyfrowane += "/";
                    break;
                case "q":
                    zaszyfrowane += "--.-/";
                    break;
                case "v":
                    zaszyfrowane += "...-/";
                    break;
                case "1":
                    zaszyfrowane += ".----/";
                    break;
                case "2":
                    zaszyfrowane += "..--/";
                    break;
                case "3":
                    zaszyfrowane += "...--/";
                    break;
                case "4":
                    zaszyfrowane += "...-/";
                    break;
                case "5":
                    zaszyfrowane += "...../";
                    break;
                case "6":
                    zaszyfrowane += "-..../";
                    break;
                case "7":
                    zaszyfrowane += "--.../";
                    break;
                case "8":
                    zaszyfrowane += "---../";
                    break;
                case "9":
                    zaszyfrowane += "----./";
                    break;
                case "0":
                    zaszyfrowane += "-----/";
                    break;
                case ".":
                    zaszyfrowane += "/";
                    break;
                default:
                    zaszyfrowane += "";
            }

        }
        return zaszyfrowane;
    }
}