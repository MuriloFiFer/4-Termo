package com.example.models;

import java.time.LocalDate;

import lombok.AllArgsConstructor;



public class HistoricoManutencao {  
     
        private String id;
        private String maquinaID;
        private LocalDate data;
        private String tipo;
        private String pecasTrocadas;
        private long tempoDeParada;
        private String tecnicoID;
        private String observacoes;
    
        public String getID() { return id; }
        public void setID(String value) { this.id = value; }
    
        public String getMaquinaID() { return maquinaID; }
        public void setMaquinaID(String value) { this.maquinaID = value; }
    
        public LocalDate getData() { return data; }
        public void setData(LocalDate value) { this.data = value; }
    
        public String getTipo() { return tipo; }
        public void setTipo(String value) { this.tipo = value; }
    
        public String getPecasTrocadas() { return pecasTrocadas; }
        public void setPecasTrocadas(String value) { this.pecasTrocadas = value; }
    
        public long getTempoDeParada() { return tempoDeParada; }
        public void setTempoDeParada(long value) { this.tempoDeParada = value; }
    
        public String getTecnicoID() { return tecnicoID; }
        public void setTecnicoID(String value) { this.tecnicoID = value; }
    
        public String getObservacoes() { return observacoes; }
        public void setObservacoes(String value) { this.observacoes = value; }
    }
    
