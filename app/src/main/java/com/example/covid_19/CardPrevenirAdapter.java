package com.example.covid_19;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.zip.Inflater;

public class CardPrevenirAdapter extends ArrayAdapter {

    public CardPrevenirAdapter(@NonNull Context context, int resource) {
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

        View viewCardPrevenir = convertView;
        CardPrevenir cardPrevenir;

        if(convertView != null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewCardPrevenir = inflater.inflate(R.layout.modelolistaprevenir, parent, false);

            cardPrevenir = new CardPrevenir();
            cardPrevenir.tituloPrevenir = (TextView) viewCardPrevenir.findViewById(R.id.tituloCardPrevenir);
            cardPrevenir.descricaoPrevenir = (TextView) viewCardPrevenir.findViewById(R.id.descricaoCardMenu);

            viewCardPrevenir.setTag(cardPrevenir);

        }else{
            cardPrevenir = (CardPrevenir) viewCardPrevenir.getTag();
        }
        DadosCardPrevenir dadosCardPrevenir;
        dadosCardPrevenir = (DadosCardPrevenir) this.getItem(position);

        cardPrevenir.tituloPrevenir.setText(dadosCardPrevenir.getTituloPrevenir());
        cardPrevenir.descricaoPrevenir.setText(dadosCardPrevenir.getDescricaoPrevenir());

         return viewCardPrevenir;
    }
}
