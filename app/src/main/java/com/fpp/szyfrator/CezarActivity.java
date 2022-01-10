package com.fpp.szyfrator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class CezarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cezar);
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