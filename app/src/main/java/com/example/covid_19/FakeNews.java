package com.example.covid_19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FakeNews extends AppCompatActivity {

    ListView listaFakes;

    String[] tituloFake = {"fake 1", "fake2"};
    String[] descricaoFake = {"Desc fake 1", "Desk fake 2"};
    String[] tituloVerdade = {"Verdade 1", "Verdade 2"};
    String[] descricaoVerdade = {"Desk vdd 1", "Desk Vdd 2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fake_news);

        listaFakes = findViewById(R.id.listaFakes);

        CardFakeAdapter cardFakeAdapter;
        cardFakeAdapter = new CardFakeAdapter(getApplicationContext(), R.layout.modelofakenews);

        int incremento = 0;
        for(String tituloF : tituloFake){
            DadosCardFakes dadosCardFakes;
            dadosCardFakes = new DadosCardFakes(tituloVerdade[incremento],
                    descricaoVerdade[incremento], tituloF, descricaoFake[incremento]);

            cardFakeAdapter.add(dadosCardFakes);
            incremento++;
        }

        listaFakes.setAdapter(cardFakeAdapter);
    }
}

class ComponentesCardFakes{
    TextView tituloVerdade;
    TextView descricaoVerdade;
    TextView tituloFalso;
    TextView descricaoFalso;
}

class DadosCardFakes{
    private String tituloVerdade;
    private String descricaoVerdade;
    private String tituloFake;
    private String descricaoFake;

    public DadosCardFakes(String tituloVerdade, String descricaoVerdade, String tituloFake, String descricaoFake) {
        this.tituloVerdade = tituloVerdade;
        this.descricaoVerdade = descricaoVerdade;
        this.tituloFake = tituloFake;
        this.descricaoFake = descricaoFake;
    }

    public String getTituloVerdade() {
        return tituloVerdade;
    }

    public String getDescricaoVerdade() {
        return descricaoVerdade;
    }

    public String getTituloFake() {
        return tituloFake;
    }

    public String getDescricaoFake() {
        return descricaoFake;
    }
}

class CardFakeAdapter extends ArrayAdapter{
    public CardFakeAdapter(@NonNull Context context, int resource) {
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
        View layoutFake = convertView;
        ComponentesCardFakes componentesFake;

        if(convertView == null){
            LayoutInflater inflaterFake = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layoutFake = inflaterFake.inflate(R.layout.modelofakenews, parent, false);

            componentesFake = new ComponentesCardFakes();
            componentesFake.tituloFalso = (TextView) layoutFake.findViewById(R.id.tituloFalso);
            componentesFake.tituloVerdade = (TextView) layoutFake.findViewById(R.id.tituloVerdade);
            componentesFake.descricaoFalso = (TextView) layoutFake.findViewById(R.id.descricaoFalso);
            componentesFake.descricaoVerdade = (TextView) layoutFake.findViewById(R.id.descricaoVerdade);

            layoutFake.setTag(componentesFake);
        }else{
            componentesFake = (ComponentesCardFakes) layoutFake.getTag();
        }

        DadosCardFakes dadosCardFakes= (DadosCardFakes) this.getItem(position);
        componentesFake.tituloVerdade.setText(dadosCardFakes.getTituloVerdade());
        componentesFake.tituloFalso.setText(dadosCardFakes.getTituloFake());
        componentesFake.descricaoVerdade.setText(dadosCardFakes.getDescricaoVerdade());
        componentesFake.descricaoFalso.setText(dadosCardFakes.getDescricaoFake());

        return layoutFake;
    }
}