package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<Curso>();
        String operacao = "0";
        do {
            operacao = JOptionPane.showInputDialog(
                    "\n---Gerenciamento de Curso---\n"
                            + "1- Cadastrar Curso\n"
                            + "2- Adicionar Professor\n"
                            + "3- Adicionar Aluno\n"
                            + "4- Informações do curso\n"
                            + "5- Atribuir Nota\n"
                            + "6- Resultado Final\n"
                            + "7- Sair");
            switch (operacao) {
                case "1":
                    String nomeCurso = JOptionPane.showInputDialog("Informe o Nome do Curso");
                    cursos.add(new Curso(nomeCurso));
                    break;
                case "2":
                    String nomeCursoP = JOptionPane.showInputDialog("Informe o Nome do Curso");
                    for (Curso curso : cursos) {
                        if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoP)) {
                            String nomeProf = JOptionPane.showInputDialog("Nome:");
                            String cpfProf = JOptionPane.showInputDialog("CPF:");
                            double salaraioProf = Double.parseDouble(JOptionPane.showInputDialog("Salario:"));
                            Professor professor = new Professor(nomeProf, cpfProf, salaraioProf);
                            curso.addProf(professor);
                        }
                    }
                    break;
                case "3":
                    String nomeCursoA = JOptionPane.showInputDialog("Informe o Nome do Curso:");
                    try {
                        boolean encontrado = false;
                        for (Curso curso : cursos) {
                            if (curso.getNomeCurso().equalsIgnoreCase(nomeCursoA)) {
                                encontrado = true;
                                boolean novoAluno = true;
                                do {
                                    String nomeAluno = JOptionPane.showInputDialog("Nome:");
                                    String cpfAluno = JOptionPane.showInputDialog("CPF:");
                                    String matriculaAluno = JOptionPane.showInputDialog("Matricula:");
                                    curso.addAluno(new Aluno(nomeAluno, cpfAluno, matriculaAluno));
                                    novoAluno = JOptionPane.showInputDialog(
                                            "Inserir novo Aluno?\n"
                                                    + "1- Sim\n"
                                                    + "2- Não").equals("1")?true:false;
                                } while (encontrado);
                            }
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                default:
                    break;
            }

        } while (operacao != "7");
    }
}