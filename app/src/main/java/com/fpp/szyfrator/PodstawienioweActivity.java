package com.fpp.szyfrator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

public class PodstawienioweActivity extends AppCompatActivity {

    private Spinner szyfrPod;
    private TextView jakiSzyfr, wyjscie;
    private EditText doZaszyfrowania;
    private Button szyfruj, wroc;
    String szyfr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podstawieniowe);

        String gotowe;

        szyfrPod = findViewById(R.id.szyfryPod);
        jakiSzyfr = findViewById(R.id.aktualnySzyfr);
        doZaszyfrowania = findViewById(R.id.wejscie);
        wyjscie = findViewById(R.id.wyjscie);
        szyfruj = findViewById(R.id.szyfruj);
        wroc = findViewById(R.id.wroc);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.szyfry, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        szyfrPod.setAdapter(adapter);

        szyfrPod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                szyfr = adapter.getItem(position).toString().toLowerCase();
                jakiSzyfr.setText("Aktualny szyfr: " + szyfr);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        szyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String pobranyTekstS = doZaszyfrowania.getText().toString();
                szyfrowanie(pobranyTekstS);
            }
        });

        wroc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent wracaj = new Intent(PodstawienioweActivity.this, MainActivity.class);
                startActivity(wracaj);
            }
        });
    }

    public void szyfrowanie(String tekst){

        String[] kolejne = new String[szyfr.length()];

        tekst = tekst.toLowerCase(Locale.ROOT);

        kolejne[0] = tekst.replaceAll(szyfr.substring(0, 1), szyfr.substring(1, 2).toUpperCase()); // pierwsza na druga
        kolejne[1] = kolejne[0].replaceAll(szyfr.substring(1, 2), szyfr.substring(0, 1).toUpperCase()); // druga na pierwsza

        kolejne[2] = kolejne[1].replaceAll(szyfr.substring(2, 3), szyfr.substring(3, 4).toUpperCase()); // trzecia na czwarta
        kolejne[3] = kolejne[2].replaceAll(szyfr.substring(3, 4), szyfr.substring(2, 3).toUpperCase()); // czwarta na trzecia

        kolejne[4] = kolejne[3].replaceAll(szyfr.substring(4, 5), szyfr.substring(5, 6).toUpperCase()); // piata na szosta
        kolejne[5] = kolejne[4].replaceAll(szyfr.substring(5, 6), szyfr.substring(4, 5).toUpperCase()); // szosta na piata

        kolejne[6] = kolejne[5].replaceAll(szyfr.substring(6, 7), szyfr.substring(7, 8).toUpperCase()); // siodma na osma
        kolejne[7] = kolejne[6].replaceAll(szyfr.substring(7, 8), szyfr.substring(6, 7).toUpperCase()); // osma na siodma

        kolejne[8] = kolejne[7].replaceAll(szyfr.substring(8, 9), szyfr.substring(9, 10).toUpperCase()); // dziewiata na dziesiata
        kolejne[9] = kolejne[8].replaceAll(szyfr.substring(9, 10), szyfr.substring(8, 9).toUpperCase()); // dziesiata na dziewiata

        kolejne[10] = kolejne[9].replaceAll(szyfr.substring(10, 11), szyfr.substring(11, 12).toUpperCase()); // jedenasta na dwunasta
        kolejne[11] = kolejne[10].replaceAll(szyfr.substring(11, 12), szyfr.substring(10, 11).toUpperCase()); // dwunasta na jedenasta

        String zaszyfrowane = kolejne[11].toLowerCase();

        wyjscie.setText(zaszyfrowane);
    }
}