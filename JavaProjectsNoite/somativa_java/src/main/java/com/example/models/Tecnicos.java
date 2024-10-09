package com.example.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Tecnicos {  
   
        private String id;
        private String maquinaID;
        private String data;
        private String tipo;
        private String pecasTrocadas;
        private int tempoDeParada;
        private String tecnicoID;
        private String observacoes;
    
    
    }
    
