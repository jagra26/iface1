package com.company;

import java.util.Scanner;

public class display {
    public void menu(){
        System.out.print("bem vindo ao iface\n");
        System.out.print("entrar - digite 1\n");
        System.out.print("sair -  digite 2\n");
        System.out.print("novo usuario - digite 3\n");
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
            while (log)
            {
               log = menuUser(rede1, login, log);
            }

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
    public void info(rede rede1, int login)
    {
        String nome = "Nome: " + rede1.usuarios[login].nome + "\n";
        System.out.println(nome);
        System.out.print("Login: ");
        System.out.println(login);
        System.out.print("\n Amigos: \n");
        if (sumVector(rede1.usuarios[login].amigos) == 0)
        {
            System.out.print("Você não possui amigos\n");
        }else{
            System.out.print("login -- nome\n");
            for (int i=0; i<1000; i++)
            {
                if (rede1.usuarios[login].amigos[i] == 1){
                    System.out.println(i);
                    System.out.print(" -- ");
                    System.out.println(rede1.usuarios[i].nome);
                    System.out.print("\n");
                }
            }
        }
    }
    public int sumVector(int[]vector)
    {
        int sum = 0;
        for(int i = 0; i<1000 ; i++)
        {
            sum += vector[i];
        }
        return sum;
    }
    public perfil edit(perfil conta)
    {
        System.out.print("Digite o novo nome:");
        Scanner entrada = new Scanner(System.in);
        conta.nome = entrada.nextLine();
        System.out.print("Nome alterado com sucesso\n\n");
        return conta;
    }
    public void novaComunidade(rede rede1, perfil admin)
    {
        System.out.print("digite o titulo da comunidade:\n");
        Scanner entrada  = new Scanner(System.in);
        String titulo = entrada.nextLine();
        int numero;
        boolean livre = false;
        do {
            System.out.print("digite o numero da comunidade - inteiro de 0 a 999\n");
            numero = entrada.nextInt();
            if (rede1.numerosComunidades[numero] == 1){
                System.out.print("numero ocupado, digite outro\n");
            }else{
                livre = true;
            }
        }while (!livre);
        rede1.numerosComunidades[numero] = 1;
        rede1.comunidades[numero] = new comunidade(titulo, admin);
        System.out.printf("comunidade %s criada com sucesso! \n", titulo);
    }
    public boolean menuUser(rede rede1, int login, boolean log)
    {
        System.out.print("Editar perfil - digite 1\n");
        System.out.print("Adicionar amigos - digite 2\n");
        System.out.print("Enviar mensagem - digite 3\n");
        System.out.print("Criar comunidade - digite 4\n");
        System.out.print("Participar de comunidade - digite 5\n");
        System.out.print("Informações da conta - digite 6\n");
        System.out.print("Sair - digite 7\n");
        System.out.print("Excluir conta - digite 8\n");
        Scanner entrada = new Scanner(System.in);
        int i = entrada.nextInt();
        switch (i) {
            case 1:
                rede1.usuarios[login] = edit(rede1.usuarios[login]);
                break;
            case 4:
                novaComunidade(rede1, rede1.usuarios[login]);
                break;
            case 6:
                info(rede1, login);
                break;
            case 7:
                log = false;
                break;
        }
        return log;
    }

}
