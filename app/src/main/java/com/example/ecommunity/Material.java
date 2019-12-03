package com.example.ecommunity;

public class Material {

    private int id;
    private String dataLimite;
    private String horaLimite;
    private String qtdPapel;
    private String qtdVidro;
    private String qtdOleo;
    private String qtdAluminio;
    private int idUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getQtdPapel() {
        return qtdPapel;
    }

    public void setQtdPapel(String qtdPapel) {
        this.qtdPapel = qtdPapel;
    }

    public String getQtdVidro() {
        return qtdVidro;
    }

    public void setQtdVidro(String qtdVidro) {
        this.qtdVidro = qtdVidro;
    }

    public String getQtdOleo() {
        return qtdOleo;
    }

    public void setQtdOleo(String qtdOleo) {
        this.qtdOleo = qtdOleo;
    }

    public String getQtdAluminio() {
        return qtdAluminio;
    }

    public void setQtdAluminio(String qtdAluminio) {
        this.qtdAluminio = qtdAluminio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Id empresa: " +idUsuario + "\n" +
                "Data de coleta: " + dataLimite +
                " até às: " + horaLimite + "\n" +
                "Papel: " + qtdPapel + " kg\n" +
                "Vidro: " + qtdVidro + " kg\n" +
                "Óleo: " + qtdOleo + " l\n" +
                "Alumínio: " + qtdAluminio + " kg\n";
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
