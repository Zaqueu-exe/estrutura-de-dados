package br.com.alves.ed.application;

import br.com.alves.ed.conjunto.Conjunto;

import java.util.HashSet;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        Conjunto<String> conjunto = new Conjunto<>();
        //HashSet<Integer> ta = new HashSet<>();
        conjunto.inserir("Ana");
        conjunto.inserir("Barbara");
        conjunto.inserir("Catia");
        conjunto.inserir("Multa");
        conjunto.inserir("Vidro");
        conjunto.inserir("Casa");
        conjunto.inserir("Paulo");
        conjunto.remover("Casa");
        System.out.println(conjunto.tamanho());
        List<String> elementos = conjunto.pegarTodos();
        for (String palavras: elementos) {
            System.out.println(palavras);
        }
        conjunto.imprimirTabela();
    }
}
