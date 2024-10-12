package com.example.controllers;

import java.util.List;
import java.util.ArrayList;

import com.example.api.TecnicosAPI;  // Supondo que você tenha uma API para Técnicos
import com.example.models.Tecnicos;

public class TecnicosController {
    private List<Tecnicos> tecnicos;  // Lista para armazenar os técnicos

    // Construtor para inicializar a lista de técnicos
    public TecnicosController() {
        tecnicos = new ArrayList<>();
    }

    /**
     * Método Create - Adiciona um novo técnico à lista
     * @param tecnico Objeto do tipo Tecnicos que será adicionado
     */
    public void createTecnico(Tecnicos tecnico) {
        this.tecnicos.add(tecnico);  // Adiciona o novo técnico à lista
    }

    /**
     * Método Read - Lê os técnicos da API
     * @return Retorna uma lista de objetos Tecnicos obtidos da API
     */
    public List<Tecnicos> readTecnicos() {
        tecnicos = TecnicosAPI.getTecnicos();  // Obtém os técnicos da API
        return tecnicos;  // Retorna a lista de técnicos
    }

    /**
     * Método Update - Atualiza um técnico existente na lista
     * @param posicao A posição do técnico na lista que será atualizada
     * @param tecnico O novo objeto Tecnicos com as informações atualizadas
     */
    public void updateTecnico(int posicao, Tecnicos tecnico) {
        tecnicos.set(posicao, tecnico);  // Atualiza o técnico na posição especificada
    }

    /**
     * Método Delete - Remove um técnico da lista
     * @param posicao A posição do técnico que será removido
     */
    public void deleteTecnico(int posicao) {
        tecnicos.remove(posicao);  // Remove o técnico na posição especificada
    }
}
