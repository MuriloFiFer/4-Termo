package com.example.view;

import com.example.api.MaquinaAPI;
import com.example.models.Maquina;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SistemaManutencaoGUI extends JPanel {

    private JTextField codigoField;
    private JTextField nomeField;
    private JTextField modeloField;
    private JTextField fabricanteField;
    private JTextField dataAquisicaoField;
    private JTextField tempoVidaEstimadoField;
    private JTextField localizacaoField;
    private JTextArea detalhesArea;
    private JTextField manualField;

    public void SistemaManutencaoGUI() {
        setLayout(new BorderLayout());

        // Painel de formulário
        JPanel formPanel = new JPanel(new GridLayout(10, 2));

        formPanel.add(new JLabel("Código:"));
        codigoField = new JTextField();
        formPanel.add(codigoField);

        formPanel.add(new JLabel("Nome:"));
        nomeField = new JTextField();
        formPanel.add(nomeField);

        formPanel.add(new JLabel("Modelo:"));
        modeloField = new JTextField();
        formPanel.add(modeloField);

        formPanel.add(new JLabel("Fabricante:"));
        fabricanteField = new JTextField();
        formPanel.add(fabricanteField);

        formPanel.add(new JLabel("Data de Aquisição:"));
        dataAquisicaoField = new JTextField();
        formPanel.add(dataAquisicaoField);

        formPanel.add(new JLabel("Tempo de Vida Estimado:"));
        tempoVidaEstimadoField = new JTextField();
        formPanel.add(tempoVidaEstimadoField);

        formPanel.add(new JLabel("Localização:"));
        localizacaoField = new JTextField();
        formPanel.add(localizacaoField);

        formPanel.add(new JLabel("Detalhes:"));
        detalhesArea = new JTextArea(3, 20);
        JScrollPane scrollPane = new JScrollPane(detalhesArea);
        formPanel.add(scrollPane);

        formPanel.add(new JLabel("Manual:"));
        manualField = new JTextField();
        formPanel.add(manualField);

        add(formPanel, BorderLayout.CENTER);

        // Painel de botões
        JPanel buttonPanel = new JPanel();

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarMaquina();
            }
        });
        buttonPanel.add(cadastrarButton);

        JButton salvarButton = new JButton("Salvar");
        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarMaquina();
            }
        });
        buttonPanel.add(salvarButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void cadastrarMaquina() {
        // Limpar os campos para novo cadastro
        codigoField.setText("");
        nomeField.setText("");
        modeloField.setText("");
        fabricanteField.setText("");
        dataAquisicaoField.setText("");
        tempoVidaEstimadoField.setText("");
        localizacaoField.setText("");
        detalhesArea.setText("");
        manualField.setText("");
    }

    private void salvarMaquina() {
        // Coletar dados do formulário
        Maquina maquina = new Maquina();
        maquina.setCodigo(codigoField.getText());
        maquina.setNome(nomeField.getText());
        maquina.setModelo(modeloField.getText());
        maquina.setFabricante(fabricanteField.getText());
        maquina.setDataAquisicao(dataAquisicaoField.getText());
        maquina.setTempoVidaEstimado(Integer.parseInt(tempoVidaEstimadoField.getText()));
        maquina.setLocalizacao(localizacaoField.getText());
        maquina.setDetalhes(detalhesArea.getText());
        maquina.setManual(manualField.getText());

        // Enviar para a API
        String response = MaquinaAPI.postMaquina(maquina);
        JOptionPane.showMessageDialog(this, response, "Resposta do Servidor", JOptionPane.INFORMATION_MESSAGE);
    }
}
