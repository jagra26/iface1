package com.company;

public class rede {
    perfil[] usuarios;
    comunidade[] comunidades;
    Mensagem[][] mensagens;
    public rede(){
        this.usuarios = new perfil[1000];
        this.comunidades = new comunidade[1000];
        this.mensagens = new Mensagem[1000][1000];
    }
}
