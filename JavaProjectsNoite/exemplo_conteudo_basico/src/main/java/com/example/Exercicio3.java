package com.example;

    //atributos


import java.util.InputMismatchException;
import java.util.Scanner;

// Classe base Operacao
abstract class Operacao {
    public abstract double calcular(double a, double b) throws Exception;
}

// Subclasse Soma
class Soma extends Operacao {
    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
}

// Subclasse Subtracao
class Subtracao extends Operacao {
    @Override
    public double calcular(double a, double b) {
        return a - b;
    }
}

// Subclasse Multiplicacao
class Multiplicacao extends Operacao {
    @Override
    public double calcular(double a, double b) {
        return a * b;
    }
}

// Subclasse Divisao
class Divisao extends Operacao {
    @Override
    public double calcular(double a, double b) throws Exception {
        if (b == 0) {
            throw new ArithmeticException("Erro: Divisão por zero não é permitida.");
        }
        return a / b;
    }
}

// Subclasse RaizQuadrada
class RaizQuadrada extends Operacao {
    @Override
    public double calcular(double a, double b) throws Exception {
        if (a < 0) {
            throw new ArithmeticException("Erro: Não é possível calcular a raiz quadrada de número negativo.");
        }
        return Math.sqrt(a);
    }
}

// Classe principal CalculadoraAvancada
public class Exercicio3 {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Calculadora Avançada ---");
            System.out.println("1. Soma");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Raiz Quadrada");
            System.out.println("6. Sair");
            System.out.print("Escolha uma operação: ");
            int opcao = scanner.nextInt();

            if (opcao == 6) {
                System.out.println("Encerrando a calculadora...");
                break;
            }

            try {
                realizarOperacao(opcao);
            } catch (InputMismatchException e) {
                System.out.println("Erro: Entrada inválida. Por favor, insira números válidos.");
                scanner.next(); // Consumir a entrada inválida
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    // Método para realizar a operação escolhida
    private static void realizarOperacao(int opcao) throws Exception {
        Operacao operacao = null;
        double num1, num2 = 0;

        switch (opcao) {
            case 1:
                operacao = new Soma();
                num1 = obterNumero("Digite o primeiro número: ");
                num2 = obterNumero("Digite o segundo número: ");
                break;
            case 2:
                operacao = new Subtracao();
                num1 = obterNumero("Digite o primeiro número: ");
                num2 = obterNumero("Digite o segundo número: ");
                break;
            case 3:
                operacao = new Multiplicacao();
                num1 = obterNumero("Digite o primeiro número: ");
                num2 = obterNumero("Digite o segundo número: ");
                break;
            case 4:
                operacao = new Divisao();
                num1 = obterNumero("Digite o primeiro número: ");
                num2 = obterNumero("Digite o segundo número: ");
                break;
            case 5:
                operacao = new RaizQuadrada();
                num1 = obterNumero("Digite o número para calcular a raiz quadrada: ");
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        if (operacao != null) {
            double resultado = operacao.calcular(num1, num2);
            System.out.printf("Resultado: %.2f\n", resultado);
        }
    }

    // Método auxiliar para obter número do usuário
    private static double obterNumero(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextDouble();
    }
}

