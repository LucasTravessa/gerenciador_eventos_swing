package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InscreverPessoaView extends JPanel {
    private JTextField cpfPessoaField;
    private JTextField nomeEventoField;
    private JButton inscreverButton;

    public InscreverPessoaView() {
        // Define o layout
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margem para espaçamento
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o conteúdo

        // Criação dos componentes
        cpfPessoaField = new JTextField(20);
        nomeEventoField = new JTextField(20);
        inscreverButton = new JButton("Inscrever");

        // Estiliza o botão
        inscreverButton.setPreferredSize(new Dimension(100, 30)); // Dimensões do botão

        // Adiciona os componentes ao painel
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("CPF da Pessoa:"), gbc);

        gbc.gridx = 1;
        add(cpfPessoaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Nome do Evento:"), gbc);

        gbc.gridx = 1;
        add(nomeEventoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2; // O botão ocupa duas colunas
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o botão
        add(inscreverButton, gbc);

        // Ajusta o tamanho do painel
        setPreferredSize(new Dimension(400, 200));
    }
    

    // Métodos para obter os dados
    public String getNomePessoa() {
        return cpfPessoaField.getText();
    }

    public String getNomeEvento() {
        return nomeEventoField.getText();
    }

    // Método para definir o listener do botão
    public void setInscreverPessoaListener(ActionListener listener) {
        
        // Remove todos os listeners antigos antes de adicionar o novo
        for (ActionListener al : inscreverButton.getActionListeners()) {
            inscreverButton.removeActionListener(al);
        }
        // Adiciona o novo listener
        inscreverButton.addActionListener(listener);
    }
}
