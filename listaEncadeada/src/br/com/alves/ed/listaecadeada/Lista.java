package br.com.alves.ed.listaecadeada;

public class Lista <T>{
    private Celula primeiro;
    private Celula anterior;
    private Celula ultimo;
    private int totalDeElementos;

    public Lista(){
    }

    public void inserir(T elemento){
        if(this.totalDeElementos == 0){
            this.inserirNoComeco(elemento);
        }else{
            Celula nova = new Celula(elemento);
            this.ultimo.setProximo(nova);
            nova.setAnterior(this.ultimo);
            this.ultimo = nova;
            this.totalDeElementos++;
        }
    }

    public void inserirNoComeco(T elemento){
        if(this.totalDeElementos == 0){
            Celula nova = new Celula(elemento);
            this.primeiro = nova;
            this.ultimo = nova;
        }else{
            Celula nova = new Celula(this.primeiro, elemento);
            this.primeiro.setAnterior(nova);
            this.primeiro = nova;
        }
        this.totalDeElementos++;
    }

    public void inserir(int posicao, T elemento){
        if(posicao == 0){
            this.inserirNoComeco(elemento);
        }else if(posicao == this.totalDeElementos){
            this.inserir(elemento);
        }else{
            Celula anterior = this.pegarCelula(posicao-1);
            Celula proxima = anterior.getProximo();
            Celula nova = new Celula(anterior.getProximo(), elemento);
            nova.setAnterior(anterior);
            anterior.setProximo(nova);
            proxima.setAnterior(nova);
            this.totalDeElementos++;
        }
    }

    private Celula<T> pegarCelula(int posicao){
        if(!posicaoOcupada(posicao)){
            throw  new IllegalArgumentException("Posição não existe");
        }
        Celula atual = primeiro;
        for(int i = 0; i < posicao; i++){
            atual = atual.getProximo();
        }
        return atual;
    }

    public T pegar(int posicao){
        return this.pegarCelula(posicao).getElemento();
    }

    public void remover(int posicao){
        if(!this.posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição não existe");
        }
        if(posicao == 0){
            this.removerDoComeco();
        }else if(posicao == this.totalDeElementos -1){
            this.removerFim();
        }else{
            Celula anterior = this.pegarCelula(posicao-1);
            Celula atual = anterior.getProximo();
            Celula proxima = atual.getProximo();

            anterior.setProximo(proxima);
            proxima.setAnterior(anterior);
            this.totalDeElementos--;
        }
    }

    public void removerDoComeco(){
        if(this.posicaoOcupada(0)){
            throw new IllegalArgumentException("Posição não existe");
        }
        this.primeiro = this.primeiro.getProximo();
        this.totalDeElementos--;
        if(this.totalDeElementos == 0){
            this.ultimo = null;
        }
    }
    public void limpar(){
        this.primeiro = null;
        this.ultimo = null;
        this.totalDeElementos = 0;
    }


    public void removerFim(){
        if(!this.posicaoOcupada(this.totalDeElementos-1)){
            throw new IllegalArgumentException("Posiçã não existe");
        }
        if(this.totalDeElementos== 1){
            this.removerDoComeco();
        }else{
            Celula penultima = this.ultimo.getAnterior();
            penultima.setProximo(null);
            this.ultimo = penultima;
            this.totalDeElementos--;
        }
    }

    public boolean seExiste(T elemento){
        Celula atual = this.primeiro;

        while(atual != null){
            if(atual.getElemento().equals(elemento)){
                return true;
            }
            atual = atual.getProximo();
        }
        return false;
    }

    private  boolean posicaoOcupada(int posicao){
        return posicao >=0 && posicao < this.totalDeElementos;
    }
    public int tamanho(){
        return this.totalDeElementos;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        Celula atual = primeiro;
        while (atual != null){
            sb.append(atual.getElemento());
            atual = atual.getProximo();
        }
        return sb.toString();
    }
}
