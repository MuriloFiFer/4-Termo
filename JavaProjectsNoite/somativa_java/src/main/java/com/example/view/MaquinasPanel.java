package com.example.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JScrollPane;


import com.example.controllers.MaquinaController;
import com.example.models.Maquina;

public class MaquinasPanel extends JPanel {
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMaquina;

    //construtor
    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();

        tableModel = new DefaultTableModel(new Object[]{
            "ID", "Nome", "Fabricante", "Modelo", "Detalhes", "Localizacao", "Tempo de vida"
            }, 0);
        maquinasTable = new JTable(tableModel);

        //Criar a tabela
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

        JScrollPane scrollPane = new JScrollPane(maquinasTable);       
        this.add(scrollPane, BorderLayout.CENTER);

        //adicionar os botões
        JPanel painelInferior = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnCadastrarMaquina = new JButton("Cadastrar");
        btnSalvarAlteracoes = new JButton("Salvar");
        painelInferior.add(btnCadastrarMaquina);
        painelInferior.add(btnSalvarAlteracoes); 
        this.add(painelInferior,BorderLayout.SOUTH);

        //criar as ActionLisener para Botões]
    }
};


