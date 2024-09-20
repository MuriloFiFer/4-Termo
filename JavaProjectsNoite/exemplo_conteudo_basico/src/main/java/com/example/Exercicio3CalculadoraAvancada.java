package com.example;

import java.util.Scanner;

public class Exercicio3CalculadoraAvancada {
    // atributos
    double valor1 = 0;
    double valor2 = 0;
    double resultado = 0;
    int escolha = 0;
    int operacao = 0;

    Scanner sc = new Scanner(System.in);

    public double soma(double a, double b) {
        this.resultado = a + b;
        return resultado;
    }

    public double subtrair(double a, double b) {
        this.resultado = a - b;
        return resultado;
    }

    public double multiplicar(double a, double b) {
        this.resultado = a * b;
        return resultado;
    }

    public double dividir(double a, double b) {
        try {
            this.resultado = a / b;
        } catch (Exception e) {
            System.err.println("Não Dividir por Zero");
        }
        return resultado;

    }

    public double raiz(double a) {
        try {
            if (a < 0) {
                throw new Exception(" Número deve ser maior que Zero");
            }
            this.resultado = Math.sqrt(a);

        } catch (Exception e) {
            System.err.println(e);
        }
        return resultado;
    }

    public void operacoes() {
        try {
            
            while (escolha!=6) {
            System.out.println("\n--- Calculadora Avançada ---");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Raiz Quadrada");
            System.out.println("6. Sair");
            escolha = sc.nextInt();
            escolhaOperacao();
            switch (escolha) {
                case 1:
                    System.out.println("Resultado = "+soma(valor1, valor2));
                    break;
                case 2:
                    System.out.println("Resultado = "+subtrair(valor1, valor2));
                    break;
            
                default:
                    break;
            }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void escolhaOperacao(){
        
        if (escolha>=1 && escolha<5) {
            System.out.println("Digite o valor 1:");
            valor1 = sc.nextDouble();
            System.out.println("Digite o valor 2:");
            valor2 = sc.nextDouble();
        }else if (escolha == 5) {
            System.out.println("Digite o valor 1:");
            valor1 = sc.nextDouble();
        }{
            System.out.println("Saindo....");
        }
    }



}