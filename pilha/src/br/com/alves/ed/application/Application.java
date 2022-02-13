package br.com.alves.ed.application;

import br.com.alves.ed.entities.Peca;
import br.com.alves.ed.pilha.Pilha;

import java.util.Stack;

public class Application {
    public static void main(String[] args) {
        Pilha<Peca> pilha = new Pilha<>();
        Stack<Integer> aa= new Stack<>();

        pilha.inserir(new Peca("Pneu"));
        pilha.inserir(new Peca("Vidro"));
        pilha.inserir(new Peca("Jante"));
        pilha.inserir(new Peca("Retrovisor"));
        System.out.println(pilha.pesquisarElemento(new Peca("Retrovisor")));
        System.out.println(pilha);
    }
}
