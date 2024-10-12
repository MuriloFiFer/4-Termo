package com.example.controllers;

import java.util.List;
import java.util.ArrayList;

import com.example.api.FalhaAPI;  // Supondo que você tenha uma API para Falhas
import com.example.models.Falhas;

public class FalhasController {
    private List<Falhas> falhas;

    // Construtor para inicializar a lista de falhas
    public FalhasController() {
        falhas = new ArrayList<>();
    }

    /**
     * Método Create - Adiciona uma nova falha à lista
     * @param falha Objeto do tipo Falhas que será adicionado
     */
    public void createFalha(Falhas falha) {
        this.falhas.add(falha);  // Adiciona a nova falha à lista
    }

    /**
     * Método Read - Lê as falhas da API
     * @return Retorna uma lista de objetos Falhas obtidos da API
     */
    public List<Falhas> readFalhas() {
        falhas = FalhaAPI.getFalhas();  // Método fictício para obter as falhas da API
        return falhas;  // Retorna a lista de falhas
    }

    /**
     * Método Update - Atualiza uma falha existente na lista
     * @param posicao A posição da falha na lista que será atualizada
     * @param falha O novo objeto Falhas com as informações atualizadas
     */
    public void updateFalha(int posicao, Falhas falha) {
        falhas.set(posicao, falha);  // Atualiza a falha na posição especificada
    }

    /**
     * Método Delete - Remove uma falha da lista
     * @param posicao A posição da falha que será removida
     */
    public void deleteFalha(int posicao) {
        falhas.remove(posicao);  // Remove a falha na posição especificada
    }
}
