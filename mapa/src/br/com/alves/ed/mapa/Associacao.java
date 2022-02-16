package br.com.alves.ed.mapa;

import br.com.alves.ed.entities.Carro;

import java.util.Objects;

public class Associacao<C, V> {
    private C chave;
    private V valor;

    public Associacao(C chave, V valor) {
        this.chave = chave;
        this.valor = valor;
    }

    public C getChave() {
        return chave;
    }

    public V getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Chave: " + chave + ", Valor: " + valor + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Associacao<?, ?> that = (Associacao<?, ?>) o;
        return Objects.equals(chave, that.chave) && Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(chave, valor);
    }
}
