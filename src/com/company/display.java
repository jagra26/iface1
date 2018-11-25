package com.company;

import java.util.Scanner;

public class display {
    public void menu(){
        System.out.print("bem vindo ao iface\n");
        System.out.print("entrar - digite 1\n");
        System.out.print("sair -  digite 2\n");
        System.out.print("novo usuario - digite 3\n");
    }
    public boolean decisaoInicial(boolean cont, rede rede1, boolean log)
    {
        Scanner entrada = new Scanner(System.in);
        int i = entrada.nextInt();
        switch (i)
        {
            case 1 :
                System.out.print("digite o login\n");
                int login = entrada.nextInt();
                System.out.print("digite a senha\n");
                int senha = entrada.nextInt();
                if (rede1.usuarios[login].senha == senha)
                {
                    log = true;
                    System.out.print("seja bem vindo ao iface\n");
                }
                else{
                    System.out.print("senha incorreta\n");
                    menu();
                    return decisaoInicial(cont, rede1, log);
                }
                break;
            case 2 :
                cont = false;
                break;
            case 3:
                System.out.print("digite o login -- numero de 0 a 999\n");
                int login = entrada.nextInt();
                System.out.print("digite a senha -- numero inteiro\n");
                int senha = entrada.nextInt();
                System.out.print("digite o nome -- numero inteiro\n");
                String nome = entrada.nextLine();


                break;
        }
        return cont;

    }
}
