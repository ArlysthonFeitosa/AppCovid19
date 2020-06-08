package com.example.covid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {

    ListView lista_menu;

    String[] listaTitulosCard = {" Oriente-se", " Previnir", " Fake News"};
    int[] listaImagensCard = {R.drawable.orientar, R.drawable.prevenir, R.drawable.fakenews};
    String[] listaDescricoesCard = {" Responda algumas pesguntas em relação aos seus sintomas e saiba se você precisa ir ao hospital para consulta.\n",
            " Em um momento de pandemia, é essencial saber como se previnir para não ser contaminado com o vírus. Clique para saber como fazer isso.\n",
            " Cuidado com as notícias falsas, algumas chegam até a colocar a sua vida em risco! Fique por dentro para não cair nessa.\n"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
        lista_menu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){
                    case 0:
                        Intent orientar = new Intent(getApplicationContext(), PesquisaFebre.class);
                        startActivity(orientar);
                        break;

                    case 1:
                        Intent prevenir = new Intent(getApplicationContext(), Prevenir.class);
                        startActivity(prevenir);
                        break;

                    case 2:
                        Intent fakeNews = new Intent(getApplicationContext(), FakeNews.class);
                        startActivity(fakeNews);
                        break;
                }
            }
        });

    }
}
