package org.example.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CadastrarEventoView extends JPanel {
    private final JTextField nomeField;
    private final JTextField tipoField;
    private final JTextField localField;
    private final JButton salvarButton;

    public CadastrarEventoView() {
        setLayout(new GridBagLayout());
        setBackground(Color.GREEN);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        nomeField = new JTextField(25);
        tipoField = new JTextField(25);
        localField = new JTextField(25);
        salvarButton = new JButton("Salvar");

        salvarButton.setPreferredSize(new Dimension(80, 30));

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        add(nomeField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Tipo:"), gbc);

        gbc.gridx = 1;
        add(tipoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Local:"), gbc);

        gbc.gridx = 1;
        add(localField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(salvarButton, gbc);
    }

    public String getNome() {
        return nomeField.getText();
    }

    public String getTipo() {
        return tipoField.getText();
    }

    public String getLocal() {
        return localField.getText();
    }

    public void setSalvarEventoListener(ActionListener listener) {

        for (ActionListener al : salvarButton.getActionListeners()) {

            salvarButton.removeActionListener(al);

        }

        salvarButton.addActionListener(listener);
    }
}
