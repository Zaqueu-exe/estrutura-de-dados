package br.com.alves.ed.application;

import br.com.alves.ed.entities.Carro;
import br.com.alves.ed.mapa.Mapa;

import java.util.HashMap;

public class Program {
    public static void main(String[] args) {
        Mapa<String, Carro> mapa = new Mapa<String, Carro>();
        HashMap<String, Carro> map = new HashMap<String, Carro>();
        mapa.adicionar("123", new Carro("Chevete", "Verde", "Chevrolet", 1999));
        mapa.adicionar("123g", new Carro("Chevete", "Verde", "Chevrolet", 1999));
        mapa.adicionar("123", new Carro("Chevete", "Verde", "Chevrolet", 1999));
        mapa.adicionar("124", new Carro("Uno", "Verde", "Fiat", 2005));
        System.out.println(mapa);
        mapa.imprimirTabela();
    }
}
