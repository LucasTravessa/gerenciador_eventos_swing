package org.example.view;

import lombok.Getter;
import org.example.controller.MainController;

import javax.swing.*;

@Getter
public class MainView extends JFrame {
    private final CadastrarPessoaView cadastrarPessoaView;
    private final CadastrarEventoView cadastrarEventoView;
    private final InscreverPessoaView inscreverPessoaView;
    private final ListarInscritosView listarInscritosView;

    public MainView() {
        setTitle("Gerenciamento de Eventos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        cadastrarPessoaView = new CadastrarPessoaView();
        cadastrarEventoView = new CadastrarEventoView();
        inscreverPessoaView = new InscreverPessoaView();
        listarInscritosView = new ListarInscritosView();

        tabbedPane.addTab("Cadastrar Pessoa", cadastrarPessoaView);
        tabbedPane.addTab("Cadastrar Evento", cadastrarEventoView);
        tabbedPane.addTab("Inscrever Pessoa em Evento", inscreverPessoaView);
        tabbedPane.addTab("Listar Inscritos", listarInscritosView);

        add(tabbedPane);

        new MainController(this);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
