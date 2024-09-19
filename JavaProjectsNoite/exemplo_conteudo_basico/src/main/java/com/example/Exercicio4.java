package com.example;

import java.util.InputMismatchException;
import java.util.Scanner;

// Exceção personalizada para valores inválidos
class ValorInvalidoException extends Exception {
    public ValorInvalidoException(String message) {
        super(message);
    }
}

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Digite um número inteiro positivo para calcular o fatorial (ou -1 para sair): ");
                int numero = scanner.nextInt();

                if (numero == -1) {
                    System.out.println("Encerrando o programa...");
                    break;
                }

                // Verifica se o número é negativo e lança a exceção personalizada
                if (numero < 0) {
                    throw new ValorInvalidoException("Erro: O número deve ser um inteiro positivo.");
                }

                // Calcula o fatorial usando recursão
                long fatorial = calcularFatorial(numero);
                System.out.printf("O fatorial de %d é: %d\n", numero, fatorial);

            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira um número inteiro.");
                scanner.next(); // Consome a entrada inválida para evitar loop infinito
            } catch (ValorInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // Método recursivo para calcular o fatorial
    public static long calcularFatorial(int n) throws ValorInvalidoException {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * calcularFatorial(n - 1);
    }
}
