package br.com.alves.ed.conjunto;


import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Conjunto<T> {
    private int tamanho;
    private List<List<T>> tabela;

    public Conjunto() {
        tabela = new ArrayList<List<T>>();
        this.tamanho = 0;
        for (int i = 0; i < 26; i++) {
            LinkedList<T> lista = new LinkedList<T>();
            tabela.add(lista);
        }
    }

    public void inserir(T elemento) {
        if (!this.contem(elemento)) {
            this.verificaCarga();
            int indice = this.calculaIndiceDaTabela(elemento);
            List<T> lista = this.tabela.get(indice);
            lista.add(elemento);
            this.tamanho++;
        }
    }

    public void remover(T elemento) {
        if (this.contem(elemento)) {
            int indice = this.calculaIndiceDaTabela(elemento);
            List<T> lista = this.tabela.get(indice);
            lista.remove(elemento);
            this.tamanho--;
            this.verificaCarga();
        }
    }

    public List<T> pegarTodos() {
        List<T> elementos = new ArrayList<T>();
        for (int i = 0; i < this.tabela.size(); i++) {
            elementos.addAll(this.tabela.get(i));
        }
        return elementos;
    }

    public boolean contem(T elemento) {
        int indice = this.calculaIndiceDaTabela(elemento);
        List<T> lista = this.tabela.get(indice);
        return lista.contains(elemento);
    }

    private int calculaIndiceDaTabela(T elemento) {
        int codigoEspalhamento = elemento.hashCode();
        codigoEspalhamento = Math.abs(codigoEspalhamento);
        return codigoEspalhamento % this.tabela.size();
    }


    private void verificaCarga() {
        int capacidade = this.tabela.size();
        double carga = (double) this.tamanho / capacidade;

        if(carga > 0.75){
            this.redimensionaTabela(capacidade*2);
        }else if(carga < 0.25){
            this.redimensionaTabela(Math.max(capacidade/2,10));
        }
    }

    public void redimensionaTabela(int novaCapacidade) {
        List<T> elementos = this.pegarTodos();
        this.tamanho = 0;
        this.tabela.clear();
        for (int i = 0; i < novaCapacidade; i++) {
            this.tabela.add(new LinkedList<T>());
        }
        for (T elemento : elementos) {
            this.inserir(elemento);
        }
    }

    public int tamanho() {
        return this.tamanho;
    }
    public void imprimirTabela(){
        for(List<T> lis : this.tabela){
            System.out.print("[");
            for(int i = 0; i < lis.size(); i++){
                System.out.print("*");
            }
            System.out.println("]");
        }
    }
}
