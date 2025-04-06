package org.example;

import org.example.controller.MainController;
import org.example.view.MainView;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância da interface gráfica principal (MainView) que contém as abas
        MainView mainView = new MainView();

        // Cria uma instância do controlador que conecta a interface com a lógica do programa
        // Supondo que o EventoController agora irá gerenciar as várias views
        @SuppressWarnings("unused")
        MainController controller = new MainController(mainView);
    }
}