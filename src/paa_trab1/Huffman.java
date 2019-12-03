/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paa_trab1;

import static java.lang.System.exit;
import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author patri
 */
public class Huffman {

    private LinkedList<Elemento> elementos;
    private LinkedList<Tabela> tabela;
    private String texto;
    private int tamString;
    private int econo;

    public Huffman() {
    }

    public Huffman(String texto) {
        this.texto = texto;
    }

    public void executar(String texto) {
        
        captura(texto);
        gulosa();
        buscaEmProfudidade();
        //imprimirTabela();
    }

    public void captura(String texto) {//O(n²)  emp: 2n² + 10n - 4 +nlogn

        this.elementos = new LinkedList<>(); // atrib
        this.tabela = new LinkedList<>(); // atrib

        this.tamString = texto.length(); //atrib
        this.econo = 0;
        char[] texto1 = texto.toCharArray(); //atrib

        Elemento neo = new Elemento(Character.toString(texto1[0]), 1); // atrib + index
        this.elementos.add(neo); //add

        //index
        for (int i = 1; i < this.tamString; i++) { //(cmp + inc) * (n-1)

            Elemento neo1 = new Elemento(Character.toString(texto1[i]), 1); //atrib  + index

            int a = this.elementos.indexOf(neo1); //atrib + n
            if (a != -1) { //cmp

                this.elementos.get(a).incFrequencia(); // index + inc
            } else {
                this.elementos.add(neo1);
            }

        }

        Collections.sort(elementos);//n logn

    }

    public void gulosa() { //O(n²logn) emp: (n² - n)logn + 17n-10
        Elemento ele1 = new Elemento();
        Elemento ele2 = new Elemento();

        if (this.elementos.size() == 1) { //cmp
            Tabela t = new Tabela(); //atrib
            t.setNome(this.elementos.getLast().getNome().charAt(0)); //atrib + index
            t.setFrequencia(this.elementos.getLast().getFrequencia()); //atrib
            t.setCodigo(this.elementos.getLast().boolString(this.elementos.getLast().getValor())); //atrib
            this.tabela.add(t); //add

        }

        while (true) { //( n - 1)*cmp
            if (this.elementos.size() == 1) {//cmp
                break;
            }

            ele1 = this.elementos.get(this.elementos.size() - 1); //atrib
            ele2 = this.elementos.get(this.elementos.size() - 2); //atrib
            String nome = ele1.getNome() + ele2.getNome(); //atrib + som
            int freq = ele1.getFrequencia() + ele2.getFrequencia(); //atrib + som

            Elemento eleAdd = new Elemento(nome, freq); //atrib

            if (ele1.getFrequencia() > ele2.getFrequencia()) { //cmp
                eleAdd.setEsquerda(ele1); //atrib
                eleAdd.setDireita(ele2); //atrib
                ele1.setValor(false); //atrib
                ele2.setValor(true); //atrib
            } else {
                eleAdd.setEsquerda(ele2);
                eleAdd.setDireita(ele1);
                ele2.setValor(false);
                ele1.setValor(true);
            }

            eleAdd.setRaiz(true); //atrib
            this.elementos.add(eleAdd); //atrib

            this.elementos.remove(ele1); //rem
            this.elementos.remove(ele2); //rem

            Collections.sort(this.elementos);//nlog n

        }

    }

    public void buscaEmProfudidade() { // O(n²logn) emp: 4n²logn+12n²+3nlogn-24
        LinkedList<Elemento> trajeto = new LinkedList<>(); //trib

        Elemento last = new Elemento();

        trajeto.add(this.elementos.getFirst()); // atrib

        if (!this.elementos.getLast().isRaiz()) { // cmp
            return;
        }

        while (true) { //4n - 3

            last = trajeto.getLast();//atrib + index

            if (last.isRaiz()) { //cmp

                if (last.getEsquerda().isVisitado() && last.getDireita().isVisitado()) {
                    trajeto.removeLast(); 
                    if (trajeto.isEmpty()) { 
                        break;
                    }
                }

                if (!last.getEsquerda().isVisitado()) { 

                    last.getEsquerda().setVisitado(true);
                    trajeto.add(last.getEsquerda());

                } else {

                    if (!last.getDireita().isVisitado()) { 
                        last.getDireita().setVisitado(true); 
                        trajeto.add(last.getDireita()); 
                    }
                }

            } else {
                codificaCao(trajeto); //nlogn + 12n + 7
                trajeto.removeLast(); //rem+index

            }

        }
    }

    private void codificaCao(LinkedList<Elemento> trajeto) {//O(nlogn) emp: nlogn + 12n + 7

        int controle = 0;//atrib
        int nbits = 0; //atrib
        Tabela t1 = new Tabela(trajeto.getLast().getNome().toCharArray()[0], trajeto.getLast().getFrequencia(), ""); //atrib + index
        for (Elemento ele : trajeto) {//n(cmp + atrib + inc);
            if (controle != 0) { //cmp
                t1.setCodigo(t1.getCodigo() + ele.boolString(ele.getValor())); //index + soma
                nbits++; //inc
            } else {
                controle++;
            }
        }

        nbits = nbits * t1.getFrequencia(); // multi
        this.econo = this.econo + nbits; //som
        this.tabela.add(t1);// add
        Collections.sort(this.tabela); //nlogn
    }

    public LinkedList<Tabela> getTabela() {
        return tabela;
    }

    public int getTamString() {
        return tamString;
    }

    public int getEcono() {
        return econo;
    }

    public void imprimir() {

        for (Elemento Elemento1 : this.elementos) {
            System.out.println(Elemento1.getNome() + " " + Elemento1.getFrequencia());

        }
    }

    public void imprimirTabela() {
        for (Tabela tabela1 : this.tabela) {
            System.out.println(tabela1.getNome() + ": " + tabela1.getCodigo());
        }
    }

    public String getTexto() {
        return texto;
    }


}
