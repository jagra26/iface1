package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        rede iface = new rede();
        display disp = new display();
        boolean i = true;
        boolean logado = false;
        while (i){
            disp.menu();
            i = disp.decisaoInicial(i, iface, logado);
            if(!i)
            {
                break;
            }
            //System.out.println(2);

        }

    }

}
