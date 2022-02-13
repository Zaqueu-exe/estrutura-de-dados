package br.com.alves.ed.pilha;

public class Celula <T> {
    private Celula proximo;
    private Celula anterior;
    private T elemento;

    public Celula(Celula proximo, T elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Celula(T elemento) {
        this.elemento = elemento;
    }

    public Celula getProximo() {
        return proximo;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public T getElemento() {
        return elemento;
    }

    @Override
    public String toString(){
        return this.elemento + "";
    }

}
