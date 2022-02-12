package br.com.alves.ed.entities;

public class Aluno {
    private String nome;
    private int nota;

    public Aluno(String nome, int nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +"(" + nota + ")\n";
    }

    @Override
    public boolean equals(Object o) {
        Aluno alunoC = (Aluno) o;
        return this.nome.equals(alunoC.getNome());
    }

}
