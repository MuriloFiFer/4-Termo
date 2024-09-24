package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Professor extends Pessoa {
    //Atributo
    private double salario;
    //Construtor
    public Professor(String nome, String cpf, double salario){
        super(nome, cpf);
        this.salario = salario;
    }
    //método
    @Override
    public String exibirInfo() {
        super.exibirInfo();
        return "Salário: "+salario;
    }
}
