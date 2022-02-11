package br.com.alves.ed.application;

import br.com.alves.ed.entities.Aluno;
import br.com.alves.ed.entities.Lista;

public class Program {
    public static void main(String[] args) {
        Lista<Aluno> l = new Lista<Aluno>();
        //long a = System.currentTimeMillis();
        l.inserir(new Aluno("Pedro", 59));
        l.inserir(1, new Aluno("Ana", 60));
        l.inserir(new Aluno("Paula", 9));
        System.out.println(l.tamanho());
        System.out.println(l.seExiste(new Aluno("Ana", 59)));
        //l.remover(0);
        System.out.println(l);
        //System.out.println(l.pegar(1));
        //long b = System.currentTimeMillis();
        //System.out.println("Tempo: " + ((b - a) / 1000.0));
    }
}
