package main.java.com.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        FuncionarioController gerenciaFuncionarioController = new FuncionarioController();
        int operacao =0;
        do {
            operacao = Integer.parseInt(JOptionPane.showInputDialog(
                "\n---Gerenciamento de Funcionarios---\n"
                    +"1-Adicionar Funcionario\n"
                    +"2-Listar Funcionario\n"
                    +"3-Buscar Funcionario\n"
                    +"4-Remover Funcionario\n"
                    +"5-média salarial\n"
                    +"Sair"));
        switch (operacao) {
            case 1:
                gerenciaFuncionarioController.addFuncionario();
                break;
            case 2:
                gerenciaFuncionarioController.listarFuncionarios();
                break;
            case 3:
                gerenciaFuncionarioController.buscarFuncionarios();
                break;
            case 4:
                gerenciaFuncionarioController.removerFuncionario();
                break;
            case 5:
                gerenciaFuncionarioController.calculoMediaSalario();
                break;
                case 6:
                System.out.println("Saindo...");
                break;
                default:  
                System.out.println("Insira uma opção valida");
                break;
    }
} while (operacao!=5);
    }
};