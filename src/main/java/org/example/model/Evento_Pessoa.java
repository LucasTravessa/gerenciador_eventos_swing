package org.example.model;

public class Evento_Pessoa {
    private String cpf_pessoa;
    private String nome_evento;

    public Evento_Pessoa(String cpf_pessoa, String nome_evento) {
        this.cpf_pessoa = cpf_pessoa;
        this.nome_evento = nome_evento;
    }

    public String getCpf_pessoa() {
        return cpf_pessoa;
    }

    public String getNome_evento() {
        return nome_evento;
    }

}
