package com.example.ecommunity;

public class Material {

    String dataLimite;
    String horaLimite;
    private int qtdPapel;
    private int qtdVidro;
    private int qtdOleo;
    private int qtdAluminio;

    public String getDataLimite() {
        return dataLimite;
    }

    public void setDataLimite(String dataLimite) {
        this.dataLimite = dataLimite;
    }

    public String getHoraLimite() {
        return horaLimite;
    }

    public void setHoraLimite(String horaLimite) {
        this.horaLimite = horaLimite;
    }

    public int getQtdPapel() {
        return qtdPapel;
    }

    public void setQtdPapel(int qtdPapel) {
        this.qtdPapel = qtdPapel;
    }

    public int getQtdVidro() {
        return qtdVidro;
    }

    public void setQtdVidro(int qtdVidro) {
        this.qtdVidro = qtdVidro;
    }

    public int getQtdOleo() {
        return qtdOleo;
    }

    public void setQtdOleo(int qtdOleo) {
        this.qtdOleo = qtdOleo;
    }

    public int getQtdAluminio() {
        return qtdAluminio;
    }

    public void setQtdAluminio(int qtdAluminio) {
        this.qtdAluminio = qtdAluminio;
    }

    /*
    public Material(String dataLimite, String horaLimite, String razaoSocial, String cidade, int qtdPapel, int qtdVidro, int qtdOleo, int qtdAluminio) {
        super(razaoSocial, cidade);
        this.dataLimite = dataLimite;
        this.horaLimite = horaLimite;
        this.qtdPapel = qtdPapel;
        this.qtdVidro = qtdVidro;
        this.qtdOleo = qtdOleo;
        this.qtdAluminio = qtdAluminio;
    }
    */


}
