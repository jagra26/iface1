package com.company;

public class perfil {
    String nome;
    int senha;
    int login;
    int[] amigos;

    public perfil (){
        this.senha = -1;
        this.nome = "null";
        this.login = -1;
        this.amigos = new int[1000];
        for(int i = 0; i<1000; i++)
        {
            this.amigos[i] = 0;
        }
    }
    public perfil (int login, int senha, String nome){
        this.senha = senha;
        this.nome = nome;
        this.login = login;
        this.amigos = new int[1000];
        for(int i = 0; i<1000; i++)
        {
            this.amigos[i] = 0;
        }
    }
     public void setNome(String nome){
         this.nome = nome;
     }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    public void setLogin(int login) {
        this.login = login;
    }
}
