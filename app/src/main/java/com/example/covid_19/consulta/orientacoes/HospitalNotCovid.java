package com.example.covid_19.consulta.orientacoes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.covid_19.MainActivity;
import com.example.covid_19.R;

public class HospitalNotCovid extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_not_covid);
    }

    public void clicouContinuar(View v){
        Intent continuar = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(continuar);
    }
}

