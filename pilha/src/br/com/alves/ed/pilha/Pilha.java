package br.com.alves.ed.pilha;

public class Pilha<T> {
    private Celula primeiro;
    private Celula ultimo;
    private int tamanho;

    public Pilha() {
    }

    public void inserir(T elemento){
        if(this.tamanho == 0){
            Celula novo = new Celula(elemento);
            this.primeiro = novo;
            this.ultimo = novo;
        }else{
            Celula novo = new Celula(elemento);
            this.ultimo.setProximo(novo);
            novo.setAnterior(ultimo);
            this.ultimo = novo;
        }
        this.tamanho++;
    }

    public String espiar(){
        if (this.vazia()){
            throw new ArrayIndexOutOfBoundsException("Não existe elemento na pilha");
        }
        return this.ultimo.toString();
    }

    public int pesquisarElemento(T elemento){
        int distancia = 0;
        Celula atual = this.ultimo;
        while (atual != null){
            distancia++;
            if(atual.getElemento().equals(elemento)){
                return distancia;
            }
            atual = atual.getAnterior();
        }
        return -1;
    }

    public String remove(){
        if(this.vazia()) {
            throw new ArrayIndexOutOfBoundsException("Não existe elemento na pilha");
        }
        Celula removido = this.ultimo;
        this.ultimo = removido.getAnterior();
        this.tamanho--;
        return removido.toString();
    }

    public void limpar(){
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public boolean vazia(){
        return this.tamanho == 0;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Celula atual = this.ultimo;
        while (atual != null){
            sb.append(atual.getElemento() + "\n");
            atual = atual.getAnterior();
        }
        return sb.toString();
    }

}
