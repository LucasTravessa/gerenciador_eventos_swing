package org.example.controller;

import org.example.model.Pessoa;
import org.example.repository.PessoaRepository;
import org.example.view.CadastrarPessoaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CadastrarPessoaController {
    private CadastrarPessoaView view;
    private PessoaRepository pessoaRepository;

    public CadastrarPessoaController(CadastrarPessoaView view) {
        this.view = view;
        this.pessoaRepository = new PessoaRepository();

        this.view.setSalvarPessoaListener(new SalvarPessoaListener());
    }

    private class SalvarPessoaListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nome = view.getNome();
            String cpf = view.getCpf();
            String email = view.getEmail();
    
//            Pessoa pessoa = new Pessoa(nome, cpf, email);
//            pessoaRepository.addPessoa(pessoa);
    
            JOptionPane.showMessageDialog(view, "Pessoa salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
