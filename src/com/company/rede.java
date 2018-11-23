package com.company;

public class rede {
    perfil[] usuarios;
    void novoPerfil (String nome, String senha, int login){
        usuarios[login].senha = senha;
        usuarios[login].login = login;
        usuarios[login].nome = nome;
    }
}
