package com.example.models;

import java.time.LocalDate;

public class Maquinas {

    private String id;
    private String codigo;
    private String nome;
    private String modelo;
    private String fabricante;
    private LocalDate dataAquisicao;
    private long tempoVidaEstimado;
    private String localizacao;
    private String detalhes;
    private String manual;

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String value) { this.codigo = value; }

    public String getNome() { return nome; }
    public void setNome(String value) { this.nome = value; }

    public String getModelo() { return modelo; }
    public void setModelo(String value) { this.modelo = value; }

    public String getFabricante() { return fabricante; }
    public void setFabricante(String value) { this.fabricante = value; }

    public LocalDate getDataAquisicao() { return dataAquisicao; }
    public void setDataAquisicao(LocalDate value) { this.dataAquisicao = value; }

    public long getTempoVidaEstimado() { return tempoVidaEstimado; }
    public void setTempoVidaEstimado(long value) { this.tempoVidaEstimado = value; }

    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String value) { this.localizacao = value; }

    public String getDetalhes() { return detalhes; }
    public void setDetalhes(String value) { this.detalhes = value; }

    public String getManual() { return manual; }
    public void setManual(String value) { this.manual = value; }
}



