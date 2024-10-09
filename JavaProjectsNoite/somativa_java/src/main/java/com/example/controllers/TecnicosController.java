package com.example.controllers;

import java.util.List;
import java.util.ArrayList;

import com.example.api.TecnicosAPI;  // Supondo que você tenha uma API para Técnicos
import com.example.models.Tecnicos;

public class TecnicosController {
    private List<Tecnicos> tecnicos;

    public TecnicosController() {
        tecnicos = new ArrayList<>();
    }

    // Método Create - Adiciona um novo técnico
    public void createTecnico(Tecnicos tecnico) {
        this.tecnicos.add(tecnico);
    }

    // Método Read - Lê os técnicos da API
    public List<Tecnicos> readTecnicos() {
        tecnicos = TecnicosAPI.getTecnicos();  // Método fictício para obter técnicos
        return tecnicos;
    }

    // Método Update - Atualiza um técnico existente
    public void updateTecnico(int posicao, Tecnicos tecnico) {
        tecnicos.set(posicao, tecnico);
    }

    // Método Delete - Remove um técnico
    public void deleteTecnico(int posicao) {
        tecnicos.remove(posicao);
    }
}
