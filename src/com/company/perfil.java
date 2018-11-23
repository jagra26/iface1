package com.company;

public class perfil {
    String nome, senha;
    int login;
    perfil[] amigos;

     void perfil(String nome, String senha, int login){
        this.login = login;
        this.nome = nome;
        this.senha = senha;
    }
}
