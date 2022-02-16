package br.com.alves.ed.entities;

import java.util.Objects;

public class Carro {
    private String nome;
    private String cor;
    private String marca;
    private int ano;

    public Carro(String nome, String cor, String marca, int ano) {
        this.nome = nome;
        this.cor = cor;
        this.marca = marca;
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getMarca() {
        return marca;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Cor: " + cor + ", Marca: " + marca + ", Ano: " + ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return ano == carro.ano && Objects.equals(nome, carro.nome) && Objects.equals(cor, carro.cor) && Objects.equals(marca, carro.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cor, marca, ano);
    }
}
