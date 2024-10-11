package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.example.controllers.HistoricoManutencaoController; // Controller para Histórico de Manutenção
import com.example.models.HistoricoManutencao; // Modelo para Histórico de Manutenção

public class ManutencaoPanel extends JPanel {
    private HistoricoManutencaoController manutencaoController;
    private JTable manutencaoTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarHistorico;

    public ManutencaoPanel() {
        super(new BorderLayout());
        manutencaoController = new HistoricoManutencaoController();

        tableModel = new DefaultTableModel(new Object[]{
                "ID", "Máquina ID", "Data", "Tipo", "Peças Trocadas", "Tempo de Parada", "Técnico ID", "Observações"
        }, 0);
        manutencaoTable = new JTable(tableModel);

        List<HistoricoManutencao> historicos = manutencaoController.readHistorico();
        for (HistoricoManutencao historico : historicos) {
            tableModel.addRow(new Object[]{
                    historico.getId(),
                    historico.getMaquinaID(),
                    historico.getData(),
                    historico.getTipo(),
                    historico.getPecasTrocadas(),
                    historico.getTempoDeParada(),
                    historico.getTecnicoID(),
                    historico.getObservacoes()
            });
        }

        JScrollPane scrollPane = new JScrollPane(manutencaoTable);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarHistorico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarHistorico);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // ActionListener para o botão Cadastrar
        btnCadastrarHistorico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar um novo histórico de manutenção
                JOptionPane.showMessageDialog(ManutencaoPanel.this, "Cadastrar novo histórico (implementação necessária).");
            }
        });

        // ActionListener para o botão Salvar
        btnSalvarAlteracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salvar alterações
                JOptionPane.showMessageDialog(ManutencaoPanel.this, "Salvar alterações (implementação necessária).");
            }
        });
    }
}
