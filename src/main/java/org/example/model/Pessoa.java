package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pessoa {
    private int id;
    private String nome;
    private String cpf;
    private String email;
}
