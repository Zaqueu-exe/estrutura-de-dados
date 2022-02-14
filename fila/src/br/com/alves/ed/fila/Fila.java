package br.com.alves.ed.fila;

public class Fila <T>{
    private Celula primeiro;
    private Celula ultimo;
    private int tamanho;

    public Fila() {
    }

    public void inserir(T elemento){
        if(this.tamanho == 0){
            Celula novo = new Celula(elemento);
            this.primeiro = novo;
            this.ultimo = novo;
        }else{
            Celula novo = new Celula<>(elemento);
            this.ultimo.setProximo(novo);
            novo.setAnterior(this.ultimo);
            this.ultimo = novo;
        }
        this.tamanho++;
    }
    public T remover(){
        this.tamanho--;
        if(!this.posicaoValida(0)){
            throw new IndexOutOfBoundsException("Não existe elementos na fila");
        }
        this.primeiro.setAnterior(null);
        this.primeiro = this.primeiro.getProximo();
        Celula removido = this.primeiro;
        return (T) removido.getElemento();
    }

    public boolean vazia(){
        return this.tamanho == 0;
    }

    public int tamanho(){
        return this.tamanho;
    }
    public T espiar(){
        return (T) this.primeiro.getElemento();
    }

    public  void limpar(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public boolean contem(T elemento){
        Celula atual = this.primeiro;
        while (atual != null){
            if(atual.getElemento().equals(elemento)){
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    private boolean posicaoValida(int posicao){
        return posicao >= 0 && posicao < this.tamanho;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Celula atual = this.primeiro;
        while(atual != null){
            sb.append(atual.getElemento());
            atual = atual.getProximo();
        }
        return sb.toString();
    }


}
