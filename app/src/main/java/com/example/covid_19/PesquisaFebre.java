package com.example.covid_19;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PesquisaFebre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_febre);
    }

    public void clicouSim(View v){
        Intent intent = new Intent(getApplicationContext(), Dores.class);
        startActivity(intent);
        finish();
    }

    public void clicouNao(View v){
        Intent intent = new Intent(getApplicationContext(), FicarEmCasa.class);
        startActivity(intent);
        finish();
    }
}
