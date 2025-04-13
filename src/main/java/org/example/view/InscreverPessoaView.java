package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InscreverPessoaView extends JPanel {
    private final JTextField cpfPessoaField;
    private final JTextField nomeEventoField;
    private final JButton inscreverButton;

    public InscreverPessoaView() {
        setLayout(new GridBagLayout());
        setBackground(Color.cyan);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        cpfPessoaField = new JTextField(20);
        nomeEventoField = new JTextField(20);
        inscreverButton = new JButton("Inscrever");

        inscreverButton.setPreferredSize(new Dimension(100, 30));

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
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(inscreverButton, gbc);

        setPreferredSize(new Dimension(400, 200));
    }

    public String getNomePessoa() {
        return cpfPessoaField.getText();
    }

    public String getNomeEvento() {
        return nomeEventoField.getText();
    }

    public void setInscreverPessoaListener(ActionListener listener) {
        for (ActionListener al : inscreverButton.getActionListeners()) {
            inscreverButton.removeActionListener(al);
        }

        inscreverButton.addActionListener(listener);
    }
}
