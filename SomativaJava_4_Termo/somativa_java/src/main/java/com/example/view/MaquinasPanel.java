package com.example.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

public class MaquinasPanel extends JPanel {
    private MaquinaController maquinaController;  // Controlador de máquinas
    private JTable maquinasTable;                 // Tabela para exibir as máquinas
    private DefaultTableModel tableModel;         // Modelo da tabela
    private JButton btnSalvarAlteracoes;          // Botão para salvar alterações
    private JButton btnCadastrarMaquina;           // Botão para cadastrar nova máquina

    // Construtor
    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();

        // Inicializa o modelo da tabela com as colunas apropriadas
        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Nome", "Fabricante", "Modelo", "Detalhes", "Localização", "Tempo de vida"
        }, 0);
        
        maquinasTable = new JTable(tableModel);

        // Cria a tabela e adiciona as máquinas
        List<Maquina> maquinas = maquinaController.readMaquinas();
        for (Maquina maquina : maquinas) {
            tableModel.addRow(new Object[]{
                maquina.getId(),
                maquina.getNome(),
                maquina.getFabricante(),
                maquina.getModelo(),
                maquina.getDetalhes(),
                maquina.getLocalizacao(),
                maquina.getTempoVidaEstimado()
            });
        }

        // Adiciona a tabela em um JScrollPane para rolagem
        JScrollPane scrollPane = new JScrollPane(maquinasTable);       
        this.add(scrollPane, BorderLayout.CENTER);

        // Adiciona os botões em um painel inferior
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes); 
        this.add(painelInferior, BorderLayout.SOUTH);

        // Cria os ActionListeners para os botões
        btnCadastrarMaquina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Diálogo para cadastrar uma nova máquina
                String nome = JOptionPane.showInputDialog("Nome da Máquina:");
                String fabricante = JOptionPane.showInputDialog("Fabricante:");
                String modelo = JOptionPane.showInputDialog("Modelo:");
                String detalhes = JOptionPane.showInputDialog("Detalhes:");
                String localizacao = JOptionPane.showInputDialog("Localização:");
                String tempoVida = JOptionPane.showInputDialog("Tempo de Vida Estimado:");

                if (nome != null && fabricante != null && modelo != null && detalhes != null && localizacao != null && tempoVida != null) {
                    Maquina novaMaquina = new Maquina(); // Presumindo que você tenha um construtor sem parâmetros
                    
                    novaMaquina.setNome(nome);
                    novaMaquina.setFabricante(fabricante);
                    novaMaquina.setModelo(modelo);
                    novaMaquina.setDetalhes(detalhes);
                    novaMaquina.setLocalizacao(localizacao);

                    // Corrigindo a linha 113
                    if (tempoVida != null && !tempoVida.trim().isEmpty()) {
                        try {
                            novaMaquina.setTempoVidaEstimado(Integer.parseInt(tempoVida));
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(MaquinasPanel.this, "O tempo de vida deve ser um número válido!", "Erro", JOptionPane.ERROR_MESSAGE);
                            return; // Retorna se houver um erro
                        }
                    }

                    maquinaController.createMaquina(novaMaquina); // Método no controlador para adicionar a máquina
                    tableModel.addRow(new Object[]{
                        novaMaquina.getId(),  // Supondo que você defina o ID no controlador
                        novaMaquina.getNome(),
                        novaMaquina.getFabricante(),
                        novaMaquina.getModelo(),
                        novaMaquina.getDetalhes(),
                        novaMaquina.getLocalizacao(),
                        novaMaquina.getTempoVidaEstimado()
                    });
                }
            }
        });

        btnSalvarAlteracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Salvar alterações feitas na tabela
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Maquina maquina = new Maquina();
                    maquina.setId((Integer) tableModel.getValueAt(i, 0));  // Presumindo que o ID é um inteiro
                    maquina.setNome((String) tableModel.getValueAt(i, 1));
                    maquina.setFabricante((String) tableModel.getValueAt(i, 2));
                    maquina.setModelo((String) tableModel.getValueAt(i, 3));
                    maquina.setDetalhes((String) tableModel.getValueAt(i, 4));
                    maquina.setLocalizacao((String) tableModel.getValueAt(i, 5));

                    // Corrigindo a linha 105
                    Object tempoVidaObj = tableModel.getValueAt(i, 6);
                    if (tempoVidaObj instanceof Integer) {
                        maquina.setTempoVidaEstimado((Integer) tempoVidaObj);
                    } else if (tempoVidaObj instanceof String) {
                        try {
                            maquina.setTempoVidaEstimado(Integer.parseInt((String) tempoVidaObj));
                        } catch (NumberFormatException ex) {
                            System.err.println("Erro ao converter tempo de vida: " + tempoVidaObj);
                        }
                    }
                    maquinaController.updateMaquina(i, maquina); // Método no controlador para atualizar a máquina
                }
                JOptionPane.showMessageDialog(MaquinasPanel.this, "Alterações salvas com sucesso!");
            }
        });
    }
}
