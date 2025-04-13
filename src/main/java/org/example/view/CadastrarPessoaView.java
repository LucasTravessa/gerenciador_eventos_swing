package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CadastrarPessoaView extends JPanel {
    private final JTextField nomeField;
    private final JTextField cpfField;
    private final JTextField emailField;
    private final JButton salvarButton;

    public CadastrarPessoaView() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Margem maior para o espaçamento
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o conteúdo

        nomeField = new JTextField(25);
        cpfField = new JTextField(25);
        emailField = new JTextField(25);
        salvarButton = new JButton("Salvar");

        salvarButton.setPreferredSize(new Dimension(80, 30)); // Dimensões do botão

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome"), gbc);

        gbc.gridx = 1;
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("CPF"), gbc);

        gbc.gridx = 1;
        add(cpfField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Email"), gbc);

        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(salvarButton, gbc);
    }

    public String getNome() {
        return nomeField.getText();
    }

    public String getCpf() {
        return cpfField.getText();
    }

    public String getEmail() {
        return emailField.getText();
    }

    public void setSalvarPessoaListener(ActionListener listener) {

        for (ActionListener al : salvarButton.getActionListeners()) {

            salvarButton.removeActionListener(al);

        }

        salvarButton.addActionListener(listener);
    }
}
