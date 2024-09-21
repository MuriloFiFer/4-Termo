package main.java.com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FuncionarioController {
    private List<Funcionario> funcionarios;

    public FuncionarioController() {
        funcionarios = new ArrayList<>();
    }

    //método add
    public void addFuncionario(){
        //criar o Funcionario
        String nome = JOptionPane.showInputDialog("Digite o Nome do Funcionario");
        int idade = Integer.parseInt(JOptionPane.showInputDialog ("Digite a Idade"));
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o Salario"));
        Funcionario funcionario = new Funcionario(nome, idade, salario);
        funcionarios.add(funcionario);
    }
    //métodos
    //listar todos os funcionarios
    public void listarFuncionarios(){
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario.toString());
        }
    }
    //buscar funcionario pelo nome  
    public void buscarFuncionarios(){
        String nome = JOptionPane.showInputDialog("Digite o Nome do Funcionario para buscar");
        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    encontrado = true;                    
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionario não encontrado");
            }
        } catch (Exception e) {
            System.out.println(e);                          
        }     
    }
    //remover funcionario pelo nome
    public void removerFuncionario(){
        String nome = JOptionPane.showInputDialog("Digite o Nome do Funcionario para remover");
        try {
            boolean encontrado = false;
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getNome().equalsIgnoreCase(nome)) {
                    funcionarios.remove(funcionario);
                    encontrado = true;
                    System.out.println("Funcionario removido com sucesso.");
                    break;                 
                }
            }
            if (!encontrado) {
                throw new Exception("Funcionario não encontrado");
            }
        } catch (Exception e) {
            System.out.println(e);                          
        }     
    }
    //calculo de média salaria
    public void calculoMediaSalario(){
        double mediaSalarios = 0;
        if (funcionarios.size()==0){
            System.out.println("Lista vazia");
        }else{
            for (Funcionario funcionario : funcionarios) {
                mediaSalarios = funcionario.getSalario();
            }
            mediaSalarios/=funcionarios.size();
            System.out.println("A média de salarios é "+mediaSalarios);
        }
    }

};


