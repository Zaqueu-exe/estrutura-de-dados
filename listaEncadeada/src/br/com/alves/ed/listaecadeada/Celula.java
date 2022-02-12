package br.com.alves.ed.listaecadeada;

public class Celula <T>{
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

    public T getElemento() {
        return elemento;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }
}
