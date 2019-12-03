/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paa_trab1;

/**
 *
 * @author patri
 */
public class Tabela implements Comparable<Tabela> {

    private char nome;
    private String codigo;
    private int frequencia;

    public Tabela(char nome, int frequencia, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
        this.frequencia = frequencia;
    }

    public Tabela(char nome) {
        this.nome = nome;
        this.codigo = "";
    }

    public Tabela() {
    }

    public char getNome() {
        return nome;
    }

    public void setNome(char nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(int frequencia) {
        this.frequencia = frequencia;
    }
    
    public String[] getString(){
        String ret[] = {String.valueOf(this.nome),String.valueOf(this.frequencia),this.codigo}; 
        return ret;
    }

    @Override
    public String toString() {

        return "n: " + nome + "f: "+ frequencia + " c: " + codigo;
    }

    @Override
    public int compareTo(Tabela t) {
        if (this.nome < t.nome) {
            return -1;
        }
        if (this.nome < t.nome) {
            return 1;
        }

        return 0;
    }

}
