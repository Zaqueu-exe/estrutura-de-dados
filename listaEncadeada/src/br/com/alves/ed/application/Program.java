package br.com.alves.ed.application;

import br.com.alves.ed.entities.Aluno;
import br.com.alves.ed.listaecadeada.Lista;

public class Program {
    public static void main(String[] args) {
        Lista<Aluno> l = new Lista<>();
        l.inserir(new Aluno("Gustavo", 50));
        l.inserir(new Aluno("Neymar", 8));
        l.inserir(new Aluno("Cebolinha", 7));
        l.inserir(new Aluno("Newton", 89));
        l.inserir(new Aluno("Sabrina", 99));
        l.limpar();
        l.inserir(0, new Aluno("Ricardo", 5));
        System.out.println(l);
    }
}
