package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.example.controllers.FalhasController;
import com.example.models.Falhas;

public class FalhasPanel extends JPanel {
    private FalhasController falhasController;
    private JTable falhasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarFalha;

    public FalhasPanel() {
        super(new BorderLayout());
        falhasController = new FalhasController();

        tableModel = new DefaultTableModel(new Object[]{
                "ID", "Máquina ID", "Data", "Tipo", "Peças Trocadas", "Tempo de Parada", "Técnico ID", "Observações"
        }, 0);
        falhasTable = new JTable(tableModel);

        List<Falhas> falhas = falhasController.readFalhas();
        for (Falhas falha : falhas) {
            tableModel.addRow(new Object[]{
                    falha.getId(),
                    falha.getMaquinaID(),
                    falha.getData(),
                    falha.getTipo(),
                    falha.getPecasTrocadas(),
                    falha.getTempoDeParada(),
                    falha.getTecnicoID(),
                    falha.getObservacoes()
            });
        }

        JScrollPane scrollPane = new JScrollPane(falhasTable);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarFalha = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarFalha);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // ActionListener para o botão Cadastrar
        btnCadastrarFalha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar uma nova falha
                // Exemplo: abrir um formulário para adicionar uma nova falha
                JOptionPane.showMessageDialog(FalhasPanel.this, "Cadastrar nova falha (implementação necessária).");
            }
        });

        // ActionListener para o botão Salvar
        btnSalvarAlteracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salvar alterações
                // Exemplo: salvar as alterações feitas na tabela
                JOptionPane.showMessageDialog(FalhasPanel.this, "Salvar alterações (implementação necessária).");
            }
        });
    }
}
