package com.example.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import com.example.controllers.TecnicosController; // Controller para Técnicos
import com.example.models.Tecnicos; // Modelo para Técnicos

public class TecnicosPanel extends JPanel {
    private TecnicosController tecnicosController;
    private JTable tecnicosTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarTecnico;

    public TecnicosPanel() {
        super(new BorderLayout());
        tecnicosController = new TecnicosController();

        tableModel = new DefaultTableModel(new Object[]{
                "ID", "Máquina ID", "Data", "Tipo", "Peças Trocadas", "Tempo de Parada", "Técnico ID", "Observações"
        }, 0);
        tecnicosTable = new JTable(tableModel);

        List<Tecnicos> tecnicos = tecnicosController.readTecnicos();
        for (Tecnicos tecnico : tecnicos) {
            tableModel.addRow(new Object[]{
                    tecnico.getId(),
                    tecnico.getMaquinaID(),
                    tecnico.getData(),
                    tecnico.getTipo(),
                    tecnico.getPecasTrocadas(),
                    tecnico.getTempoDeParada(),
                    tecnico.getTecnicoID(),
                    tecnico.getObservacoes()
            });
        }

        JScrollPane scrollPane = new JScrollPane(tecnicosTable);
        this.add(scrollPane, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarTecnico = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarTecnico);
        painelInferior.add(btnSalvarAlteracoes);
        this.add(painelInferior, BorderLayout.SOUTH);

        // ActionListener para o botão Cadastrar
        btnCadastrarTecnico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar um novo técnico
                JOptionPane.showMessageDialog(TecnicosPanel.this, "Cadastrar novo técnico (implementação necessária).");
            }
        });

        // ActionListener para o botão Salvar
        btnSalvarAlteracoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para salvar alterações
                JOptionPane.showMessageDialog(TecnicosPanel.this, "Salvar alterações (implementação necessária).");
            }
        });
    }
}
