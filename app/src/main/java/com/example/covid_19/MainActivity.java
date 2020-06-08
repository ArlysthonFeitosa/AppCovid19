package com.example.covid_19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ListView lista_menu;

    String[] listaTitulosCard = {" Oriente-se", " Previnir", " Fake News"};
    int[] listaImagensCard = {R.drawable.orientar, R.drawable.prevenir, R.drawable.fakenews};
    String[] listaDescricoesCard = {"Responda algumas pesguntas em relação aos seus sintomas e saiba se você precisa ir ao hospital para consulta.\n",
            "Em um momento de pandemia, é essencial saber como se previnir para não ser contaminado com o vírus. Clique para saber como fazer isso.\n",
            "Cuidado com as notícias falsas, algumas chegam até a colocar a sua vida em risco! Fique por dentro para não cair nessa.\n"};


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



class CardMenu {
    ImageView imagemCardMenu;
    TextView tituloCardMenu;
    TextView descricaoCardMenu;

}


class DadosCardMenu {
    private int imagemCardMenu;
    private String tituloCardMenu;
    private String descricaoCardMenu;

    public DadosCardMenu(int imagemCardMenu, String tituloCardMenu, String descricaoCardMenu) {
        this.imagemCardMenu = imagemCardMenu;
        this.tituloCardMenu = tituloCardMenu;
        this.descricaoCardMenu = descricaoCardMenu;
    }

    public int getImagemCardMenu() {
        return imagemCardMenu;
    }

    public String getTituloCardMenu() {
        return tituloCardMenu;
    }

    public String getDescricaoCard() {
        return descricaoCardMenu;
    }

}

class CardMenuAdapter extends ArrayAdapter {

    public CardMenuAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View viewCardMenu = convertView; //Layout do cartão
        CardMenu cardMenu; //O que tem no cartão

        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //Pega o layout do modelo
            viewCardMenu = inflater.inflate(R.layout.modelolista_menu, parent, false);

            cardMenu = new CardMenu();
            cardMenu.imagemCardMenu = (ImageView) viewCardMenu.findViewById(R.id.imagemCardMenu);
            cardMenu.tituloCardMenu = (TextView) viewCardMenu.findViewById(R.id.tituloCardMenu);
            cardMenu.descricaoCardMenu = (TextView) viewCardMenu.findViewById(R.id.descricaoCardMenu);


            viewCardMenu.setTag(cardMenu);


        }else{
            cardMenu = (CardMenu) viewCardMenu.getTag();
        }

        DadosCardMenu dadosCardMenu;
        dadosCardMenu = (DadosCardMenu) this.getItem(position);

        cardMenu.imagemCardMenu.setImageResource(dadosCardMenu.getImagemCardMenu());
        cardMenu.tituloCardMenu.setText(dadosCardMenu.getTituloCardMenu());
        cardMenu.descricaoCardMenu.setText(dadosCardMenu.getDescricaoCard());


        return viewCardMenu;
    }
}
