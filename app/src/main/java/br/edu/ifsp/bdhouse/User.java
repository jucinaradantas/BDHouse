package br.edu.ifsp.bdhouse;

import java.io.Serializable;


public class User implements Serializable {
    public int id;
    public String nome;
    public String senha;
    public String login;
    public int grupo_usuario_id;
    public String parentesco;

    @Override
    public String toString() {
        return login + " - " + nome ;
    }
}
