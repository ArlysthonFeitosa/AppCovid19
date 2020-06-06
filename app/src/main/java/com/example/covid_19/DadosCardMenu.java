package com.example.covid_19;

public class DadosCardMenu {
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


