package br.com.alves.ed.entities;

public class Lista<T> {
    private T[] elementos;
    private int indice;

    public Lista() {
        this.elementos = (T[]) new Object[2];
        this.indice = 0;
    }

    public void inserir(T elemento) {
        aumentarCapacidade();
        this.elementos[this.indice] = elemento;
        this.indice++;
    }

    public void inserir(int posicao, T elemento) {
        if (!(posicao >= 0 && posicao <= this.indice)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        aumentarCapacidade();
        for (int i = this.indice - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.indice++;
    }

    public T pegar(int posicao) {
        if (!(posicao >= 0 && posicao < this.indice)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        return this.elementos[posicao];
    }

    public void remover(int posicao) {
        if (!(posicao >= 0 && posicao < this.indice)) {
            throw new IllegalArgumentException("Posição invalida");
        }
        for (int i = posicao; i < this.indice - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.indice--;
    }

    public boolean seExiste(T elemento) {
        boolean flag = false;
        for (int i = 0; i < this.indice; i++) {
            if (elemento.equals(this.elementos[i])) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public int tamanho() {
        return this.indice;
    }

    public int indexOf(T elemento) {
        int indice = -1;
        for (int i = 0; i < this.indice; i++) {
            if (elemento.equals(elementos[i])) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    public int lastIndexOf(T elemento) {
        int indice = -1;
        for (int i = this.indice - 1; i >= 0; i--) {
            if (elemento.equals(elementos[i])) {
                indice = i;
                break;
            }
        }
        return indice;
    }

    public boolean estarVazia() {
        return this.indice == 0;
    }

    public void limpar() {
        this.indice = 0;
    }

    private void aumentarCapacidade() {
        if (this.indice == this.elementos.length) {
            T[] novoArray = (T[]) new Object[this.indice * 2];
            for (int i = 0; i < this.indice; i++) {
                novoArray[i] = this.elementos[i];
            }
            this.elementos = novoArray;
        }
    }

    public void ajustarTamanho() {
        T[] novoArray = (T[]) new Object[this.indice + 2];
        for (int i = 0; i < this.indice; i++) {
            novoArray[i] = this.elementos[i];
        }
        this.elementos = novoArray;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.indice; i++) {
            sb.append(elementos[i]);
        }
        return sb.toString();
    }
}
