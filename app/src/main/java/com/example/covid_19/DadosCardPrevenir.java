package com.example.covid_19;

public class DadosCardPrevenir {
    private String tituloPrevenir;
    private String descricaoPrevenir;

    public DadosCardPrevenir(String tituloPrevenir, String descricaoPrevenir) {
        this.tituloPrevenir = tituloPrevenir;
        this.descricaoPrevenir = descricaoPrevenir;
    }

    public String getTituloPrevenir() {
        return tituloPrevenir;
    }

    public String getDescricaoPrevenir() {
        return descricaoPrevenir;
    }
}
