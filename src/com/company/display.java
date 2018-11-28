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
        if ((rede1.usuarios[login]!= null) && rede1.usuarios[login].senha == senha)
        {
            System.out.printf("seja bem vindo ao iface %s\n", rede1.usuarios[login].nome);
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
        int senha, login;
        System.out.print("digite o login -- numero de 0 a 999\n");
        login = entrada.nextInt();
        if (rede1.usuarios[login] == null)
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
                    System.out.print(i);
                    System.out.print(" -- ");
                    System.out.print(rede1.usuarios[i].nome);
                    System.out.print("\n");
                }
            }
        }
    }
    public int sumVector(int[]vector) {
        int sum = 0;
        for(int i = 0; i<1000 ; i++)
        {
            sum += vector[i];
        }
        return sum;
    }
    public perfil edit(perfil conta) {
        System.out.print("Digite o novo nome:");
        Scanner entrada = new Scanner(System.in);
        conta.nome = entrada.nextLine();
        System.out.print("Nome alterado com sucesso\n\n");
        return conta;
    }
    public void dispComunidade(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        System.out.print("Nova comunidade - digite 1\n");
        System.out.print("Entrar em uma comunidade - digite 2\n");
        System.out.print("Inserir alguém na sua comunidade - digite 3\n");
        int resp = entrada.nextInt();
        switch (resp){
            case 1:
                novaComunidade(rede1, rede1.usuarios[login], login);
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
        if (rede1.comunidades[numero] == null){
            System.out.print("comunidade não existente\n");
        }else if (rede1.comunidades[numero].admin.login != login){
            System.out.print("Você não é admin dessa comunidade\n");
        }else {
            System.out.print("insira o login do usuario que deseja inserir na comunidade\n");
            System.out.print(rede1.comunidades[numero].titulo);
            entrada.nextLine();
            forasteiro = entrada.nextInt();
            rede1.comunidades[numero].integrantes[forasteiro] = 1;
            rede1.comunidades[numero].tamanho++;
        }
    }
    public void novaComunidade(rede rede1, perfil admin, int login) {
        System.out.print("digite o titulo da comunidade:\n");
        Scanner entrada  = new Scanner(System.in);
        String titulo = entrada.nextLine();
        int numero;
        boolean livre = false;
        do {
            System.out.print("digite o numero da comunidade - inteiro de 0 a 999\n");
            numero = entrada.nextInt();
            if (rede1.comunidades[numero] != null){
                System.out.print("numero ocupado, digite outro\n");
            }else{
                livre = true;
            }
        }while (!livre);
        rede1.comunidades[numero] = new comunidade(titulo, admin, login);
        System.out.printf("comunidade %s criada com sucesso! \n", titulo);
    }
    public void entrarComunidade(rede rede1, int login) {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Insira o numero da comunidade");
        int numero = entrada.nextInt();
        if (rede1.comunidades[numero] == null){
            System.out.print("comunidade não existente");
        }else {
            String msg = "solicito entrar na comunidade" + rede1.comunidades[numero].titulo + "\n";
            MsgAuto(rede1, login, rede1.comunidades[numero].admin.login, msg);
            System.out.print("Solicitacão de entrada enviada\n");
        }

    }
    public void MsgAuto(rede rede1, int login, int destlog, String msg){
        for (int i=0; i<100; i++)
        {
            if (rede1.mensagens[i][login].remetenteLog == -1){
                rede1.mensagens[i][login] = new Mensagem(login, destlog, msg);
                break;
            }
        }
    }
    public void solicitacao(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        int amilog;
        System.out.print("Digite o login do usuario que você quer ser amigo \n");
        amilog = entrada.nextInt();
        rede1.usuarios[amilog].solicitacoes[login] = 1;
        System.out.print("solicitacao enviada!");
    }
    public void tratarSolicitacao(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        int resp;
        for (int i = 0; i<1000; i++)
        {
            if (rede1.usuarios[login].solicitacoes[i]==1){
                System.out.printf("%s quer ser seu amigo\naceitar - digite 1\nrecusar - digite 2\n limbo - digite 3\n",
                        rede1.usuarios[i].nome);
                resp = entrada.nextInt();
                switch (resp){
                    case 1:
                        rede1.usuarios[login].amigos[i] = 1;
                        rede1.usuarios[i].amigos[login] = 1;
                        rede1.usuarios[login].solicitacoes[i] = 0;
                        System.out.printf("Voce e %s são amigos agora!\n", rede1.usuarios[i].nome);
                        break;
                    case 2:
                        rede1.usuarios[login].solicitacoes[i] = 0;
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
        String msg;
        for (int i=0; i<100; i++)
        {
            if (rede1.mensagens[i][login].remetenteLog == -1){
                System.out.print("Digite a mensagem:\n");
                entrada.nextLine();
                msg = entrada.nextLine();
                rede1.mensagens[i][login] = new Mensagem(login, destlog, msg);
                break;
            }
        }
    }
    public void msgNlidas(rede rede1, int login) {
        for (int i=0; i<100; i++)
        {
            if (rede1.mensagens[i][login].remetenteLog !=-1){
                System.out.printf("Mensagem de %s\n", rede1.usuarios[rede1.mensagens[i][login].remetenteLog].nome);
                System.out.println(rede1.mensagens[i][login].msg);
                System.out.print("\n");
                rede1.mensagens[i][login].lida = true;
            }
        }
    }
    public void msgDoArroba(rede rede1, int login){
        Scanner entrada = new Scanner(System.in);
        System.out.print("digite o login da pessoa\n");
        int remlog = entrada.nextInt();
        for (int i=0; i<100; i++)
        {
            if (rede1.mensagens[i][login].remetenteLog == remlog){
                System.out.printf("Mensagem de %s\n", rede1.usuarios[remlog].nome);
                System.out.println(rede1.mensagens[i][login].msg);
                System.out.print("\n");
                if(!rede1.mensagens[i][login].lida) {
                    rede1.mensagens[i][login].lida = true;
                }
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
        for (int i = 0; i<1000; i++){
            if(rede1.usuarios[i]!=null){
                System.out.printf("%d - %s\n", rede1.usuarios[i].login, rede1.usuarios[i].nome);
            }
        }
        System.out.print("lista de comunidades\n numero - titulo - tamanho\n");
        for (int i = 0; i<1000; i++){
            if(rede1.comunidades[i]!=null){
                System.out.printf("%d - %s - %d\n", i, rede1.comunidades[i].titulo, rede1.comunidades[i].tamanho);
            }
        }
    }
    public boolean menuUser(rede rede1, int login, boolean log)
    {
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
                rede1.usuarios[login] = edit(rede1.usuarios[login]);
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
                    rede1.usuarios[login] = null;
                    log = false;
                }
                break;
            case 8:
                if (sumVector(rede1.usuarios[login].solicitacoes)!= 0)
                {
                    tratarSolicitacao(rede1, login);
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
