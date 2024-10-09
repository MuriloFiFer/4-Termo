package com.example.controllers;


import java.util.List;
import java.util.ArrayList;

import com.example.api.FalhaAPI;  // Supondo que você tenha uma API para Falhas
import com.example.models.Falhas;

public class FalhasController {
    private List<Falhas> falhas;

    public FalhasController() {
        falhas = new ArrayList<>();
    }

    // Método Create - Adiciona uma nova falha
    public void createFalha(Falhas falha) {
        this.falhas.add(falha);
    }

    // Método Read - Lê as falhas da API
    public List<Falhas> readFalhas() {
        falhas = FalhaAPI.getFalhas();  // Método fictício para obter falhas
        return falhas;
    }

    // Método Update - Atualiza uma falha existente
    public void updateFalha(int posicao, Falhas falha) {
        falhas.set(posicao, falha);
    }

    // Método Delete - Remove uma falha
    public void deleteFalha(int posicao) {
        falhas.remove(posicao);
    }
}
