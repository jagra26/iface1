package com.company;

import java.util.*;

public class perfil {
    String nome;
    int senha;
    int login;
    ArrayList<Integer> amigos;
    ArrayList<Integer> solicitacoes;
    ArrayList<Mensagem> mensagens;

    @Override
    public String toString() {
        return "nome: " + this.nome + "-- login: " + this.login + "\n";
    }

    public perfil ( int senha, String nome){
        this.senha = senha;
        this.nome = nome;
        this.amigos = new ArrayList<Integer>();
        this.solicitacoes = new ArrayList<Integer>();
        this.mensagens = new ArrayList<Mensagem>();
    }
}
