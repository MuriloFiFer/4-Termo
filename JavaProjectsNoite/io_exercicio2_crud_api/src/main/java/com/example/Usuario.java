package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    private String id;
    private String nome;
    private int idade;
    private String endereco;


    @Override
    public String toString(){
        return "ID: " +id +", Nome: " +nome+ ", Idade: " + idade;
    }
}