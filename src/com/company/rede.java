package com.company;

public class rede {
    perfil[] usuarios;
    int[] ocupado;
    comunidade[] comunidades;
    public rede(){
        this.usuarios = new perfil[1000];
        this.ocupado = new int[1000];
        this.comunidades = new comunidade[1000];
        for (int i = 0; i <1000; i++)
        {
            this.usuarios[i] = new perfil();
            this.ocupado[i] = 0;
            this.comunidades[i] = new comunidade();
        }
    }
}
