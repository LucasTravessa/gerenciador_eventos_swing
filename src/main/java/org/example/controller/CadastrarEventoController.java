package org.example.controller;

import org.example.model.Evento;
import org.example.repository.EventoRepository;
import org.example.view.CadastrarEventoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastrarEventoController {
    private final CadastrarEventoView view;
    private final EventoRepository eventoRepository;

    public CadastrarEventoController(CadastrarEventoView view) {
        this.view = view;
        this.eventoRepository = new EventoRepository();

        this.view.setSalvarEventoListener(new SalvarEventoListener());
    }

    private class SalvarEventoListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = view.getNome();
            String tipo = view.getTipo();
            String local = view.getLocal();

            Evento evento = new Evento(null, nome, tipo, local);
            eventoRepository.addEvento(evento);

            JOptionPane.showMessageDialog(view, "Evento salvo com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
