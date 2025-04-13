package org.example;

import org.example.controller.MainController;
import org.example.view.MainView;

public class Main {
    public static void main(String[] args) {
        new MainController(new MainView());
    }
}