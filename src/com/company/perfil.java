package com.company;

public class perfil {
    String nome;
    int senha;
    int login;
    int[] amigos;

    public perfil (){
        this.nome = "null";
        this.login = -1;
        this.amigos = new int[1000];
        for(int i; i<1000; i++)
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
