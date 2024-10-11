package com.example.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HistoricoManutencao {  
    private String id;
    private String maquinaID;
    private String data; // Pode ser alterado para LocalDate conforme necessário
    private String tipo;
    private String pecasTrocadas;
    private int tempoDeParada;
    private String tecnicoID;
    private String observacoes;
}
