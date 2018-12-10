package br.edu.ifsp.bdhouse;

import java.io.Serializable;

public class Comodo implements Serializable {

    public int id;
    public String nome;
    public boolean aceso = false;

    @Override
    public String toString(){
        return id + " - " + nome + " : " + (aceso ? "Aceso" : "Apagado");

    }
}
