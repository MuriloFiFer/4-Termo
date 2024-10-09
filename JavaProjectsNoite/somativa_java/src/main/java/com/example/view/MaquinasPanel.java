package com.example.view;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;

import com.example.controllers.MaquinaController;

public class MaquinasPanel extends JPanel {
    private MaquinaController maquinaController;
    private JTable maquinasTable;
    private DefaultTableModel tableModel;
    private JButton btnSalvarAlteracoes;
    private JButton btnCadastrarMauqina;

    //construtor
    public MaquinasPanel() {
        super(new BorderLayout());
        maquinaController = new MaquinaController();
}

}
