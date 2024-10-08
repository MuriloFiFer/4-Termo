package com.example.controllers;

import java.util.List;
import java.util.ArrayList;

import com.example.models.Maquinas;

public class MaquinaController {
    private  List<Maquinas> maquinas;

    public MaquinaController() {
        maquinas = new ArrayList<>();
    }

    //métodos - CRUD
    public void createMaquina(Maquinas maquina) {
        maquinas.add(maquina);
    }

}
