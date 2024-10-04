package com.example;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.GridLayout;


public class CalculadoraAvancada extends JPanel {
    JTextField displaySimples;
    String[] botoes = { "^", "sqrt", "log", "!",
                        "7", "8", "9", "/",
                        "4", "5", "6", "*",
                        "1", "2", "3", "-",
                        "0", "=", "+", "C" };
   //construtor
    public CalculadoraAvancada(){
        super(new BorderLayout());
        displaySimples= new JTextField();
        displaySimples.setHorizontalAlignment(JTextField.RIGHT);
        displaySimples.setEditable(false);
        this.add(displaySimples, BorderLayout.NORTH);

        //criar um Painel para os botões
        JPanel painelBotoes = new JPanel(new GridLayout(5, 5, 3, 3));
        for (String textoBotoes : botoes) {
            JButton botao = new JButton(textoBotoes);
            botao.addActionListener(null);
            //adicionar acão  dos botoes
            painelBotoes.add(botao);
        }
        this.add(painelBotoes, BorderLayout.CENTER);
}

}
