package com.example.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaulTableModel;

import com.example.controllers.MaquinaController;

public class MaquinasPanel extends JPanel {
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaulTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMauqina;

}
