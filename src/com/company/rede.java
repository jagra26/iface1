package com.company;

public class rede {
    perfil[] usuarios;
    comunidade[] comunidades;
    Mensagem[][] mensagens;
    public rede(){
        this.usuarios = new perfil[1000];
        this.comunidades = new comunidade[1000];
        this.mensagens = new Mensagem[100][1000];
        for (int i = 0; i<100; i++){
            for (int j = 0; j< 1000; j++){
                this.mensagens[i][j] = new Mensagem();
            }
        }
    }
}
