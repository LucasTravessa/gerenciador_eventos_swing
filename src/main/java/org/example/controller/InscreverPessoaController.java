package org.example.controller;

import org.example.model.Evento;
import org.example.model.Pessoa;
import org.example.repository.EventoRepository;
import org.example.repository.PessoaEventoRepository;
import org.example.repository.PessoaRepository;
import org.example.view.InscreverPessoaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class InscreverPessoaController {
    private InscreverPessoaView view;
    private PessoaRepository pessoaRepository;
    private EventoRepository eventoRepository;
    private PessoaEventoRepository pessoaEventoRepository;

    private List<Pessoa> pessoas;
    private List<Evento> eventos;

    public InscreverPessoaController(InscreverPessoaView view) {
        this.view = view;
        this.pessoaRepository = new PessoaRepository();
        this.eventoRepository = new EventoRepository();
        this.pessoaEventoRepository = new PessoaEventoRepository();

        this.pessoas = pessoaRepository.getAllPessoas();
        this.eventos = eventoRepository.getAllEventos();

        this.view.setInscreverPessoaListener(new InscreverPessoaListener());
    }


    private class InscreverPessoaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cpfPessoa = view.getNomePessoa();
            String nomeEvento = view.getNomeEvento();
            System.out.println("CPF digitado: " + cpfPessoa);
            System.out.println("Evento digitado: " + nomeEvento);

            // Verifica se o CPF e o nome do evento existem
            Optional<Pessoa> pessoa = pessoas.stream().filter(p -> Objects.equals(p.getCpf(), cpfPessoa)).findFirst();
            if (pessoa.isEmpty()) {
                JOptionPane.showMessageDialog(view, "CPF " + cpfPessoa + " não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Optional<Evento> evento = eventos.stream().filter(ev -> Objects.equals(ev.getNome(), nomeEvento)).findFirst();
            if (evento.isEmpty()) {
                JOptionPane.showMessageDialog(view, "Evento " + nomeEvento + " não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
    
            // Se ambos existem, prossegue com a inscrição
            pessoaEventoRepository.addPessoaToEvento(pessoa.get().getId(), evento.get().getId());
    
            JOptionPane.showMessageDialog(view, "Pessoa " + cpfPessoa + " inscrita no evento " + nomeEvento + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
