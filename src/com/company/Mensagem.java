package com.company;

public class Mensagem {
    int remetenteLog;
    int destinatarioLog;
    boolean lida;
    String msg;
    public Mensagem(int remetente, int destinatario, String msg)
    {
        this.remetenteLog = remetente;
        this.destinatarioLog = destinatario;
        this.msg = msg;
        this.lida = false;
    }
}
