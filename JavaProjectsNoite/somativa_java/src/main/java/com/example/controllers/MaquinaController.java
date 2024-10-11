package com.example.controllers;

import java.util.List;
import java.util.ArrayList;

import com.example.api.MaquinaAPI;  // Supondo que você tenha uma API para Máquinas
import com.example.models.Maquina;

public class MaquinaController {
    private List<Maquina> maquinas;  // Lista para armazenar as máquinas

    // Construtor para inicializar a lista de máquinas
    public MaquinaController() {
        maquinas = new ArrayList<>();
    }

    /**
     * Método Create - Adiciona uma nova máquina à lista
     * @param maquina Objeto do tipo Maquina que será adicionado
     */
    public void createMaquina(Maquina maquina) {
        this.maquinas.add(maquina);  // Adiciona a nova máquina à lista
    }

    /**
     * Método Read - Lê as máquinas da API
     * @return Retorna uma lista de objetos Maquina obtidos da API
     */
    public List<Maquina> readMaquinas() {
        maquinas = MaquinaAPI.getMaquinas();  // Obtém as máquinas da API
        return maquinas;  // Retorna a lista de máquinas
    }

    /**
     * Método Update - Atualiza uma máquina existente na lista
     * @param posicao A posição da máquina na lista que será atualizada
     * @param maquina O novo objeto Maquina com as informações atualizadas
     */
    public void updateMaquina(int posicao, Maquina maquina) {
        maquinas.set(posicao, maquina);  // Atualiza a máquina na posição especificada
    }

    /**
     * Método Delete - Remove uma máquina da lista
     * @param posicao A posição da máquina que será removida
     */
    public void deleteMaquina(int posicao) {
        maquinas.remove(posicao);  // Remove a máquina na posição especificada
    }
}
