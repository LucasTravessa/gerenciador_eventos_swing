package org.example.controller;

import org.example.view.MainView;

public class MainController {

    public MainController(MainView mainView) {

        new CadastrarEventoController(mainView.getCadastrarEventoView());
        new CadastrarPessoaController(mainView.getCadastrarPessoaView());
        new InscreverPessoaController(mainView.getInscreverPessoaView());
        new ListarInscritosController(mainView.getListarInscritosView());
    }
}
