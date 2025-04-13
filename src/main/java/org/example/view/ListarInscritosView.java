package org.example.view;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public class ListarInscritosView extends JPanel {
    private final JTextArea inscritosArea;
    private final JTextField nomeEventoField;
    @Getter
    private final JButton buscarButton;

    public ListarInscritosView() {
        setLayout(new BorderLayout());

        JPanel buscaPanel = new JPanel();
        buscaPanel.setLayout(new FlowLayout());

        JLabel nomeEventoLabel = new JLabel("Nome do Evento:");
        nomeEventoField = new JTextField(15);
        buscarButton = new JButton("Buscar");

        buscaPanel.add(nomeEventoLabel);
        buscaPanel.add(nomeEventoField);
        buscaPanel.add(buscarButton);

        add(buscaPanel, BorderLayout.NORTH);

        inscritosArea = new JTextArea(10, 30);
        inscritosArea.setEditable(false);
        inscritosArea.setLineWrap(true);
        inscritosArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(inscritosArea);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addInscrito(String inscrito) {
        inscritosArea.append(inscrito + "\n");
    }

    public void limparInscritos() {
        inscritosArea.setText("");
    }

    public String getNomeEvento() {
        return nomeEventoField.getText().trim();
    }
}
