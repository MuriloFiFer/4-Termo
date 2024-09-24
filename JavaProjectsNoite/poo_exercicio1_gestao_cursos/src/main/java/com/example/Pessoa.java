package com.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pessoa {
    //Atributos
    private String nome;
    private String cpf;   
    //método
    public String exibirInfo(){
        return "Nome: "+nome+", CPF: " +cpf;
    }
    }
