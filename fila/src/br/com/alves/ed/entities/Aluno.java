package br.com.alves.ed.entities;

import java.util.Objects;

public class Aluno {
    private String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n";
    }

    @Override
    public boolean equals(Object o) {
        Aluno novoAluno = (Aluno) o;
        return this.nome.equals(novoAluno.getNome());
    }

}
