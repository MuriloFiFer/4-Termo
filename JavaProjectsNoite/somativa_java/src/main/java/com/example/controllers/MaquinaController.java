package com.example.controllers;

import java.util.List;
import java.util.ArrayList;

import com.example.api.MaquinaAPI;
import com.example.models.Maquina;

public class MaquinaController {
    private List<Maquina> maquinas;

    public MaquinaController() {
        maquinas = new ArrayList<>();
    }

    

    // Método Create - Adiciona uma nova máquina
    public void createMaquina(Maquina maquina) {
        this.maquinas.add(maquina);
    }
    

    public List<Maquina> readMaquinas() {
        maquinas = MaquinaAPI.getMaquinas();
        return maquinas;
    }

  public void updateMaquina(int posicao,Maquina maquina){
    maquinas.set(posicao, maquina);    
  }

  public void deleteMaquina(int posicao){
    maquinas.remove(posicao);
  }

  
   


    
}
