package br.com.alves.ed.entities;

import java.util.Objects;

public class Palavra {
    private String palavra;

    public Palavra(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    @Override
    public String toString() {
        return "Palavra: " + palavra;
    }

    @Override
    public boolean equals(Object o) {
        Palavra novaPalavra = (Palavra)  o;
        return this.palavra.equals(novaPalavra.getPalavra());
    }

    @Override
    public int hashCode() {
        return Objects.hash(palavra);
    }
}
