package com.company;

public class comunidade {
    String titulo;
    int[] integrantes;
    int tamanho;
    perfil admin;


    public comunidade ()
    {
        this.titulo = "null";
        this.tamanho = 0;
        this.integrantes = new int[1000];
        this.admin = new perfil();
    }
    public comunidade (String titulo, perfil admin, int login)
    {
        this.titulo = titulo;
        this.admin = admin;
        this.tamanho = 1;
        this.integrantes = new int[1000];
        this.integrantes[login] = 1;

    }
}
