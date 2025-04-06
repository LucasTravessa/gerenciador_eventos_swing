package org.example.controller;

import org.example.view.MainView;

public class MainController {

  // Referência para a view principal
  private MainView mainView;
  
  // Controladores das abas
  private CadastrarEventoController cadastrarEventoController;
  private CadastrarPessoaController cadastrarPessoaController;
  private InscreverPessoaController inscreverPessoaController;
  private ListarInscritosController listarInscritosController;

  public MainController(MainView mainView) {
    this.mainView = mainView;

    // Inicializa os controladores de cada aba
    // Passando as instâncias corretas das views já criadas
    this.cadastrarEventoController = new CadastrarEventoController(this.mainView.getCadastrarEventoView());
    this.cadastrarPessoaController = new CadastrarPessoaController(this.mainView.getCadastrarPessoaView());
    this.inscreverPessoaController = new InscreverPessoaController(this.mainView.getInscreverPessoaView());
    this.listarInscritosController = new ListarInscritosController(this.mainView.getListarInscritosView());
  }
}
