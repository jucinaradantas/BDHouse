package br.edu.ifsp.bdhouse;



public class User {
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
