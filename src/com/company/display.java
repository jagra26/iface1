package com.company;

import java.util.Scanner;

public class display {
    public void menu(){
        System.out.print("bem vindo ao iface\n");
        System.out.print("entrar - digite 1\n");
        System.out.print("sair -  digite 2\n");
        System.out.print("novo usuario - digite 3\n");
    }
    public boolean inverte(boolean value)
    {
        if (value){
            return false;
        }else{
            return true;
        }
    }
    boolean entrar(boolean cont, rede rede1, boolean log){
        Scanner entrada = new Scanner(System.in);
        System.out.print("digite o login\n");
        int senha, login;
        login = entrada.nextInt();
        System.out.print("digite a senha\n");
        senha = entrada.nextInt();
        if (rede1.usuarios[login].senha == senha)
        {
            System.out.print("seja bem vindo ao iface\n");
        }
        else{
            System.out.print("senha incorreta\n");
            menu();
            return decisaoInicial(cont, rede1, log);
        }
        return cont;
    }
    boolean novoUsuario(boolean cont, rede rede1, boolean log){
        Scanner entrada = new Scanner(System.in);
        int senha, login;
        System.out.print("digite o login -- numero de 0 a 999\n");
        login = entrada.nextInt();
        if (rede1.ocupado[login] == 0)
        {

            System.out.print("digite a senha -- numero inteiro\n");
            senha = entrada.nextInt();
            System.out.print("digite o nome \n");
            String nome = entrada.next();
            rede1.usuarios[login] = new perfil(login, senha, nome);
            System.out.print("usuario cadastrado\n");
            entrar(cont, rede1, log);
        }else{
            System.out.print("login ocupado\n");
            menu();
            return decisaoInicial(cont, rede1, log);
        }
        return cont;
    }
    public boolean decisaoInicial(boolean cont, rede rede1, boolean log)
    {
        Scanner entrada = new Scanner(System.in);
        int senha, login;
        int i = entrada.nextInt();
        switch (i)
        {
            case 1 :
                entrar(cont, rede1, log);
                break;
            case 2 :
                cont = false;
                System.out.print("saindo...\n");
                break;
            case 3:
                novoUsuario(cont, rede1, log);
                break;
        }
        return cont;

    }
    
}
