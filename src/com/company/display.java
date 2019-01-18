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
        if ((rede1.usuarios.get(login)!= null) && rede1.usuarios.get(login).senha == senha)
        {
            System.out.printf("seja bem vindo ao iface %s\n", rede1.usuarios.get(login).nome);
            while (log)
            {
               log = menuUser(rede1, login, log);
            }

        }else{
            System.out.print("senha incorreta\n");
            menu();
            return decisaoInicial(cont, rede1, log);
        }
        return cont;
    }
    boolean novoUsuario(boolean cont, rede rede1, boolean log){
        Scanner entrada = new Scanner(System.in);
        int senha;
        perfil novousuario;
        System.out.print("digite a senha -- numero inteiro\n");
        senha = entrada.nextInt();
        System.out.print("digite o nome \n");
        String nome = entrada.next();
        novousuario = new perfil(senha, nome);
        rede1.usuarios.add(novousuario);
        int login = rede1.usuarios.indexOf(novousuario);
        rede1.usuarios.get(login).login = login;
        System.out.print("Seu login : " + login + "\n");
        System.out.print("usuario cadastrado\n");
        entrar(cont, rede1, log);
        return cont;
    }
    public boolean decisaoInicial(boolean cont, rede rede1, boolean log) {
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
    public void info(rede rede1, int login) {
        System.out.print(rede1.usuarios.get(login));
        if (rede1.usuarios.get(login).amigos.size() == 0)
        {
            System.out.print("Você não possui amigos\n");
        }else{
            System.out.print("nome -- login\n");
            for (int i=0; i<rede1.usuarios.get(login).amigos.size(); i++)
            {
                info(rede1, rede1.usuarios.get(login).amigos.get(i));
            }
        }
    }
    public void edit(perfil conta) {
        System.out.print("Digite o novo nome:");
        Scanner entrada = new Scanner(System.in);
        conta.nome = entrada.nextLine();
        System.out.print("Nome alterado com sucesso\n\n");

    }
    public void dispComunidade(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Nova comunidade - digite 1\n");
        System.out.print("Entrar em uma comunidade - digite 2\n");
        System.out.print("Inserir alguém na sua comunidade - digite 3\n");
        int resp = entrada.nextInt();
        switch (resp){
            case 1:
                novaComunidade(rede1, login);
                break;
            case 2:
                entrarComunidade(rede1, login);
                break;
            case 3:
                inserirComunidade(rede1, login);
                break;
        }
    }
    public void inserirComunidade (rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Insira o numero da comunidade\n");
        int numero = entrada.nextInt();
        int forasteiro;
        /*if (rede1.comunidades.get(numero) == null){
            System.out.print("comunidade não existente\n");
        }else*/ if (rede1.comunidades.get(numero).admin != login){
            System.out.print("Você não é admin dessa comunidade\n");
        }else {
            System.out.print("insira o login do usuario que deseja inserir na comunidade\n");
            entrada.nextLine();
            forasteiro = entrada.nextInt();
            rede1.comunidades.get(numero).integrantes.add(forasteiro);
        }
    }
    public void novaComunidade(rede rede1, int login) {
        System.out.print("digite o titulo da comunidade:\n");
        Scanner entrada  = new Scanner(System.in);
        String titulo = entrada.nextLine();
        comunidade novacomunidade = new comunidade(titulo, login, login);
        rede1.comunidades.add(novacomunidade);
        System.out.printf("comunidade %s criada com sucesso! \n", titulo);
        System.out.print("numero da comunidade: " + rede1.comunidades.indexOf(novacomunidade));
    }
    public void entrarComunidade(rede rede1, int login) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Insira o numero da comunidade");
        int numero = entrada.nextInt();

        String msg = "solicito entrar na comunidade " + rede1.comunidades.get(numero).titulo + "\n";
        MsgAuto(rede1, login, rede1.comunidades.get(numero).admin, msg);
        System.out.print("Solicitacão de entrada enviada\n");}
        /*/if (rede1.comunidades.get(numero) == null){
            System.out.print("comunidade não existente");
        }/else* {
            String msg = "solicito entrar na comunidade " + rede1.comunidades.get(numero).titulo + "\n";
            MsgAuto(rede1, login, rede1.comunidades.get(numero).admin.login, msg);
            System.out.print("Solicitacão de entrada enviada\n");
        }*/

    public void MsgAuto(rede rede1, int login, int destlog, String msg){
        rede1.usuarios.get(destlog).mensagens.add(new Mensagem(login, destlog, msg));
    }
    public void solicitacao(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        int amilog;
        System.out.print("Digite o login do usuario que você quer ser amigo \n");
        amilog = entrada.nextInt();
        rede1.usuarios.get(amilog).solicitacoes.add(login);
        System.out.print("solicitacao enviada!");
    }
    public void tratarSolicitacao(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        int resp;
        System.out.print(rede1.usuarios.get(login).solicitacoes.size() + "\n");
        for (Integer i: rede1.usuarios.get(login).solicitacoes
             ) {
            if (i != -1){
                System.out.printf("%s quer ser seu amigo\naceitar - digite 1\nrecusar - digite 2\n limbo - digite 3\n",
                        rede1.usuarios.get(rede1.usuarios.get(login).solicitacoes.get(i)).nome);
                resp = entrada.nextInt();
                switch (resp) {
                    case 1:
                        rede1.usuarios.get(login).amigos.add(rede1.usuarios.get(login).solicitacoes.get(i));
                        //rede1.usuarios.get(i).amigos.add(login);
                        rede1.usuarios.get(login).solicitacoes.add(i, -1);
                        System.out.printf("Voce e %s são amigos agora!\n", rede1.usuarios.get(i).nome);
                        break;
                    case 2:
                        rede1.usuarios.get(login).solicitacoes.add(i, -1);
                        break;
                    case 3:
                        break;
                }
            }
        }
    }
    public void novaMsg(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        System.out.print("digite o login do destinatario\n");
        int destlog = entrada.nextInt();
        String txt;
        System.out.print("Digite a mensagem:\n");
        entrada.nextLine();
        txt = entrada.nextLine();
        Mensagem msg = new Mensagem(login,destlog, txt);
        rede1.usuarios.get(destlog).mensagens.add(msg);
        System.out.print("mensagem enviada!");
    }
    public void msgNlidas(rede rede1, int login) {
        for (int i = 0; i <rede1.usuarios.get(login).mensagens.size() ; i++) {
            if (rede1.usuarios.get(login).mensagens.get(i).destinatarioLog == login
            && !rede1.usuarios.get(login).mensagens.get(i).lida){
                System.out.print("Mensagem de: " + rede1.usuarios.get(rede1.usuarios.get(login).mensagens.get(i).remetenteLog).nome
                + "\n" + rede1.usuarios.get(login).mensagens.get(i).msg + "\n");
                rede1.usuarios.get(login).mensagens.get(i).lida = true;
            }
        }
    }
    public void msgDoArroba(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        System.out.print("digite o login da pessoa\n");
        int remlog = entrada.nextInt();
        for (Mensagem msg: rede1.usuarios.get(login).mensagens
        ) {
            if (msg.destinatarioLog == login && msg.remetenteLog == remlog){
                System.out.print("mensagem de " + rede1.usuarios.get(remlog).nome +
                        "\n" + msg.msg + "\n-----------\n");
                msg.lida = true;
            }
        }
    }
    public void dispMsg(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escrever mensagem - digite 1\n");
        System.out.print("Ler mensagens não lidas - digite 2\n");
        System.out.print("Ler mensagens de alguém especifico - digite 3\n");
        int i = entrada.nextInt();
        switch (i){
            case 1:
                novaMsg(rede1, login);
                break;
            case 2:
                msgNlidas(rede1, login);
                break;
            case 3:
                msgDoArroba(rede1, login);
                break;

        }
    }
    public void index(rede rede1){
        System.out.print("lista de usuários\n login - nome\n");
        for (int i = 0; i<rede1.usuarios.size(); i++){
            System.out.print(rede1.usuarios.get(i));
        }
        System.out.print("lista de comunidades\n numero - titulo - tamanho\n");
        for (int i = 0; i<rede1.comunidades.size(); i++){
            System.out.print(i + " " + rede1.comunidades.get(i) +"\n");
        }
    }
    public boolean menuUser(rede rede1, int login, boolean log) /*terminar*/{
        System.out.print("Editar perfil - digite 1\n");
        System.out.print("Adicionar amigos - digite 2\n");
        System.out.print("Mensagens - digite 3\n");
        System.out.print("Comunidades - digite 4\n");
        System.out.print("Informações da conta - digite 5\n");
        System.out.print("Sair - digite 6\n");
        System.out.print("Excluir conta - digite 7\n");
        System.out.print("Solicitações de amizade - digite 8\n");
        System.out.print("Indice do iface - digite 9\n");
        Scanner entrada = new Scanner(System.in);
        int i = entrada.nextInt();
        int j;
        switch (i) {
            case 1:
                edit(rede1.usuarios.get(login));
                break;
            case 2:
                solicitacao(rede1, login);
                break;
            case 3:
                dispMsg(rede1, login);
                break;
            case 4:
                dispComunidade(rede1, login);
                break;
            case 5:
                info(rede1, login);
                break;
            case 6:
                log = false;
                break;
            case 7:
                System.out.print("tem certeza que deseja excluir a conta?\n Sim - digite 1\n Não - digite 2\n");
                j = entrada.nextInt();
                if (j==1){
                    rede1.usuarios.remove(login);
                    menu();
                    log = decisaoInicial(true, rede1, log);
                }
                break;
            case 8:
                if (rede1.usuarios.get(login).solicitacoes.size() != 0)
                {
                    tratarSolicitacao(rede1, login);
                    break;
                }else{
                    System.out.print("Você não possui solicitações\n");
                }
                break;
            case 9:
                index(rede1);
                break;
        }
        return log;
    }

}
