package com.example;

import java.util.Scanner;


public class Exercicio1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] notas = new double[4];
        double soma = 0;
        boolean bonus = true; // Verifica se todas as notas são maiores que 9

        // Capturando as notas do aluno
        for (int i = 0; i < 4; i++) {
            System.out.print("Digite a nota da disciplina " + (i + 1) + ": ");
            notas[i] = scanner.nextDouble();
            soma += notas[i];

            // Verificando se há alguma nota menor ou igual a 9 para o sistema de bônus
            if (notas[i] <= 9) {
                bonus = false;
            }
        }

        // Calculando a média
        double media = soma / 4;

        // Aplicando o bônus de 10% se todas as notas forem maiores que 9
        if (bonus) {
            media *= 1.10;
        }

        // Exibindo o status do aluno com base na média
        System.out.printf("Média final: %.2f\n", media);
        
        if (media >= 7) {
            System.out.println("Status: Aprovado");
        } else if (media >= 5) {
            System.out.println("Status: Recuperação");
        } else {
            System.out.println("Status: Reprovado");
        }

        scanner.close();
    }
}
