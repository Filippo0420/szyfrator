package com.fpp.szyfrator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PlotkowyActivity extends AppCompatActivity {

    private EditText wejscie;
    private TextView wyjscie;
    private Button zaszyfruj;

    String tekst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plotkowy);

        wejscie = findViewById(R.id.wejscie32);
        wyjscie = findViewById(R.id.wyjscie);
        zaszyfruj = findViewById(R.id.szyfruj);

        tekst = wejscie.getText().toString();

        zaszyfruj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //String zaszyfrowane = zaszyf(tekst, 5);
                Integer dlu = Integer.parseInt(String.valueOf(tekst.length()));
                wyjscie.setText(tekst);
            }
        });
    }

    /*public String szyfruj(String tekstJawny, int iloscWierszy){
        String szyfrogram = "";

        String[] tabelaPlotek = new String[iloscWierszy];

        int r = 0;
        int kierunek = 1;

        for(int i = 0; i < tekstJawny.length(); i++){
            tabelaPlotek[r] = tekstJawny.substring(i, i+1);

            if(((r == iloscWierszy - 1) && (kierunek == 1)) || ((r == 0) && (kierunek == -1))){
                kierunek = -kierunek;
            }

            r = r + kierunek;
        }

        int wiersz = 0;
        while(wiersz < iloscWierszy){
            for(int j = 0; j < tabelaPlotek[wiersz].length(); j++){
                szyfrogram = szyfrogram.concat(tabelaPlotek[wiersz].substring(j, j+1));
            }
            wiersz++;
        }
        return szyfrogram;

    }*/

    public String zaszyf(String tekstJawny, int iloscWierszy){
        String szyfrogram = "";

        String[] tabelaPlotek = new String[iloscWierszy];
        int k = 0;

        for(int t = 0; t < iloscWierszy; t++){
            tabelaPlotek[t] = "";
        }

        while(k != tekstJawny.length()-1){
            for(int j = 0; j < iloscWierszy; j++){
                tabelaPlotek[k] += tekstJawny.substring(k, k+1);
            }
            for(int i = 3; i > 0; i--){
                tabelaPlotek[k] += tekstJawny.substring(k, k+1);
            }
            k++;
        }

        for(int h = 0; h < iloscWierszy; h++){
            szyfrogram += tabelaPlotek[h];
        }


        return szyfrogram;
    }
}

/*

function szyfruj(tekstJawny, iloscWierszy) {
  var szyfrogram = '';

  var tabelaPlotek = [];
  for (var poz = 0; poz < iloscWierszy; ++poz) {
    tabelaPlotek[poz] = [];
  }

  // Najpierw, wpisz litery do tabeli:

  var r = 0;
  var kierunek = 1;

  for (var c = 0; c < tekstJawny.length; ++c) {
    tabelaPlotek[r].push(tekstJawny[c]);

    if (((r == iloscWierszy - 1) && (kierunek == 1)) ||
        ((r == 0) && (kierunek == -1))) {
      kierunek = -kierunek;
    }

    r = r + kierunek;
  }

  // Następnie, odczytaj szyfrogram wierszami:

  var wiersz = 0;
  while (wiersz < iloscWierszy) {
    for (var poz = 0; poz < tabelaPlotek[wiersz].length; ++poz) {
      szyfrogram = szyfrogram.concat(tabelaPlotek[wiersz][poz]);
    }
    ++wiersz;
  }

  return szyfrogram;
}

 */