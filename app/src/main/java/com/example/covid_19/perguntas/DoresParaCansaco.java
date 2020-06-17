package com.example.covid_19.perguntas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.covid_19.orientacoes.HospitalCovid;
import com.example.covid_19.orientacoes.IsolamentoRigido;
import com.example.covid_19.R;

public class DoresParaCansaco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dores_para_cansaco);
    }

    public void clicouSim(View v){
        Intent intent = new Intent(getApplicationContext(), HospitalCovid.class);
        startActivity(intent);
        finish();
    }

    public void clicouNao(View v){
        Intent intent = new Intent(getApplicationContext(), IsolamentoRigido.class);
        startActivity(intent);
        finish();
    }
}
