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

    public InscreverPessoaController(InscreverPessoaView view) {
        this.view = view;
        this.pessoaRepository = new PessoaRepository();
        this.eventoRepository = new EventoRepository();
        this.pessoaEventoRepository = new PessoaEventoRepository();


        this.view.setInscreverPessoaListener(new InscreverPessoaListener());
    }


    private class InscreverPessoaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cpfPessoa = view.getNomePessoa();
            String nomeEvento = view.getNomeEvento();

            Pessoa pessoa = pessoaRepository.getPessoaByCpf(cpfPessoa);
            if (pessoa == null) {
                JOptionPane.showMessageDialog(view, "CPF " + cpfPessoa + " não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

           Evento evento = eventoRepository.getEventoByNome(nomeEvento);
            if (evento == null) {
                JOptionPane.showMessageDialog(view, "Evento " + nomeEvento + " não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            pessoaEventoRepository.addPessoaToEvento(pessoa.getId(), evento.getId());
    
            JOptionPane.showMessageDialog(view, "Pessoa " + cpfPessoa + " inscrita no evento " + nomeEvento + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
