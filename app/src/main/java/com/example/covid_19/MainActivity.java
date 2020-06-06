package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    ListView lista_menu;

    String[] listaTitulosCard = {"Oriente-se", "Previnir", "Fake News"};
    int[] listaImagensCard = {R.drawable.orientar, R.drawable.prevenir, R.drawable.fakenews};
    String[] listaDescricoesCard = {"Descrição Oriente-se", "Descrição Previnir", "Descrição Fake News"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1, listaTitulos);
        */


        lista_menu = findViewById(R.id.lista_menu);
        CardMenuAdapter cardMenuAdapter = new CardMenuAdapter(getApplicationContext(), R.layout.modelolista_menu);

        int contadorListaDados = 0;
        for(String titulo : listaTitulosCard){

            DadosCardMenu dadosCardMenu;
            dadosCardMenu = new DadosCardMenu(listaImagensCard[contadorListaDados], titulo,
                    listaDescricoesCard[contadorListaDados]);

            cardMenuAdapter.add(dadosCardMenu);
            contadorListaDados++;
        }

        lista_menu.setAdapter(cardMenuAdapter);

    }
}
