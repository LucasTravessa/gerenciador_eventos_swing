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
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListarInscritosController {
    private ListarInscritosView view;
    private PessoaRepository pessoaRepository;
    private EventoRepository eventoRepository;
    private PessoaEventoRepository pessoaEventoRepository;

    private List<Pessoa> pessoas;

    public ListarInscritosController(ListarInscritosView view) {
        this.view = view;

        this.pessoaRepository = new PessoaRepository();
        this.eventoRepository = new EventoRepository();
        this.pessoaEventoRepository = new PessoaEventoRepository();

        this.pessoas = pessoaRepository.getAllPessoas();

        // Adiciona ação ao botão de buscar
        this.view.getBuscarButton().addActionListener(new BuscarInscritosListener());
    }

    // ActionListener para o botão de buscar
    private class BuscarInscritosListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            buscarInscritosPorEvento();
        }
    }

    private void buscarInscritosPorEvento() {
        String nomeEvento = view.getNomeEvento().trim();  // Remove espaços em branco extras
        view.limparInscritos(); // Limpa a área de texto antes de mostrar os novos resultados

        Evento evento = eventoRepository.getEventoByNome(nomeEvento);

        if (evento == null) {
            JOptionPane.showMessageDialog(view, "Nenhum inscrito encontrado para o evento: " + nomeEvento, "Evento não encontrado", JOptionPane.ERROR_MESSAGE);
            return;
        }

        List<Integer> pessoasIdEvento = pessoaEventoRepository.getPessoasForEvento(evento.getId());

        pessoasIdEvento.forEach((pessoaId) ->{
            pessoas.stream()
                    .filter(p -> p.getId().equals(pessoaId)).findFirst().ifPresent(pessoa -> view.addInscrito(pessoa.getNome()));
        });
    }

}
