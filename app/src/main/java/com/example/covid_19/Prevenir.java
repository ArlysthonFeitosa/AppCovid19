package com.example.covid_19;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        PrevenirAdapter prevenirAdapter;
        prevenirAdapter = new PrevenirAdapter(getApplicationContext(), R.layout.modelolistaprevenir);

        int incremento = 0;
        for (String titulo : listaTitulosPrevenir) {
            DadosCardPrevenir dadosCardPrevenir;
            dadosCardPrevenir = new DadosCardPrevenir(listaTitulosPrevenir[incremento],
                    listaDescricoesPrevenir[incremento]);
            prevenirAdapter.add(dadosCardPrevenir);
            incremento++;

        }

        listaPrevenir.setAdapter(prevenirAdapter);
    }
}

class ViewCardPrevenir{
    TextView titulo;
    TextView descricao;
    CardView cardView;
    ConstraintLayout constraintLayout;
}

class DadosCardPrevenir{
    private String titulo;
    private String descricao;

    public DadosCardPrevenir(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }
}

class PrevenirAdapter extends ArrayAdapter {
    public PrevenirAdapter(@NonNull Context context, int resource) {
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
        View viewPrevinir;
        viewPrevinir = convertView;
        ViewCardPrevenir viewCardPrevenir;

        if(convertView == null){
            LayoutInflater inflater1 = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            viewPrevinir = inflater1.inflate(R.layout.modelolistaprevenir, parent, false);

            viewCardPrevenir = new ViewCardPrevenir();
            viewCardPrevenir.titulo = (TextView) viewPrevinir.findViewById(R.id.tituloCardPrevenir);
            viewCardPrevenir.descricao = (TextView) viewPrevinir.findViewById(R.id.descricaoCardPrevenir);
            viewCardPrevenir.cardView = (CardView) viewPrevinir.findViewById(R.id.cardPrevenir);
            viewCardPrevenir.constraintLayout = (ConstraintLayout) viewPrevinir.findViewById(R.id.layoutCard);

            viewPrevinir.setTag(viewCardPrevenir);
        }else{
            viewCardPrevenir = (ViewCardPrevenir) viewPrevinir.getTag();
        }

        DadosCardPrevenir dadosCardPrevenir;
        dadosCardPrevenir = (DadosCardPrevenir) this.getItem(position);
        viewCardPrevenir.titulo.setText(dadosCardPrevenir.getTitulo());
        viewCardPrevenir.descricao.setText(dadosCardPrevenir.getDescricao());

        return viewPrevinir;
    }
}

