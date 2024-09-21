package main.java.com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter

public class Funcionario {
    //Atributos
    private String nome;
    private int idade;
    private double salario;
    
    
    //toString
    @Override
    public String toString() {
       return "Nome: " + nome + ", idade: " + idade +", salario: " + salario;
}


};
