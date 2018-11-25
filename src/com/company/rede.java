package com.company;

public class rede {
    perfil[] usuarios;
    int[] ocupado;
    void novoPerfil (String nome, int senha, int login){
        this.usuarios[login].senha = senha;
        this.usuarios[login].login = login;
        this.usuarios[login].nome = nome;
        this.ocupado[login] = 1;
    }
    void remove (int login){
        this.ocupado[login] = 0;

    }
    public boolean existe(int login)
    {
        if(this.ocupado[login] == 1) {
            return true;
        }
        return false;
    }
    public rede(){
        this.usuarios = new perfil[1000];
        this.ocupado = new int[1000];
        for (int i; i<1000; i++)
        {
            this.usuarios[i].perfil();
            this.ocupado[i] = 0;
        }
    }
}
