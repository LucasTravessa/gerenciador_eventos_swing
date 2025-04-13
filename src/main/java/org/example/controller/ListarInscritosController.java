package org.example.controller;

import org.example.model.Evento;
import org.example.model.Pessoa;
import org.example.repository.EventoRepository;
import org.example.repository.PessoaEventoRepository;
import org.example.repository.PessoaRepository;
import org.example.view.ListarInscritosView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ListarInscritosController {
    private final ListarInscritosView view;
    private final EventoRepository eventoRepository;
    private final PessoaEventoRepository pessoaEventoRepository;

    private final List<Pessoa> pessoas;

    public ListarInscritosController(ListarInscritosView view) {
        this.view = view;

        PessoaRepository pessoaRepository = new PessoaRepository();
        this.eventoRepository = new EventoRepository();
        this.pessoaEventoRepository = new PessoaEventoRepository();

        this.pessoas = pessoaRepository.getAllPessoas();

        this.view.getBuscarButton().addActionListener(new BuscarInscritosListener());
    }

    private class BuscarInscritosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buscarInscritosPorEvento();
        }
    }

    private void buscarInscritosPorEvento() {
        String nomeEvento = view.getNomeEvento().trim();
        view.limparInscritos();

        Evento evento = eventoRepository.getEventoByNome(nomeEvento);

        if (evento == null) {
            JOptionPane.showMessageDialog(view, "Nenhum inscrito encontrado para o evento: " + nomeEvento, "Evento não encontrado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Integer> pessoasIdEvento = pessoaEventoRepository.getPessoasForEvento(evento.getId());

        pessoasIdEvento.forEach((pessoaId) -> pessoas.stream()
                .filter(p -> p.getId().equals(pessoaId))
                .findFirst()
                .ifPresent(pessoa -> view.addInscrito(pessoa.getNome())));
    }

}
