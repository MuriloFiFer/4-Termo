package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Maquina {
    private String id;  // O ID pode ser do tipo String ou Integer
    private String codigo;
    private String nome;
    private String modelo;
    private String fabricante;
    private String dataAquisicao;
    private int tempoVidaEstimado;
    private String localizacao;
    private String detalhes;
    private String manual;

    public void setId(String id) {
        this.id = id; // Ajuste para aceitar um String
    }
}
