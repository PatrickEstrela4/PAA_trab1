/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paa_trab1;

import java.util.Objects;

/**
 *
 * @author patri
 */
public class Elemento implements Comparable<Elemento> {

    private String nome;
    private int frequencia;
    private Elemento direita;
    private Elemento esquerda;
    private boolean valor;
    private boolean visitado;
    private boolean raiz;

    public Elemento(String Nome, int frequencia, Elemento esquerda, Elemento direita, boolean valor) {
        this.nome = Nome;
        this.frequencia = frequencia;
        this.direita = direita;
        this.esquerda = esquerda;
        this.valor = valor;
        this.raiz = false;
        this.visitado = false;
    }

    public Elemento(String Nome, int frequencia, Elemento esquerda, Elemento direita) {
        this.nome = Nome;
        this.frequencia = frequencia;
        this.direita = direita;
        this.esquerda = esquerda;
        this.raiz = false;
        this.visitado = false;
    }

    public Elemento(String Nome, int frequencia) {
        this.nome = Nome;
        this.frequencia = frequencia;
        this.direita = null;
        this.esquerda = null;
        this.raiz = false;
        this.visitado = false;
    }

    public Elemento() {
        this.raiz = false;
        this.visitado = false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String Nome) {
        this.nome = Nome;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }

    public Elemento getDireita() {
        return direita;
    }

    public void setDireita(Elemento direita) {
        this.direita = direita;
    }

    public Elemento getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(Elemento esquerda) {
        this.esquerda = esquerda;
    }

    public boolean getValor() {
        return valor;
    }

    public void setValor(boolean valor) {
        this.valor = valor;
    }

    public void incFrequencia() {
        this.frequencia++;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    public boolean isRaiz() {
        return raiz;
    }

    public void setRaiz(boolean raiz) {
        this.raiz = raiz;
    }

    public String boolString(boolean b) {
        return b ? "1" : "0";
    }

    @Override
    public int compareTo(Elemento t) {

        if (this.frequencia < t.getFrequencia()) {
            return 1;
        }
        if (this.frequencia > t.getFrequencia()) {
            return -1;
        }
        return 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nome);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Elemento other = (Elemento) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return true;
    }

}
