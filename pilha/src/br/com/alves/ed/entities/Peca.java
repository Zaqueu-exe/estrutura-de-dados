package br.com.alves.ed.entities;

import java.util.Objects;

public class Peca {
    private String nome;

    public Peca(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString(){
        return "Nome: " + this.nome;
    }

    @Override
    public boolean equals(Object o) {
        Peca peca = (Peca) o;
        return this.nome.equals(peca.getNome());
    }
}
