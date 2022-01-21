package com.fpp.szyfrator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class MorsActivity extends AppCompatActivity {

    private Button szyfruj, deszyfruj, wroc;
    private ImageButton zmiana;
    private EditText wprowadz;
    private TextView wyswietl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mors);

        szyfruj = findViewById(R.id.szyfruj);
        deszyfruj = findViewById(R.id.deszyfruj);
        zmiana = findViewById(R.id.zamiana);
        wroc = findViewById(R.id.wroc);
        wprowadz = findViewById(R.id.wprowadz);
        wyswietl = findViewById(R.id.wyswietl);

        szyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wyswietl.setText(szyfruj(wprowadz.getText().toString()));
            }
        });

        deszyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wyswietl.setText(deszyfruj(wprowadz.getText().toString()));
            }
        });

        zmiana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wprowadz.setText(wyswietl.getText().toString());
                wyswietl.setText("");
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

    public String deszyfruj(String tekst){
        String odszyfrowane = "";
        tekst = tekst.replaceAll("//", "/ /");
        String podzielone[] = tekst.split("/");

        for (int i = 0; i < podzielone.length; i++) {
            switch (podzielone[i]){
                case ".-":
                    odszyfrowane += "a";
                    break;
                case "-...":
                    odszyfrowane += "b";
                    break;
                case "-.-.":
                    odszyfrowane += "c";
                    break;
                case "-..":
                    odszyfrowane += "d";
                    break;
                case ".":
                    odszyfrowane += "e";
                    break;
                case "..-.":
                    odszyfrowane += "f";
                    break;
                case "--.":
                    odszyfrowane += "g";
                    break;
                case "....":
                    odszyfrowane += "h";
                    break;
                case "..":
                    odszyfrowane += "i";
                    break;
                case ".---":
                    odszyfrowane += "j";
                    break;
                case "-.-":
                    odszyfrowane += "k";
                    break;
                case ".-..":
                    odszyfrowane += "l";
                    break;
                case "--":
                    odszyfrowane += "m";
                    break;
                case "-.":
                    odszyfrowane += "n";
                    break;
                case "---":
                    odszyfrowane += "o";
                    break;
                case ".--.":
                    odszyfrowane += "p";
                    break;
                case ".-.":
                    odszyfrowane += "r";
                    break;
                case "...":
                    odszyfrowane += "s";
                    break;
                case "-":
                    odszyfrowane += "t";
                    break;
                case "..-":
                    odszyfrowane += "u";
                    break;
                case ".--":
                    odszyfrowane += "w";
                    break;
                case "-..-":
                    odszyfrowane += "x";
                    break;
                case "-.--":
                    odszyfrowane += "y";
                    break;
                case "--..":
                    odszyfrowane += "z";
                    break;
                case "/":
                    odszyfrowane += " ";
                    break;
                case "--.-":
                    odszyfrowane += "q";
                    break;
                case "...-":
                    odszyfrowane += "v";
                    break;
                case ".----":
                    odszyfrowane += "1";
                    break;
                case "..--":
                    odszyfrowane += "2";
                    break;
                case "...--":
                    odszyfrowane += "3";
                    break;
                case "....-":
                    odszyfrowane += "4";
                    break;
                case ".....":
                    odszyfrowane += "5";
                    break;
                case "-....":
                    odszyfrowane += "6";
                    break;
                case "--...":
                    odszyfrowane += "7";
                    break;
                case "---..":
                    odszyfrowane += "8";
                    break;
                case "----.":
                    odszyfrowane += "9";
                    break;
                case "-----":
                    odszyfrowane += "0";
                    break;
                default:
                    odszyfrowane += podzielone[i];
            }
        }


        return odszyfrowane;
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
                    zaszyfrowane += "....-/";
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