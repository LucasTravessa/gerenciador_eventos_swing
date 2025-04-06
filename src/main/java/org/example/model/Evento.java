package org.example.model;

public class Evento {
    private String nome;
    private String tipo;
    private String local;

    public Evento(String nome, String tipo, String local) {
        this.nome = nome;
        this.tipo = tipo;
        this.local = local;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLocal() {
        return local;
    }
}
