package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Evento {
    private int id;
    private String nome;
    private String tipo;
    private String local;
    private String data;
}
