package com.example.covid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CardMenuAdapter extends ArrayAdapter {

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
