package br.com.valadares.avaliadordepratos.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
    public static int lerInteiro(Scanner s){
        int numero = 0;
        try{
            numero = s.nextInt();
            s.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Digite um numero!");
            s.nextLine();
        }
        return numero;
    }
}
