package br.com.alves.ed.application;

import br.com.alves.ed.entities.Aluno;
import br.com.alves.ed.fila.Fila;

import java.util.LinkedList;
import java.util.Queue;


public class Program {
    public static void main(String[] args) {
        //Queue<Integer> queue = new LinkedList<>();
        Fila<Aluno> fila = new Fila<>();
        fila.inserir(new Aluno("Vitor"));
        fila.inserir(new Aluno("Ana"));
        fila.inserir(new Aluno("Paula"));
        fila.inserir(new Aluno("Andre"));
        fila.inserir(new Aluno("Jose"));
        fila.remover();
        fila.inserir(new Aluno("Pedro"));
        System.out.println(fila.contem(new Aluno("Pedr")));
        fila.remover();
        fila.remover();
        fila.remover();
        fila.remover();
        //fila.remover();
        System.out.println(fila);

    }
}
