package br.com.alves.ed.mapa;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Mapa<C, V> {
    private int tamanho;
    private List<List<Associacao<C, V>>> tabela;

    public Mapa() {
        tabela = new ArrayList<List<Associacao<C, V>>>();
        this.tamanho = 0;
        for (int i = 0; i < 5; i++) {
            tabela.add(new LinkedList<Associacao<C, V>>());
        }
    }

    public void adicionar(C chave, V valor) {
        if (this.contemChave(chave)) {
            this.remover(chave);
        }
        this.verificaCarga();
        int indice = this.calculaIndiceTabela(chave);
        List<Associacao<C, V>> lista = this.tabela.get(indice);
        lista.add(new Associacao<C, V>(chave, valor));
        this.tamanho++;

    }
    private void adicionar(Associacao<C, V> associacao) {

        int indice = this.calculaIndiceTabela(associacao.getChave());
        List<Associacao<C, V>> lista = this.tabela.get(indice);
        lista.add(associacao);
        this.tamanho++;

    }

    public V pegar(C chave) {
        int indice = this.calculaIndiceTabela(chave);
        List<Associacao<C, V>> lista = this.tabela.get(indice);

        for (int i = 0; i < lista.size(); i++) {
            Associacao<C, V> associacao = lista.get(i);
            if (chave.equals(associacao.getChave())) {
                return associacao.getValor();
            }
        }
        throw new IllegalArgumentException("Chave não encontrada");
    }

    public int calculaIndiceTabela(C chave) {
        return Math.abs(chave.hashCode()) % this.tabela.size();
    }

    public void remover(C chave) {
        int indice = this.calculaIndiceTabela(chave);
        List<Associacao<C, V>> lista = this.tabela.get(indice);
        for (int i = 0; i < lista.size(); i++) {
            Associacao<C, V> associacao = lista.get(i);
            if (chave.equals(associacao.getChave())) {
                lista.remove(i);
                this.tamanho--;
                this.verificaCarga();
                return;
            }
        }
        throw new IllegalArgumentException("Chave não encontrada");

    }

    public boolean contemChave(C chave) {
        int indice = this.calculaIndiceTabela(chave);
        List<Associacao<C, V>> lista = this.tabela.get(indice);

        for (int i = 0; i < lista.size(); i++) {
            Associacao<C, V> associacao = lista.get(i);
            if (associacao.getChave().equals(chave)) {
                return true;
            }
        }
        return false;
    }

    public int tamanho() {
        return this.tamanho;
    }

    private void verificaCarga() {
        double carga = (double) this.tamanho / this.tabela.size();

        if (carga > 0.75) {
            this.redimesionaTabela(this.tabela.size() * 2);
        }else if(carga < 0.25){
            this.redimesionaTabela(Math.max(this.tabela.size()/2, 10));
        }
    }

    private void redimesionaTabela(int tamanho) {
        List<Associacao<C, V>> lista = this.pegarTodos();
        this.tamanho = 0;
        this.tabela.clear();
        for(int i = 0; i < tamanho; i++){
            this.tabela.add(new LinkedList<Associacao<C, V>>());
        }
        for(Associacao<C, V> associacao : lista){
            this.adicionar(associacao);
        }
    }

    private List<Associacao<C, V>> pegarTodos() {
        ArrayList<Associacao<C, V>> listas = new ArrayList<Associacao<C, V>>();
        for (List<Associacao<C, V>> list : this.tabela) {
            listas.addAll(list);
        }
        return listas;
    }

    public void imprimirTabela() {
        for (List<Associacao<C, V>> lista : this.tabela) {
            System.out.print("[");
            for (int i = 0; i < lista.size(); i++) {
                System.out.print("*");
            }
            System.out.println("]");
        }
    }

    @Override
    public String toString() {
        return this.pegarTodos().toString();
    }
}
