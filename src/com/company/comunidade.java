package com.company;

import java.lang.reflect.Array;
import java.util.*;

public class comunidade {
    String titulo;
    ArrayList<Integer> integrantes;
    int admin;

    @Override
    public String toString() {
        return this.titulo + " " + this.integrantes.size() + "\n";
    }

    public comunidade (String titulo, int admin, int login)
    {
        this.titulo = titulo;
        this.admin = admin;
        this.integrantes = new ArrayList<Integer>();
        this.integrantes.add(login);

    }
}
