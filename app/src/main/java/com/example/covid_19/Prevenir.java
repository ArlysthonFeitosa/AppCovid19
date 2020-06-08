package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

public class Prevenir extends AppCompatActivity {

    ListView listaPrevenir;

    String[] listaTitulosPrevenir = {"Ambiente", "Contato", "Higiene", "Isolamento", "Máscara", "Objetos"};
    String[] listaDescricoesPrevenir = {"Mantenha o ambiente bem ventilado para facilitar a circulação do ar.",
        "Evite ter contato com pessoas, estabeleça uma distância de no mínimo 2 metros.",
        "Lave as mãos com frequência com sabão. Caso saia de casa, passe álcool em gel 70%.",
        "Permaneça em isolamento social de acordo com o decreto estabelecido pelo Estado.",
        "Use máscara, mesmo que não esteja contaminado, ela aumenta a sua proteção conta o vírus.",
        "Para evitar contaminação com o vírus, é essencial não compartilhar objetos."};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prevenir);

        listaPrevenir = findViewById(R.id.lista_prevenir);
        CardPrevenirAdapter cardPrevenirAdapter = new CardPrevenirAdapter(getApplicationContext(), R.layout.modelolistaprevenir);

        int incremento = 0;
        for(String titulo : listaTitulosPrevenir){
            DadosCardPrevenir dadosCardPrevenir;
            dadosCardPrevenir = new DadosCardPrevenir(titulo,
                    listaDescricoesPrevenir[incremento]);

            cardPrevenirAdapter.add(dadosCardPrevenir);
            incremento++;
        }
        listaPrevenir.setAdapter(cardPrevenirAdapter);
    }
}
