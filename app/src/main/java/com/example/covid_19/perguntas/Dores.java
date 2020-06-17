package com.example.covid_19.perguntas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_19.R;

public class Dores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dores);
    }

    public void clicouSim(View v){
        Intent intent = new Intent(getApplicationContext(), DoresParaCansaco.class);
        startActivity(intent);
        finish();
    }

    public void clicouNao(View v){
        Intent intent = new Intent(getApplicationContext(), NotDoresParaCansaco.class);
        startActivity(intent);
        finish();
    }
}
