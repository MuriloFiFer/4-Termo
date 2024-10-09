package com.example.controllers;

import java.util.List;
import java.util.ArrayList;

import com.example.api.HistoricoManutencaoAPI;  // Supondo que você tenha uma API para Histórico de Manutenção
import com.example.models.HistoricoManutencao;

public class HistoricoManutencaoController {
    private List<HistoricoManutencao> historicoManutencao;

    public HistoricoManutencaoController() {
        historicoManutencao = new ArrayList<>();
    }

    // Método Create - Adiciona um novo registro de histórico de manutenção
    public void createHistorico(HistoricoManutencao registro) {
        this.historicoManutencao.add(registro);
    }

    // Método Read - Lê o histórico de manutenção da API
    public List<HistoricoManutencao> readHistorico() {
        historicoManutencao = HistoricoManutencaoAPI.getHistoricos();  // Método fictício para obter o histórico
        return historicoManutencao;
    }

    // Método Update - Atualiza um registro do histórico
    public void updateHistorico(int posicao, HistoricoManutencao registro) {
        historicoManutencao.set(posicao, registro);
    }

    // Método Delete - Remove um registro do histórico
    public void deleteHistorico(int posicao) {
        historicoManutencao.remove(posicao);
    }
}
